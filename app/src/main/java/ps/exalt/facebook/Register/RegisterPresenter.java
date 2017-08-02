package ps.exalt.facebook.Register;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.Data.DataRepository;
import ps.exalt.facebook.Util.Network.API.User;
import ps.exalt.facebook.Util.Network.Retrofit.RetrofitException;

/**
 * Created by Sharif on 8/2/2017.
 */

public class RegisterPresenter {
    private RegisterView registerView;
    private DataRepository dataRepository;

    public RegisterPresenter(RegisterView registerView) {
        this.registerView = registerView;
        dataRepository = DataRepository.getInstance();
    }

    public void submitRegistration(User newUser) {
        if (!validate(newUser.getId().getUsername(), 3))
            registerView.usernameValidateFail();
        else if (!validate(newUser.getId().getEmail(), 10))
            registerView.emailValidateFail();
        else if (!validate(newUser.getPassword(), 5))
            registerView.passwordValidateFail();
        else {
            dataRepository.addUser(newUser)
                    .subscribeOn(Schedulers.io())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<User>() {
                        @Override
                        public void onSubscribe(Disposable d) {

                        }

                        @Override
                        public void onNext(User user) {
                            registerView.registerSuccess();
                        }

                        @Override
                        public void onError(Throwable e) {
                            if (e instanceof RetrofitException) {
                                if (((RetrofitException) e).getResponse().code() == 409)
                                    registerView.duplicatedUser();
                            } else
                                registerView.registerFailed();
                        }

                        @Override
                        public void onComplete() {

                        }
                    });
        }
    }

    private boolean validate(String toBeValidated, int minimum) {
        if (!(toBeValidated.length() > minimum)) {
            return false;
        } else {
            return true;
        }
    }
}

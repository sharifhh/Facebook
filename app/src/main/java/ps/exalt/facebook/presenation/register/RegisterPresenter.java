package ps.exalt.facebook.presenation.register;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.data.DataRepository;
import ps.exalt.facebook.util.network.api.User;
import ps.exalt.facebook.util.network.retrofit.RetrofitException;

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
                    .subscribe(user -> registerView.registerSuccess(), throwable -> {
                        if (throwable instanceof RetrofitException) {
                            if (((RetrofitException) throwable).getResponse().code() == 409)
                                registerView.duplicatedUser();
                        } else
                            registerView.registerFailed();
                    });
        }
    }

    private boolean validate(String toBeValidated, int minimum) {
        return ((toBeValidated.length() > minimum));
    }
}

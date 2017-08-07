package ps.exalt.facebook.presenation.login;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.data.DataRepository;

/**
 * Created by Sharif on 7/31/2017.
 */

public class LoginPresenter {
    private LoginView loginView;
    private DataRepository dataRepository;

    public LoginPresenter(LoginView loginView) {
        this.loginView = loginView;
        dataRepository = DataRepository.getInstance();
    }

    public void submitLogin(String email, String password) {
        if (validateCredentials(email, password)) {
            loginView.loginSuccess();
//            dataRepository.getToken(email, password)
//                    .subscribeOn(Schedulers.io())
//                    .observeOn(AndroidSchedulers.mainThread())
//                    .subscribe(aBoolean -> {
//                        if (aBoolean) {
//                            loginView.loginSuccess();
//                        } else {
//                            loginView.loginFailed();
//                        }
//                    }, throwable -> loginView.loginFailed());
        } else {
            loginView.validateFail();
        }
    }

    private boolean validateCredentials(String email, String password) {
        if (!(email.length() > 3) || !(password.length() > 5)) {
            return false;
        } else {
            return true;
        }
    }
}

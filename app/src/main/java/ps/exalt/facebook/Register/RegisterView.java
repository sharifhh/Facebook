package ps.exalt.facebook.Register;

/**
 * Created by Sharif on 8/2/2017.
 */

public interface RegisterView {


    void registerSuccess();
    void registerFailed();
    void usernameValidateFail();
    void emailValidateFail();
    void passwordValidateFail();
    void duplicatedUser();
}

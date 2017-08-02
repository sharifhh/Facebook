package ps.exalt.facebook.register;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import butterknife.ButterKnife;
import ps.exalt.facebook.R;
import ps.exalt.facebook.util.Navigator;
import ps.exalt.facebook.util.network.api.User;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    RegisterPresenter registerPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        User newUser = new User();
        registerPresenter.submitRegistration(newUser);
    }

    @Override
    public void registerSuccess() {
        Navigator.navigateToHome(this);
    }

    @Override
    public void registerFailed() {
        progressDialog.hide();
        Toast.makeText(this, "Something went wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void usernameValidateFail() {
        progressDialog.hide();
        Toast.makeText(this, "Username must be at least 4 characters", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void emailValidateFail() {
        progressDialog.hide();
        Toast.makeText(this, "Wrong email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordValidateFail() {
        progressDialog.hide();
        Toast.makeText(this, "Password most be 6 or more", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void duplicatedUser() {
        progressDialog.hide();
        Toast.makeText(this, "Username is duplicated", Toast.LENGTH_SHORT).show();
    }
}

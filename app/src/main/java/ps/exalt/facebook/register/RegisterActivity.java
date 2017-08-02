package ps.exalt.facebook.register;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.R;
import ps.exalt.facebook.util.Navigator;
import ps.exalt.facebook.util.network.api.User;
import ps.exalt.facebook.util.network.api.UserID;

public class RegisterActivity extends AppCompatActivity implements RegisterView {

    @BindView(R.id.reg_email)
    EditText email;
    @BindView(R.id.reg_firstname)
    EditText firstName;
    @BindView(R.id.reg_lastname)
    EditText lastName;
    @BindView(R.id.reg_user)
    EditText user;
    @BindView(R.id.reg_password)
    EditText password;

    RegisterPresenter registerPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        ButterKnife.bind(this);
        registerPresenter = new RegisterPresenter(this);
    }
    @OnClick(R.id.reg_registration_btn)
    public void OnClick()
    {
        User newUser = new User();
        newUser.setTimeCreation(10);
        UserID userID = new UserID();
        userID.setEmail(email.getText().toString());
        userID.setUsername(user.getText().toString());
        newUser.setId(userID);
        newUser.setFirstName(firstName.getText().toString());
        newUser.setLastName(lastName.getText().toString());
        newUser.setPassword(password.getText().toString());
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
        //progressDialog.hide();
        Toast.makeText(this, "Wrong email", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void passwordValidateFail() {
        //progressDialog.hide();
        Toast.makeText(this, "Password most be 6 or more", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void duplicatedUser() {
        //progressDialog.hide();
        Toast.makeText(this, "Username is duplicated", Toast.LENGTH_SHORT).show();
    }
}

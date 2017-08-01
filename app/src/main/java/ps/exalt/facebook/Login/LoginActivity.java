package ps.exalt.facebook.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.R;
import ps.exalt.facebook.Util.Navigator;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.email_edit_text)
    EditText emailEditText;
    @BindView(R.id.password_edit_text)
    EditText passwordEditText;

    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        loginPresenter = new LoginPresenter(this);
    }

    @OnClick(R.id.login_button)
    public void loginTapped(View view) {
        Log.d("Clicked","tre");
        progressDialog = ProgressDialog.show(this, "Logging in ...", "Please Wait");
        new Handler().postDelayed(() -> {},2000);
        String email = emailEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        // Pass user event straight to presenter
        loginPresenter.submitLogin(email, password);
    }

    @Override
    public void loginSuccess() {
        progressDialog.hide();
        Navigator.navigateToHome(this);
        finish();
    }

    @Override
    public void loginFailed() {
        progressDialog.hide();
        Toast.makeText(this, "Login Invalid: Username or password is wrong", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateFail() {
        progressDialog.hide();
        Toast.makeText(this, "Login Invalid: User must be 4 letters or longer, and password 6 or more", Toast.LENGTH_SHORT).show();
    }
}

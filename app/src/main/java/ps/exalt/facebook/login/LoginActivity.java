package ps.exalt.facebook.login;
//l
import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.R;
import ps.exalt.facebook.SplashActivity;
import ps.exalt.facebook.util.Navigator;

public class LoginActivity extends AppCompatActivity implements LoginView {


    @BindView(R.id.email_edit_text)
    EditText emailEditText;
    @BindView(R.id.password_edit_text)
    EditText passwordEditText;
    @BindView(R.id.imageButton3)
    ImageButton goFace;
    @BindView(R.id.login_button)
    Button log;
    @BindView(R.id.reg)
    Button register;
    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

        loginPresenter = new LoginPresenter(this);
        Window window = LoginActivity.this.getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(LoginActivity.this, R.color.cardview_light_background));
        final ViewGroup transitionsContainer = (ViewGroup) findViewById(R.id.transitions_container);

        goFace.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;

                emailEditText.setVisibility(visible ? View.VISIBLE : View.GONE);
                passwordEditText.setVisibility(visible ? View.VISIBLE : View.GONE);
                log.setVisibility(visible ? View.VISIBLE : View.GONE);
                register.setVisibility(visible ? View.VISIBLE : View.GONE);
            }

        });
    }

    @OnClick(R.id.login_button)
    public void loginTapped(View view) {
        progressDialog = ProgressDialog.show(this, "Logging in ...", "Please Wait");
        new Handler().postDelayed(() -> {
            String email = emailEditText.getText().toString();
            String password = passwordEditText.getText().toString();
            loginPresenter.submitLogin(email, password);
        }, 2000);
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
package ps.exalt.facebook.Login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.transition.TransitionManager;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.Data.DataRepository;
import ps.exalt.facebook.R;
import ps.exalt.facebook.Util.Navigator;
import ps.exalt.facebook.Util.Network.API.PostLike;
import ps.exalt.facebook.Util.Network.RetrofitException;

public class LoginActivity extends AppCompatActivity implements LoginView {

    @BindView(R.id.email_edit_text)
    EditText emailEditText;
    @BindView(R.id.password_edit_text)
    EditText passwordEditText;
    @BindView(R.id.imageButton3)
    ImageButton pic;
    @BindView(R.id.login_button)
    Button log;
    @BindView(R.id.reg)
    Button reg;
    LoginPresenter loginPresenter;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        final ViewGroup transitionsContainer = (ViewGroup)findViewById(R.id.transitions_container);

       pic.setOnClickListener(new View.OnClickListener() {

            boolean visible;

            @Override
            public void onClick(View v) {
                TransitionManager.beginDelayedTransition(transitionsContainer);
                visible = !visible;
               emailEditText.setVisibility(visible ? View.VISIBLE : View.GONE);
               passwordEditText.setVisibility(visible ? View.VISIBLE : View.GONE);
                log.setVisibility(visible ? View.VISIBLE : View.GONE);
              reg.setVisibility(visible ? View.VISIBLE : View.GONE);

            }

        });
        loginPresenter = new LoginPresenter(this);
        PostLike postLike = new PostLike();
        postLike.setType("like");
        DataRepository.getInstance().likePost(postLike)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PostLike>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PostLike postLike) {
                        Log.d("Err",postLike.getType());
                    }

                    @Override
                    public void onError(Throwable e) {
                        if(e instanceof RetrofitException)
                            Log.d("Error",((RetrofitException)e).getKind()+"");
                    }

                    @Override
                    public void onComplete() {

                    }
                });
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

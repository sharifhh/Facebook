package ps.exalt.facebook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LoginActivity extends AppCompatActivity {

    @BindView(R.id.reg)
    Button Reg;
    @BindView(R.id.login)
    Button log;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);

    }
    @OnClick(R.id.login)
    public void login() {

        Intent my =new Intent(LoginActivity.this,HomeActivity.class);
        startActivity(my);

    }
}

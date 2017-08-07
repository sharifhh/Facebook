package ps.exalt.facebook;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import ps.exalt.facebook.util.Navigator;

/**
 * Created by Sharif on 7/26/2017.
 */
public class SplashActivity extends AppCompatActivity {
    private static int SPLASH_TIME_OUT = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(() -> {
            Navigator.navigateToLogin(this);
            finish();
        }, SPLASH_TIME_OUT);
    }

}

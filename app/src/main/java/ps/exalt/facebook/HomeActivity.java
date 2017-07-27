package ps.exalt.facebook;

// helllllllllllllokk

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;

public class HomeActivity extends AppCompatActivity implements HomeView{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onGettingPostsCompleted(List<Post> posts) {

    }
}

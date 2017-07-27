package ps.exalt.facebook;

// helllllllllllllokk

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import ps.exalt.facebook.API.Post;

public class HomeActivity extends AppCompatActivity implements HomeView {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    @Override
    public void onGettingPostsCompleted(List<Post> posts) {

    }
}

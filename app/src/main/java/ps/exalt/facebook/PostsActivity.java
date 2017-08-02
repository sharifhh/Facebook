package ps.exalt.facebook;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.Home.HomeActivity;

public class PostsActivity extends AppCompatActivity {


    String[] mobileArray = {"Android", "IPhone"};
    @BindView(R.id.editText3)
    EditText post_areaa;
   // @BindView(R.id.)
//    Button post;
    @BindView(R.id.button2)
    Button close;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.myanimation, R.anim.myanimation);




        post_areaa.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence str, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable str) {

                if (!post_areaa.getText().toString().isEmpty()) {

                  //  post.setTextColor(ContextCompat.getColor(PostsActivity.this, R.color.mycolor));
                }
                else if (post_areaa.getText().toString().isEmpty()) {

                  //  post.setTextColor(ContextCompat.getColor(PostsActivity.this, R.color.type));
                }
            }
        });

// keyboard

        // getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN
        );
    }

    @OnClick(R.id.imageButton)

    public void close() {
        startActivity(new Intent(PostsActivity.this, HomeActivity.class));
    }


}

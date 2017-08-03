package ps.exalt.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.home.HomeActivity;

public class PostsActivity extends AppCompatActivity {
    String[] mobileArray = {"Android", "IPhone"};
    @BindView(R.id.post_area)
    EditText post_area;
//    @BindView(R.id.button2)
//    Button close;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posts);
        ButterKnife.bind(this);
        // overridePendingTransition(R.anim.myanimation, R.anim.myanimation);
        post_area.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence str, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable str) {
                if (!post_area.getText().toString().isEmpty()) {

                    //  post.setTextColor(ContextCompat.getColor(PostsActivity.this, R.color.mycolor));
                } else if (post_area.getText().toString().isEmpty()) {

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

package ps.exalt.facebook;

import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.util.Navigator;

public class PostsActivity extends AppCompatActivity {
    String[] mobileArray = {"Android", "IPhone"};
    @BindView(R.id.post_area)
    EditText post_area;
    @BindView(R.id.post_ok)
    Button okPost;
    @BindView(R.id.post_cancel)
    Button canclePost;
    @BindView(R.id.add_image)
    ImageButton addImage;
    @BindView(R.id.imageButton)
    ImageButton addStiker;


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
                    okPost.setTextColor(ContextCompat.getColor(PostsActivity.this, R.color.mycolor));
                    okPost.setEnabled(true);
                } else if (post_area.getText().toString().isEmpty()) {
                    okPost.setTextColor(ContextCompat.getColor(PostsActivity.this, R.color.write));
                    okPost.setEnabled(false);
                }
            }
        });

    }

    @OnClick(R.id.post_ok)
    public void setOkPost() {
        Navigator.navigateToHome(this);
    }

    @OnClick(R.id.post_cancel)
    public void setCancelPost() {
        Navigator.navigateToHome(this);
    }
}

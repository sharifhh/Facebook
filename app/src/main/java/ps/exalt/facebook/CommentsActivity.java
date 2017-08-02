package ps.exalt.facebook;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.home.HomeActivity;

public class CommentsActivity extends AppCompatActivity {


    String[] mobileArray = {"Android", "IPhone"};
    @BindView(R.id.editText3)
    EditText comment;
    @BindView(R.id.button2)
    Button post;
    @BindView(R.id.imageButton)
    ImageButton close;
    @BindView(R.id.comment_list)
    ListView lv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_comment);
        ButterKnife.bind(this);
        overridePendingTransition(R.anim.myanimation, R.anim.myanimation);

      /*  EditText comment=(EditText)findViewById(R.id.editText3);
        Button post=(Button)findViewById(R.id.button2);
        ImageButton close =(ImageButton)findViewById(R.id.imageButton);*/
        // Get a handle to the list view


        // Convert ArrayList to array
        ArrayAdapter adapter = new ArrayAdapter<String>(this,
                R.layout.comment_listt, mobileArray);

        ListView listView = (ListView) findViewById(R.id.comment_list);
        listView.setAdapter(adapter);


        comment.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence str, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence str, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable str) {

                if (!comment.getText().toString().isEmpty()) {

                    post.setTextColor(ContextCompat.getColor(CommentsActivity.this, R.color.mycolor));
                }
                else if (comment.getText().toString().isEmpty()) {

                    post.setTextColor(ContextCompat.getColor(CommentsActivity.this, R.color.type));
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
        startActivity(new Intent(CommentsActivity.this, HomeActivity.class));
    }


}

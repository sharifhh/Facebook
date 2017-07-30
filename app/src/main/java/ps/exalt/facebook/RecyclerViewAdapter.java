package ps.exalt.facebook;

import android.content.Context;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import de.hdodenhof.circleimageview.CircleImageView;
import ps.exalt.facebook.API.Post;

/**
 * Created by  Mais
 */
public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private final List<Post> posts;
    private LayoutInflater inflater;
    private Context context;

    RecyclerViewAdapterCalls callbacks;

    

   public RecyclerViewAdapter(Context context, List<Post> posts, RecyclerViewAdapterCalls callbacks) {
        this.context = context;
        this.posts= posts;
        this.callbacks = callbacks;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.post_row, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
      holder.user_name.setText("Mais abu helou");//posts.get(position).getName());
       holder.date.setText("2 hours ago ");//posts.get(position).getDate());
        holder.post.setText("Welcome all");
    //    Picasso.with(context).load("http://i.imgut.com/DvpvklR.png").transform(new CropCircleTransformation()).into(holder.pic);
     //   holder.icon.setImageResource(contacts.get(position).getFavIcon());
    }

    @Override
    public int getItemCount() {
        return 10;//contacts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txt_name)
        TextView user_name;
        @BindView(R.id.txt_date)
        TextView date;
        @BindView(R.id.post_area)
        TextView post;

        @BindView(R.id.like_btn)
        ImageButton likes;
        @BindView(R.id.comment_btn)
        ImageButton comments;
        @BindView(R.id.profile_image)
        CircleImageView pic;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @OnClick(R.id.like_btn)
        void likess() {
            // Click action
            likes.setColorFilter(Color.BLUE);
        /*Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
        startActivity(intent);*/
        }

    }



    public interface RecyclerViewAdapterCalls {
    //    void onFavouriteButtonClicked(Contact contact);
    }
}
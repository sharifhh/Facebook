package ps.exalt.facebook.presenation.home.util;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;
import java.util.List;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.CommentsActivity;
import ps.exalt.facebook.presenation.home.HomeActivity;
import ps.exalt.facebook.util.network.api.Post;
import ps.exalt.facebook.R;


/**
 * Created by  Mais
 */
public class HomeRecyclerViewAdapter extends RecyclerView.Adapter<HomeRecyclerViewAdapter.MyViewHolder> {

    private final List<Post> posts;
    private LayoutInflater inflater;
    private Context context;

    RecyclerViewAdapterCalls callbacks;



   public HomeRecyclerViewAdapter(Context context, List<Post> posts, RecyclerViewAdapterCalls callbacks) {
        this.context = context;
        this.posts= posts;
       Log.d("postsssssssss",posts.get(0).getPostid() + "");
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

       holder.user_name.setText(posts.get(position).getUser().getFirstName() + posts.get(position).getUser().getLastName());//posts.get(position).getName());
       Date date = new Date(posts.get(position).getTimeCreation());

        holder.date.setText(date.toString());//posts.get(position).getDate());
        holder.post.setText(posts.get(position).getContent());
    //    Picasso.with(context).load("http://i.imgut.com/DvpvklR.png").transform(new CropCircleTransformation()).into(holder.pic);
     //   holder.icon.setImageResource(contacts.get(position).getFavIcon());
    }

    @Override
    public int getItemCount() {
        return posts.size();//contacts.size();
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
        ImageButton pic;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            pic.setScaleType(ImageView.ScaleType.FIT_XY);
        }

        @OnClick(R.id.like_btn)
        void likess() {
            // Click action
            likes.setColorFilter(ContextCompat.getColor(context, R.color.mycolor));
        /*Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
        startActivity(intent);*/




        }
        @OnClick(R.id.comment_btn)
        void setComments() {
            comments.setColorFilter(ContextCompat.getColor(context, R.color.mycolor));
            Intent intent = new Intent(context, CommentsActivity.class);
            context.startActivity(intent);


        }

        @OnClick(R.id.profile_image)
        void viewProfile() {

            pic.setScaleType(ImageView.ScaleType.CENTER_CROP);


           /* // finally i use this code to execute the animation
            Animation animationScaleUp = AnimationUtils.loadAnimation(context, R.anim.popin);
            Animation animationScaleDown = AnimationUtils.loadAnimation(context, R.anim.popout);

            AnimationSet growShrink = new AnimationSet(true);
            growShrink.addAnimation(animationScaleUp);
            growShrink.addAnimation(animationScaleDown);
            pic.startAnimation(growShrink);*/


        }


        @OnClick(R.id.close_post)
        void  setClose(){
            AlertDialog.Builder faceBuilder = new AlertDialog.Builder(context);
            View view = inflater.inflate(R.layout.mydil, null);
            faceBuilder.setView(view);
            faceBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    Toast.makeText(context, "The post is hidden now !",
                            Toast.LENGTH_LONG).show();;
                    Intent intent = new Intent(context, HomeActivity.class);
                    context.startActivity(intent);

                }
            });
            faceBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });
            AlertDialog dialog = faceBuilder.create();
            dialog.show();

        }

    }



    public interface RecyclerViewAdapterCalls {
    //    void onFavouriteButtonClicked(Contact contact);
    }
}
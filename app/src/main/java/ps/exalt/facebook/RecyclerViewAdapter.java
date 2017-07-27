package ps.exalt.facebook;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;

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
      holder.user_name.setText("EE");//posts.get(position).getName());
       holder.date.setText("333");//posts.get(position).getEmail());
    //    Picasso.with(context).load("http://i.imgut.com/DvpvklR.png").transform(new CropCircleTransformation()).into(holder.pic);
     //   holder.icon.setImageResource(contacts.get(position).getFavIcon());
    }

    @Override
    public int getItemCount() {
        return 5;//contacts.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.txt_name)
        TextView user_name;
        @BindView(R.id.txt_date)
        TextView date;
        @BindView(R.id.count_like_text)
        TextView count_liek;
        @BindView(R.id.comment_count_text)
        TextView count_comment;
        @BindView(R.id.like_btn)
        Button likes;
        @BindView(R.id.comment_btn)
        Button comments;
        @BindView(R.id.profile_image)
        CircleImageView pic;


        public MyViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);

        }

        @Override
        public void onClick(View view) {

        }
    }

    public interface RecyclerViewAdapterCalls {
    //    void onFavouriteButtonClicked(Contact contact);
    }
}
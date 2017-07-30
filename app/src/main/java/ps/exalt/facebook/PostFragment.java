package ps.exalt.facebook;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.API.Post;
import ps.exalt.facebook.Data.Remote.HidingScroling;


public class PostFragment extends Fragment implements RecyclerViewAdapter.RecyclerViewAdapterCalls {

    public static final String KEY_POSITION = "KEY_POSITION";

    @BindView(R.id.recycler_view1)
    RecyclerView  recyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.floatingActionButton2)
    FloatingActionButton fab;
    List<Post> posts = new ArrayList<>();
    RecyclerViewAdapter rvAdapter;
    ContactsFragmentCallbacks callbacks;

    public PostFragment() {
        // Required empty public constructor
    }

    public static PostFragment newInstance(int position, List<Post> posts) {
        PostFragment Myposts = new PostFragment();
       Myposts.posts = posts;
        return Myposts;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View myView = inflater.inflate(R.layout.fragment_post, container, false);
        ButterKnife.bind(this, myView);
        return myView;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (getActivity() instanceof ContactsFragmentCallbacks){
            callbacks = (ContactsFragmentCallbacks) getActivity();
        }
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        rvAdapter = new RecyclerViewAdapter(getActivity(),posts, this);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.addOnScrollListener(new HidingScroling() {
            @Override
            public void onHide() {
                hideViews();
            }
            @Override
            public void onShow() {
                showViews();
            }
        });
    }


    public void refresh() {
        rvAdapter.notifyDataSetChanged();
    }


    public interface ContactsFragmentCallbacks {
        void onFavouriteButtonClicked(Post posts);
    }
    private void hideViews() {

        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));


    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }
    @OnClick(R.id.floatingActionButton2)
    void fab() {

        AlertDialog.Builder faceBuilder = new AlertDialog.Builder(getContext());
        View view = getLayoutInflater().inflate(R.layout.mydil, null);
        faceBuilder.setView(view);
        faceBuilder.setPositiveButton("Post", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
               // Intent intent = new Intent(HomeActivity.this, HomeActivity.class);
               // startActivity(intent);
            }
        });
        faceBuilder.setNegativeButton("Cancle", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        AlertDialog dialog = faceBuilder.create();
        dialog.show();



      /*  Intent intent = new Intent(HomeActivity.this, SplashActivity.class);
        startActivity(intent);
    }*/
    }
}

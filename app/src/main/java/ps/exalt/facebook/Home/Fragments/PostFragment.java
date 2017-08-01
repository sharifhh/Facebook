package ps.exalt.facebook.Home.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.FrameLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.exalt.facebook.Home.Util.HidingScroling;
import ps.exalt.facebook.Home.Util.HomeRecyclerViewAdapter;
import ps.exalt.facebook.R;
import ps.exalt.facebook.Util.Network.API.Post;


public class PostFragment extends Fragment implements HomeRecyclerViewAdapter.RecyclerViewAdapterCalls {

    private boolean loading = true;
    private Random random;
    public static final String KEY_POSITION = "KEY_POSITION";
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.app)
    AppBarLayout tool;

    static List<Post> posts = new ArrayList<>();
    HomeRecyclerViewAdapter rvAdapter;



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
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);





        rvAdapter = new HomeRecyclerViewAdapter(getActivity(), posts, this);
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


    private void hideViews() {

        mToolbar.animate().translationY(-mToolbar.getHeight()).setInterpolator(new AccelerateInterpolator(2));
        tool.animate().translationY(-tool.getHeight()).setInterpolator(new AccelerateInterpolator(2));

    }

    private void showViews() {
        mToolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
        tool.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));

    }


}

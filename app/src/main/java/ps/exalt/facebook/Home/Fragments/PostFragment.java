package ps.exalt.facebook.Home.Fragments;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.transition.TransitionInflater;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.exalt.facebook.Home.Util.HidingScroling;
import ps.exalt.facebook.Home.Util.HomeRecyclerViewAdapter;
import ps.exalt.facebook.R;
import ps.exalt.facebook.SplashActivity;
import ps.exalt.facebook.Util.Network.API.Post;


public class PostFragment extends Fragment implements HomeRecyclerViewAdapter.RecyclerViewAdapterCalls {

    private boolean loading = true;
    private Random random;
    public static final String KEY_POSITION = "KEY_POSITION";
    int pastVisiblesItems, visibleItemCount, totalItemCount;

    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView;
//    @BindView(R.id.cam)
//    ImageButton camera;
//    @BindView(R.id.msg)
//   ImageButton msge;
//    @BindView(R.id.ser)
//    ImageView search_image;
//    @BindView(R.id.search)
//    EditText search_text;

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


        Window window = getActivity().getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
        window.setStatusBarColor(ContextCompat.getColor(getActivity(), R.color.mycolor));

        rvAdapter = new HomeRecyclerViewAdapter(getActivity(), posts, this);
        recyclerView.setAdapter(rvAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
//        recyclerView.addOnScrollListener(new HidingScroling() {
//            @Override
//            public void onHide() {
//                hideViews();
//            }
//
//            @Override
//            public void onShow() {
//                showViews();
//            }
//        });

    }


    public void refresh() {
        rvAdapter.notifyDataSetChanged();
    }


//    private void hideViews() {
//
//        mToolbar.setVisibility(View.GONE);
//        camera.setVisibility(View.GONE);
//        msge.setVisibility(View.GONE);
//        search_text.setVisibility(View.GONE);
//        search_image.setVisibility(View.GONE);
//        // Hide status bar
//    /*    Window window = getActivity().getWindow();
//       window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
//
//
//    }

//    private void showViews() {
//        mToolbar.setVisibility(View.VISIBLE);
//        camera.setVisibility(View.VISIBLE);
//        msge.setVisibility(View.VISIBLE);
//        search_image.setVisibility(View.VISIBLE);
//        search_text.setVisibility(View.VISIBLE);
//      /*  Window window = getActivity().getWindow();
//       window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);*/
//
//    }


}

package ps.exalt.facebook.presenation.home.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.R;
import ps.exalt.facebook.data.DataRepository;
import ps.exalt.facebook.presenation.home.util.HomeRecyclerViewAdapter;
import ps.exalt.facebook.util.network.api.Post;


public class PostFragment extends Fragment implements HomeRecyclerViewAdapter.RecyclerViewAdapterCalls {

    public static final String KEY_POSITION = "KEY_POSITION";
    List<Post> posts = new ArrayList<>();
    int pastVisiblesItems, visibleItemCount, totalItemCount;
    @BindView(R.id.recycler_view1)
    RecyclerView recyclerView;
    HomeRecyclerViewAdapter homeRecyclerViewAdapter;
    //    @BindView(R.id.cam)
//    ImageButton camera;
//    @BindView(R.id.msg)
//    ImageButton msge;
//    @BindView(R.id.ser)
//    ImageView search_image;
//    @BindView(R.id.search)
//    EditText search_text;
    private boolean loading = true;
    private Random random;

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
        DataRepository.getInstance().getPosts("sharif")
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(posts1 -> {
                    posts.addAll(posts1);
                    Log.d("Postsss",posts.get(0).getPostid() + "");
                    homeRecyclerViewAdapter = new HomeRecyclerViewAdapter(getActivity(), posts, this);
                    recyclerView.setAdapter(homeRecyclerViewAdapter);
                    recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
                },throwable -> Log.d("Error",throwable.toString()));
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
        homeRecyclerViewAdapter.notifyDataSetChanged();
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
//
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

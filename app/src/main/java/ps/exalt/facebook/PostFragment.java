package ps.exalt.facebook;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.exalt.facebook.API.Post;


public class PostFragment extends Fragment implements RecyclerViewAdapter.RecyclerViewAdapterCalls {

    public static final String KEY_POSITION = "KEY_POSITION";
    @BindView(R.id.recycler_view1)
    RecyclerView contactsRecyclerView;

    private List<Post> posts = new ArrayList<>();

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
        contactsRecyclerView.setAdapter(rvAdapter);
        contactsRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }


    public void refresh() {
        rvAdapter.notifyDataSetChanged();
    }


    public interface ContactsFragmentCallbacks {
        void onFavouriteButtonClicked(Post posts);
    }
}

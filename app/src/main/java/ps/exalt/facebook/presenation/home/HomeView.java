package ps.exalt.facebook.presenation.home;

import java.util.List;

import ps.exalt.facebook.util.network.api.Post;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface HomeView {

    void onGettingPostsCompleted(List<Post> posts);
}

package ps.exalt.facebook.Home;

import java.util.List;

import ps.exalt.facebook.Util.Network.API.Post;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface HomeView {

    void onGettingPostsCompleted(List<Post> posts);
}

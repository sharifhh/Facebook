package ps.exalt.facebook.Data;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Util.Network.API.Comment;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Util.Network.API.PostLike;
import ps.exalt.facebook.Util.Network.API.User;

/**
 * Created by Sharif on 7/26/2017.
 */

public abstract class DataSource {

    public DataSource() {
    }


    public abstract Observable<List<Comment>> getComments(long postId);

    public abstract Observable<List<Post>> getPosts(int page);

    public abstract Observable<List<User>> getUsers();

    public abstract Observable<Post> postPost(String username, Post post);

    public abstract Observable<PostLike> likePost(PostLike postLike);

    public abstract Observable<Boolean> getToken(String username, String password);
}

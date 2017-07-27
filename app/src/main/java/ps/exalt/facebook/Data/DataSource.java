package ps.exalt.facebook.Data;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Comment;
import ps.exalt.facebook.Post;
import ps.exalt.facebook.User;

/**
 * Created by Sharif on 7/26/2017.
 */

public abstract class DataSource {

    public DataSource() {
    }


    public abstract Observable<List<Comment>> getComments(long postId);

    public abstract Observable<List<Post>> getPosts(int page);

    public abstract Observable<List<User>> getUsers();

    public abstract Observable<User> getUser(String username);

}

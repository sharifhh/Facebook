package ps.exalt.facebook.Data.Local;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Comment;
import ps.exalt.facebook.Data.DataSource;
import ps.exalt.facebook.Post;
import ps.exalt.facebook.User;

import static io.reactivex.Observable.fromArray;

/**
 * Created by Sharif on 7/26/2017.
 */

public class LocalDataSource extends DataSource {
    private static LocalDataSource localDataSource;
    private List<Comment> comments;


    public static LocalDataSource getInstance() {
        if (localDataSource == null) {
            localDataSource = new LocalDataSource();
        }
        return localDataSource;
    }


    @Override
    public Observable<List<Comment>> getComments(long postId) {
        Observable<List<Comment>> commentsObservable = Observable.just(comments);
        return commentsObservable;
    }

    @Override
    public Observable<List<Post>> getPosts(int page) {
        return null;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return null;
    }

    @Override
    public Observable<User> getUser(String username) {
        return null;
    }
}

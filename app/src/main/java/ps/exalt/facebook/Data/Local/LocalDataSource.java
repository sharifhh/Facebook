package ps.exalt.facebook.Data.Local;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Comment;
import ps.exalt.facebook.Data.DataSource;
import ps.exalt.facebook.Post;
import ps.exalt.facebook.User;

/**
 * Created by Sharif on 7/26/2017.
 */

public class LocalDataSource extends DataSource {
    private static LocalDataSource localDataSource;



    public static LocalDataSource getInstance() {
        if (localDataSource == null) {
            localDataSource = new LocalDataSource();
        }
        return localDataSource;
    }


    @Override
    public Observable<List<Comment>> getComments(long postId) {
        return null;
    }

    @Override
    public Observable<List<Post>> getPosts(int page) {
        return null;
    }

    @Override
    public Observable<List<User>> getUsers() {
        return null;
    }
}

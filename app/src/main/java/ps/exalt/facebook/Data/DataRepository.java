package ps.exalt.facebook.Data;

import android.content.Context;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Comment;
import ps.exalt.facebook.Data.Local.LocalDataSource;
import ps.exalt.facebook.Post;
import ps.exalt.facebook.User;

/**
 * Created by Sharif on 7/26/2017.
 */

public class DataRepository {
    private DataSource remoteDataSource;
    private DataSource localDataSource;

    private static DataRepository dataRepository;

    public DataRepository(DataSource remoteDataSource, DataSource localDataSource) {
        this.remoteDataSource = remoteDataSource;
        this.localDataSource = localDataSource;
    }

    public static DataRepository getInstance(DataSource remoteDataSource,
                                                          DataSource localDataSource) {
        if (dataRepository == null) {
            dataRepository = new DataRepository(remoteDataSource, localDataSource);
        }
        return dataRepository;
    }

    public Observable<List<Post>> getPosts(int page) {
        Observable<List<Post>> postsObservable;
        if (true) {
            postsObservable = remoteDataSource.getPosts(page);
        } else {
            postsObservable = localDataSource.getPosts(page);
        }
        return postsObservable;
    }

    public Observable<List<Comment>> getComments(final Post post) {
        Observable<List<Comment>> commentsObservable;
        if (true) {
            commentsObservable = remoteDataSource.getComments(post.getId());
        } else {
            commentsObservable = localDataSource.getComments(post.getId());
        }
        return commentsObservable;
    }

    public Observable<List<User>> getUsers() {
        Observable<List<User>> usersObservable;
        if (true) {
            usersObservable = remoteDataSource.getUsers();
        } else {
            usersObservable = localDataSource.getUsers();
        }
        return usersObservable;
    }

    public Observable<User> getUser(String username) {
        Observable<User> userObservable;
        if (true) {
            userObservable = remoteDataSource.getUser(username);
        } else {
            userObservable = localDataSource.getUser(username);
        }
        return userObservable;
    }

    public void destroyInstance() {
        dataRepository = null;
    }
}

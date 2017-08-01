package ps.exalt.facebook.Data;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Util.Network.API.Comment;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Util.Network.API.PostLike;
import ps.exalt.facebook.Util.Network.API.User;
import ps.exalt.facebook.Data.Local.LocalDataSource;
import ps.exalt.facebook.Data.Remote.RemoteDataSource;

/**
 * Created by Sharif on 7/26/2017.
 */

public class DataRepository {
    private static DataRepository dataRepository;
    private DataSource remoteDataSource;
    private DataSource localDataSource;

    private DataRepository() {
        this.remoteDataSource = RemoteDataSource.getInstance();
        this.localDataSource = LocalDataSource.getInstance();
    }

    public static DataRepository getInstance() {
        if (dataRepository == null) {
            dataRepository = new DataRepository();
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
            commentsObservable = remoteDataSource.getComments(0);
        } else {
            commentsObservable = localDataSource.getComments(0);
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



    public Observable<Post> postPost(String username, Post post) {
        Observable<Post> postObservable;
        if (true) {
            postObservable = remoteDataSource.postPost(username, post);
        } else {
            postObservable = localDataSource.postPost(username, post);
        }
        return postObservable;
    }
    public Observable<Boolean> getToken(String username,String password){
        Observable<Boolean> tokenObservable;
        if (true) {
            tokenObservable = remoteDataSource.getToken(username, password);
        } else {
            tokenObservable = localDataSource.getToken(username, password);
        }
        return tokenObservable;
    }
    public Observable<PostLike> likePost(PostLike postLike){
        return remoteDataSource.likePost(postLike);
    }
    public void destroyInstance() {
        dataRepository = null;
    }
}

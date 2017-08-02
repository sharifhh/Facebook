package ps.exalt.facebook.Data;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Data.Local.LocalDataSource;
import ps.exalt.facebook.Data.Remote.RemoteDataSource;
import ps.exalt.facebook.Util.Network.API.Comment;
import ps.exalt.facebook.Util.Network.API.CommentReaction;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Util.Network.API.PostReaction;
import ps.exalt.facebook.Util.Network.API.User;

/**
 * Created by Sharif on 7/26/2017.
 */

public class DataRepository {
    private static DataRepository dataRepository;
    private DataSource remoteDataSource;
    private DataSource localDataSource;
    private Boolean remote = false;

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

    public Observable<Boolean> getToken(String username, String password) {
        return null;
    }

    public Observable<User> getUser(String username) {
        return null;
    }

    public Observable<User> addUser(User user) {
        return null;
    }

    public Observable<User> updateUser(User user) {
        return null;
    }

    public Observable<List<Post>> getPosts(String username, String limit, String offset) {
        return null;
    }

    public Observable<List<Post>> getPosts(String username) {
        return null;
    }

    public Observable<Post> addPost(String username, Post post) {
        return null;
    }

    public Observable<Void> deletePost(long postId) {
        return null;
    }

    public Observable<PostReaction> reactPost(String username, long postId, PostReaction postReaction) {
        return null;
    }

    public Observable<Comment> addComment(String username, long postId, Comment comment) {
        return null;
    }

    public Observable<Void> deleteComment(long commentId) {
        return null;
    }

    public Observable<List<Comment>> getComments(String username, long postId, String limit, String offset) {
        return null;
    }

    public Observable<List<Comment>> getComments(String username, long postId) {
        return null;
    }

    public Observable<CommentReaction> reactComment(String username, long postId, CommentReaction commentReaction) {
        return null;
    }

    public void destroyInstance() {
        dataRepository = null;
    }
}

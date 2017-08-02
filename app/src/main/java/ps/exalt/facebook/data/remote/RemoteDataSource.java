package ps.exalt.facebook.data.remote;

import java.util.List;

import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import ps.exalt.facebook.data.DataSource;
import ps.exalt.facebook.util.network.api.Comment;
import ps.exalt.facebook.util.network.api.CommentReaction;
import ps.exalt.facebook.util.network.api.Post;
import ps.exalt.facebook.util.network.api.PostReaction;
import ps.exalt.facebook.util.network.api.User;
import ps.exalt.facebook.util.network.retrofit.RetrofitInterface;
import ps.exalt.facebook.util.network.retrofit.RxErrorHandlingCallAdapterFactory;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Sharif on 7/26/2017.
 */

public class RemoteDataSource extends DataSource {
    private static RemoteDataSource remoteDataSource;
    private Retrofit retrofit;
    private RetrofitInterface api;

    private RemoteDataSource() {
        super();
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(chain -> {
            Request original = chain.request();

            Request request = original.newBuilder()
                    .header("Accept", "application/vnd.yourapi.v1.full+json")
                    .method(original.method(), original.body())
                    .build();

            return chain.proceed(request);

        });
        OkHttpClient client = httpClient.build();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.204.39:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxErrorHandlingCallAdapterFactory.create())
                .client(client)
                .build();

        api = retrofit.create(RetrofitInterface.class);
    }

    public static RemoteDataSource getInstance() {
        if (remoteDataSource == null) {
            remoteDataSource = new RemoteDataSource();
        }
        return remoteDataSource;
    }

    @Override
    public Observable<Boolean> getToken(String username, String password) {
        return api.getToken(username, password);
    }

    @Override
    public Observable<User> getUser(String username) {
        return api.getUser(username);
    }

    @Override
    public Observable<User> addUser(User user) {
        return api.addUser(user);
    }

    @Override
    public Observable<User> updateUser(User user) {
        return api.updateUser(user);
    }

    @Override
    public Observable<List<Post>> getPosts(String username, String limit, String offset) {
        return api.getPosts(username, limit, offset);
    }

    @Override
    public Observable<List<Post>> getPosts(String username) {
        return api.getPosts(username);
    }

    @Override
    public Observable<Post> addPost(String username, Post post) {
        return api.addPost(username, post);
    }

    @Override
    public Observable<Void> deletePost(long postId) {
        return api.deletePost(postId);
    }

    @Override
    public Observable<PostReaction> reactPost(String username, long postId, PostReaction postReaction) {
        return api.reactPost(username, postId, postReaction);
    }

    @Override
    public Observable<Comment> addComment(String username, long postId, Comment comment) {
        return api.addComment(username, postId, comment);
    }

    @Override
    public Observable<Void> deleteComment(long commentId) {
        return api.deleteComment(commentId);
    }

    @Override
    public Observable<List<Comment>> getComments(String username, long postId, String limit, String offset) {
        return api.getComments(username, postId, limit, offset);
    }

    @Override
    public Observable<List<Comment>> getComments(String username, long postId) {
        return api.getComments(username, postId);
    }

    @Override
    public Observable<CommentReaction> reactComment(String username, long postId, CommentReaction commentReaction) {
        return api.reactComment(username, postId, commentReaction);
    }

}
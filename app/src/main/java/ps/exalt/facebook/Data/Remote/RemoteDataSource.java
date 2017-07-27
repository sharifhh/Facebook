package ps.exalt.facebook.Data.Remote;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.API.Comment;
import ps.exalt.facebook.API.Post;
import ps.exalt.facebook.API.User;
import ps.exalt.facebook.Data.DataSource;
import ps.exalt.facebook.RetrofitInterface;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
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
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.204.39:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
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
    public Observable<List<Comment>> getComments(long postId) {
        Observable<List<Comment>> commentsObservable = api.getComments(postId);
        commentsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return commentsObservable;
    }

    @Override
    public Observable<List<Post>> getPosts(int page) {
        return api.getPosts();
    }

    @Override
    public Observable<List<User>> getUsers() {
        return api.getUsers();
    }

    @Override
    public Observable<User> getUser(String username) {
        return api.getUser(username);
    }

}

package ps.exalt.facebook.Data.Remote;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import ps.exalt.facebook.Comment;
import ps.exalt.facebook.Data.DataSource;
import ps.exalt.facebook.Post;
import ps.exalt.facebook.RetrofitInterface;
import ps.exalt.facebook.User;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Sharif on 7/26/2017.
 */

public class RemoteDataSource extends DataSource {
    private Retrofit retrofit;
    private RetrofitInterface api;
    private static RemoteDataSource remoteDataSource;

    private RemoteDataSource() {
        super();
        retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.204.39:8080/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
        api = retrofit.create(RetrofitInterface.class);
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
        Observable<List<Post>> postsObservable = api.getPosts();
        postsObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return postsObservable;
    }

    @Override
    public Observable<List<User>> getUsers() {
        Observable<List<User>> usersObservable = api.getUsers();
        usersObservable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
        return usersObservable;
    }

    public static RemoteDataSource getInstance() {
        if (remoteDataSource == null) {
            remoteDataSource = new RemoteDataSource();
        }
        return remoteDataSource;
    }

}

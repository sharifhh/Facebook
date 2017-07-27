package ps.exalt.facebook;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

/**
 * Created by Sharif on 7/26/2017.
 */

public class HomePresenter implements HomePresenterInterface {
    Retrofit retrofit;

    public HomePresenter() {

        retrofit = new Retrofit.Builder()
                .baseUrl("https://restcountries.eu/")
                .addConverterFactory(JacksonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }


    @Override
    public List<User> getUsers() {

        RetrofitInterface apiGetter = retrofit.create(RetrofitInterface.class);
        Observable<List<User>> json = apiGetter.getUsers();
        json.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::handleUserResponse);
    }

    private void handleUserResponse(List<User> users) {
    }

    @Override
    public List<Post> getPosts() {
        return null;
    }

    @Override
    public List<Post> getUserPosts(User user) {
        return null;
    }

    @Override
    public List<Comment> getComments(Post post) {
        return null;
    }

    @Override
    public List<PostLike> getPostLikes(Post post) {
        return null;
    }

    @Override
    public List<CommentLike> getCommentLikes(Comment comment) {
        return null;
    }
}

package ps.exalt.facebook;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface RetrofitInterface {


    @GET("/exalt/users")
    Observable<List<User>> getUsers();
    @GET("/exalt/posts")
    Observable<List<Post>> getPosts();
    @GET("/exalt/posts/{user}")
    Observable<List<Post>> getUserPosts(@Path("user") String username);
    @GET("/exalt/comments/{postID}")
    Observable<List<Comment>> getComments(@Path("postID") Long postID);
    @GET("/exalt/postlikes/{postID}")
    Observable<List<PostLike>> getPostLikes(@Path("postID") Long postID);
    @GET("/exalt/commentlikes/{commentID}")
    Observable<List<CommentLike>> getCommentLikes(@Path("commentID") Long commentID);

}

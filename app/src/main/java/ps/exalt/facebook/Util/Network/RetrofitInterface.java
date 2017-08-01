package ps.exalt.facebook.Util.Network;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Util.Network.API.Comment;
import ps.exalt.facebook.Util.Network.API.CommentLike;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Util.Network.API.PostLike;
import ps.exalt.facebook.Util.Network.API.User;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface RetrofitInterface {


    @GET("/exalt/users")
    Observable<List<User>> getUsers();

    @GET("/exalt/users")
    Observable<Boolean> getToken(@Body String username,@Body String password);

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

    @POST("/exalt/users/{user}/posts")
    Observable<Post> postPost(@Path("user") String username,@Body Post post);
}

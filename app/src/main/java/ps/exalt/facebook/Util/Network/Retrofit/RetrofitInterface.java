package ps.exalt.facebook.Util.Network.Retrofit;

import java.util.List;

import io.reactivex.Observable;
import ps.exalt.facebook.Util.Network.API.Comment;
import ps.exalt.facebook.Util.Network.API.CommentReaction;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Util.Network.API.PostReaction;
import ps.exalt.facebook.Util.Network.API.User;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface RetrofitInterface {

    @POST("/exalt/users")
    Observable<Boolean> getToken(@Body String username, @Body String password);

    @GET("/exalt/users/username/{user}")
    Observable<User> getUser(@Path("user") String username);

    @POST("/exalt/users")
    Observable<User> addUser(@Body User user);

    @PUT("/exalt/users")
    Observable<User> updateUser(@Body User user);

    @GET("/exalt/users/{user}/posts/{limit}/{offset}")
    Observable<List<Post>> getPosts(@Path("user") String username, @Path("limit") String limit, @Path("offset") String offset);

    @GET("/exalt/users/{user}/posts")
    Observable<List<Post>> getPosts(@Path("user") String username);

    @POST("/exalt/users/{user}/posts")
    Observable<Post> addPost(@Path("user") String username, @Body Post post);

    @DELETE("/exalt/posts/{id}")
    Observable<Void> deletePost(@Path("id") long postId);

    @POST("/exalt/users/{user}/posts/{postId}/postReaction")
    Observable<PostReaction> reactPost(@Path("user") String username, @Path("postId") long postId, @Body PostReaction postReaction);

    @POST("/exalt/users/{user}/posts/{postId}")
    Observable<Comment> addComment(@Path("user") String username, @Path("postId") long postId, @Body Comment comment);

    @DELETE("/exalt/comments/{id}")
    Observable<Void> deleteComment(@Path("id") long commentId);

    @GET("/exalt/users/{user}/posts/{postId}/comments/{limit}/{offset}")
    Observable<List<Comment>> getComments(@Path("user") String username, @Path("postId") long postId, @Path("limit") String limit, @Path("offset") String offset);

    @GET("/exalt/users/{user}/posts/{postId}/comments")
    Observable<List<Comment>> getComments(@Path("user") String username, @Path("postId") long postId);

    @POST("/exalt/users/{user}/comments/{commentId}/commentReaction")
    Observable<CommentReaction> reactComment(@Path("user") String username, @Path("commentId") long postId, @Body CommentReaction commentReaction);

}

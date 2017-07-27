package ps.exalt.facebook;

import java.util.List;

/**
 * Created by Sharif on 7/26/2017.
 */

public interface HomePresenterInterface {
    List<User> getUsers();
    List<Post> getPosts();
    List<Post> getUserPosts(User user);
    List<Comment> getComments(Post post);
    List<PostLike> getPostLikes(Post post);
    List<CommentLike> getCommentLikes(Comment comment);
}

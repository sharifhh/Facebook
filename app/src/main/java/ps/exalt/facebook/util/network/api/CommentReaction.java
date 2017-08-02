package ps.exalt.facebook.util.network.api;

/**
 * Created by Sharif on 7/26/2017.
 */

public class CommentReaction {
    long commentReactionId;
    String type;

    public long getCommentReactionId() {
        return commentReactionId;
    }

    public void setCommentReactionId(long commentReactionId) {
        this.commentReactionId = commentReactionId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}

package ps.exalt.facebook.util.network.api;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sharif on 7/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostReaction {
    long postReactionId;
    String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public long getPostReactionId() {
        return postReactionId;
    }

    public void setPostReactionId(long postReactionId) {
        this.postReactionId = postReactionId;
    }
}

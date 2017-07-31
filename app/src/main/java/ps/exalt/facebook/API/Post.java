package ps.exalt.facebook.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sharif on 7/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    long timeCreation;
    long postid;

    public void setPostid(long postid) {
        this.postid = postid;
    }

    public long getTimeCreation() {
        return timeCreation;
    }

    public void setTimeCreation(long timeCreation) {
        this.timeCreation = timeCreation;
    }

    public long getPostid() {
        return postid;
    }
}

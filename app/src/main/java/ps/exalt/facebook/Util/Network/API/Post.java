package ps.exalt.facebook.Util.Network.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sharif on 7/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class Post {
    long timeCreation;
    long postid;

    private String email;
    private String phone;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }



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

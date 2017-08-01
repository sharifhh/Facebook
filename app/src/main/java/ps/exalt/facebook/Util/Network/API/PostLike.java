package ps.exalt.facebook.Util.Network.API;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by Sharif on 7/26/2017.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class PostLike {

    String type;
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}

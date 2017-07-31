package ps.exalt.facebook; /**
 * Created by Exalt on 7/31/2017.
 */

import java.util.ArrayList;
import java.util.List;

import ps.exalt.facebook.API.Post;


class PostsDummy {
    public static List<Post> getContacts() {
        List<Post> posts = new ArrayList<>();

        for (int i = 0 ; i < 20 ; i++) {
           // posts.add(getContact(i));
        }

        return posts;}


  /*  private static Post getContact(int index) {

       String name = String.format("%s %d","Name" , index);
       Post post = new Post(name,"","1");

        return post;
    }*/
}

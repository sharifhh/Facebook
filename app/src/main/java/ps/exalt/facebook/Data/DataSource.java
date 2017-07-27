package ps.exalt.facebook.Data;

import java.util.List;

import ps.exalt.facebook.Comment;

/**
 * Created by Sharif on 7/26/2017.
 */

public abstract class DataSource {
    public interface GetPhotosCallback {
        void onSuccess(List<Photo> photos);

        void onFailure(Throwable throwable);

        void onNetworkFailure();

    }

    public interface GetCommentsCallback {

        void onSuccess(List<Comment> comments);

        void onFailure(Throwable throwable);

        void onNetworkFailure();

    }

    public abstract void getPhotos(int page, GetPhotosCallback callback);

    public abstract void getComments(String photoId, GetCommentsCallback callback);
}

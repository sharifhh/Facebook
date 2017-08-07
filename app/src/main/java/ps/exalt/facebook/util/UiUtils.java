package ps.exalt.facebook.util;

import android.view.View;

/**
 * Created by Sharif on 8/3/2017.
 */

public class UiUtils {

    public static void setVisibility(int visibility, View... views) {
        for (View view : views) {
            view.setVisibility(visibility);
        }
    }
}

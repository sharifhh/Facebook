package ps.exalt.facebook.util;

import android.content.Context;
import android.content.Intent;

import ps.exalt.facebook.home.HomeActivity;

/**
 * Created by Sharif on 8/1/2017.
 */

public class Navigator {
    public static void navigateToHome(Context context)
    {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    public static void navigateToLogin(Context context)
    {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
    public static void navigateToRegister(Context context)
    {
        Intent intent = new Intent(context, HomeActivity.class);
        context.startActivity(intent);
    }
}

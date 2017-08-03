package ps.exalt.facebook.util;

import android.content.Context;
import android.content.Intent;

import ps.exalt.facebook.PostsActivity;
import ps.exalt.facebook.home.HomeActivity;
import ps.exalt.facebook.login.LoginActivity;
import ps.exalt.facebook.register.RegisterActivity;

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
        Intent intent = new Intent(context, LoginActivity.class);
        context.startActivity(intent);
    }
    public static void navigateToRegister(Context context)
    {
        Intent intent = new Intent(context, RegisterActivity.class);
        context.startActivity(intent);
    }
    public static void navigateToPost(Context context)
    {
        Intent intent = new Intent(context, PostsActivity.class);
        context.startActivity(intent);

    }
}

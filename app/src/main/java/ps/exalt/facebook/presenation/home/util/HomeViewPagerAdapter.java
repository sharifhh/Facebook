package ps.exalt.facebook.presenation.home.util;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import ps.exalt.facebook.presenation.home.fragments.FriendFragment;
import ps.exalt.facebook.presenation.home.fragments.NotificationFragment;
import ps.exalt.facebook.presenation.home.fragments.PostFragment;

/**
 * Created by Mais on 7/27/2017.
 */

public class HomeViewPagerAdapter extends FragmentStatePagerAdapter {


    public HomeViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PostFragment posts = new PostFragment();

                return posts;
            case 1:

                FriendFragment friends= new FriendFragment();
                return friends;
            case 2:

                NotificationFragment notifications =new NotificationFragment();
                return notifications;
        }
        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }

}

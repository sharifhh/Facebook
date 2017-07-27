package ps.exalt.facebook;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import ps.exalt.facebook.FriendFragment;

/**
 * Created by Mais on 7/27/2017.
 */

public class ViewPagerAdapter extends FragmentPagerAdapter {


    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                PostFragment posts = new PostFragment();

            case 1:

                FriendFragment friends= new FriendFragment();

            case 2:

                NotificationFragment notifications =new NotificationFragment();

        }
        return null;
    }

    @Override
    public int getCount() {

        return 3;
    }

}

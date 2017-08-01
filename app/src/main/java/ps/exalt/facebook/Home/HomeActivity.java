package ps.exalt.facebook.Home;

// helllllllllllllokk


import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import ps.exalt.facebook.Util.Network.API.Post;
import ps.exalt.facebook.Home.Util.HomeViewPagerAdapter;
import ps.exalt.facebook.R;


public class HomeActivity extends AppCompatActivity implements HomeView{

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;

    HomeViewPagerAdapter homeViewPagerAdapter;
    HomePresenter homePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
       /* setSupportActionBar(toolbar);
        toolbar.setTitleTextColor(Color.WHITE);
        toolbar.setTitle("home");*/
       homePresenter = new HomePresenter(this);
       homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homeViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_home_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_people_black_24dp);
        tabLayout.getTabAt(2).setIcon(R.drawable.ic_public_black_24dp);
        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        tab.getIcon().setColorFilter(Color.BLUE, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabUnselected(TabLayout.Tab tab) {
                        super.onTabUnselected(tab);
                        tab.getIcon().setColorFilter(Color.GRAY, PorterDuff.Mode.SRC_IN);
                    }

                    @Override
                    public void onTabReselected(TabLayout.Tab tab) {
                        super.onTabReselected(tab);
                    }
                }
        );
    }

    @Override
    public void onGettingPostsCompleted(List<Post> posts) {

    }
}
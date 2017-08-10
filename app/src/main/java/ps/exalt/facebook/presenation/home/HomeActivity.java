package ps.exalt.facebook.presenation.home;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import ps.exalt.facebook.R;
import ps.exalt.facebook.presenation.home.util.HomeViewPagerAdapter;
import ps.exalt.facebook.util.Navigator;


public class HomeActivity extends AppCompatActivity {

    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.tabs)
    TabLayout tabLayout;
    @BindView(R.id.floatingActionButton)
    FloatingActionButton fab;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    HomeViewPagerAdapter homeViewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        Animation myAnim = AnimationUtils.loadAnimation(this, R.anim.myanimation);
        fab.setAnimation(myAnim);
        homeViewPagerAdapter = new HomeViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(homeViewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
       tabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        tabLayout.addOnTabSelectedListener(
                new TabLayout.ViewPagerOnTabSelectedListener(viewPager) {

                    @Override
                    public void onTabSelected(TabLayout.Tab tab) {
                        super.onTabSelected(tab);
                        tab.getIcon().setColorFilter(ContextCompat.getColor(HomeActivity.this, R.color.mycolor), PorterDuff.Mode.SRC_IN);
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

//                tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
//                    @Override
//                    public void onTabSelected(TabLayout.Tab tab) {
//                        if(tabLayout.getSelectedTabPosition() == 0){
//                            Toast.makeText(HomeActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
//                        }else if(tabLayout.getSelectedTabPosition() == 1){
//                            Toast.makeText(HomeActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
//                        }else if(tabLayout.getSelectedTabPosition() == 2){
//                            Toast.makeText(HomeActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
//                        }else if(tabLayout.getSelectedTabPosition() == 3) {
//                            Toast.makeText(HomeActivity.this, "Tab " + tabLayout.getSelectedTabPosition(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//
//                    @Override
//                    public void onTabUnselected(TabLayout.Tab tab) {
//
//                    }
//
//                    @Override
//                    public void onTabReselected(TabLayout.Tab tab) {
//
//                    }
//                });

            }





    @OnClick(R.id.floatingActionButton)
    void floatingActionButtonClicked() {

        Navigator.navigateToPost(this);
    }
}


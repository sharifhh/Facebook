package ps.exalt.facebook;

import ps.exalt.facebook.Data.DataRepository;

/**
 * Created by Sharif on 7/26/2017.
 */

public class HomePresenter {

    private HomeView homeView;

    public HomePresenter(HomeView view, DataRepository dataRepository) {
        this.homeView = view;
    }

    public void init() {
        //Get data Using Retrofit and Rx.
        //homeView.onGettingPostsCompleted();
    }


}

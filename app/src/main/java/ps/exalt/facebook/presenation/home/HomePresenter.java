package ps.exalt.facebook.presenation.home;

import ps.exalt.facebook.data.DataRepository;

/**
 * Created by Sharif on 7/26/2017.
 */

public class HomePresenter {

    private HomeView homeView;
    private DataRepository dataRepository;
    public HomePresenter(HomeView view) {
        this.homeView = view;
        dataRepository = DataRepository.getInstance();
    }

    public void init() {
        //Get data Using Retrofit and Rx.
        //homeView.onGettingPostsCompleted();
    }


}

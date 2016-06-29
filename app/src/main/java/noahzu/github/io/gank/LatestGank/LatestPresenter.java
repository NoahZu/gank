package noahzu.github.io.gank.LatestGank;

import noahzu.github.io.gank.Data.entity.Gank;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LatestPresenter implements LatestGankContract.Presenter {
    private LatestGankContract.View mView;
    private CompositeSubscription mSubscriptions;

    public LatestPresenter(LatestGankContract.View view){
        this.mView = view;
        mSubscriptions = new CompositeSubscription();
        mView.setPresenter(this);
    }


    @Override
    public void subscribe() {
        loadGanks();
    }

    private void loadGanks() {
        
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void onTabSelect(String tabText) {

    }

    @Override
    public void openGank(Gank gank) {

    }
}

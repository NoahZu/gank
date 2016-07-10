package noahzu.github.io.gank.HistoryGank;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Data.entity.PreviewGank;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankPresenter implements HistoryGankContract.Presenter {

    private HistoryGankContract.View mView;
    private List<PreviewGank> gankList;
    private CompositeSubscription compositeSubscription;


    public HistoryGankPresenter(HistoryGankContract.View view){
        this.mView = view;
        gankList = new ArrayList<>();
        compositeSubscription = new CompositeSubscription();
        this.mView.setPresenter(this);
    }


    @Override
    public void subscribe() {
        loadGanks();
    }

    private void loadGanks() {

    }

    @Override
    public void unsubscribe() {

    }
}

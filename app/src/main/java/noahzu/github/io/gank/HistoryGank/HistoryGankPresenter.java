package noahzu.github.io.gank.HistoryGank;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Data.entity.ApiDataManager;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankPresenter implements HistoryGankContract.Presenter {

    private HistoryGankContract.View mView;
    private List<HistoryGankResult.PreviewGank> gankList;
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

    @Override
    public void loadGanks() {
        Subscription subscription = ApiDataManager.getInstance()
                      .getGankApi()
                      .getHistoryGank(mView.getCurrentPage())
                      .subscribeOn(Schedulers.io())
                      .observeOn(AndroidSchedulers.mainThread())
                      .subscribe(new Subscriber<HistoryGankResult>() {

                          @Override
                          public void onStart() {
                              super.onStart();
                              mView.showLoading();
                          }

                          @Override
                          public void onCompleted() {
                            mView.hideLoading();
                          }

                          @Override
                          public void onError(Throwable e) {
                              mView.hideLoading();
                              mView.showMessage("网络错误");
                          }

                          @Override
                          public void onNext(HistoryGankResult listBeanWrapper) {
                                mView.showGanks(listBeanWrapper.getResults());
                          }
                      });

        compositeSubscription.add(subscription);
    }

    @Override
    public void unsubscribe() {
        compositeSubscription.unsubscribe();
    }
}

package noahzu.github.io.gank.LatestGank;

import noahzu.github.io.gank.Data.entity.ApiDataManager;
import noahzu.github.io.gank.Data.entity.DayGankResult;
import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.Data.entity.GankDateResult;
import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
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
        Subscription subscription = ApiDataManager.getInstance().getGankApi().getGankDates()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .flatMap(new Func1<GankDateResult, Observable<DayGankResult>>() {
                    @Override
                    public Observable<DayGankResult> call(GankDateResult gankDateResult) {
                        String date = gankDateResult.results.get(0);
                        String[] dateWords = date.split("-");
                        return ApiDataManager.getInstance().getGankApi().getDateGankBydate(dateWords[0],dateWords[1],dateWords[2]);
                    }
                })
                .subscribe(new Observer<DayGankResult>() {
                    @Override
                    public void onCompleted() {
                        
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(DayGankResult dayGankResult) {

                    }
                });
        mSubscriptions.add(subscription);
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

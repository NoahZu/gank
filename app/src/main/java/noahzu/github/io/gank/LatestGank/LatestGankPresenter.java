package noahzu.github.io.gank.LatestGank;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Data.entity.ApiDataManager;
import noahzu.github.io.gank.Data.entity.DayGankResult;
import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.Data.entity.GankDateResult;
import rx.Observable;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Func1;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LatestGankPresenter implements LatestGankContract.Presenter {
    private LatestGankContract.View mView;
    private CompositeSubscription mSubscriptions;
    private DayGankResult data;
    private List<Gank> mGankList;
    private Gank mFuliGank;

    public LatestGankPresenter(LatestGankContract.View view) {
        this.mView = view;
        mSubscriptions = new CompositeSubscription();
        mView.setPresenter(this);
        mGankList = new ArrayList<Gank>();
    }

    @Override
    public void subscribe() {
        loadGanks();
    }

    private void loadGanks() {
        Subscription subscription = ApiDataManager.getInstance().getGankApi().getGankDates()
                .subscribeOn(Schedulers.io())
                .flatMap(new Func1<GankDateResult, Observable<DayGankResult>>() {
                    @Override
                    public Observable<DayGankResult> call(GankDateResult gankDateResult) {
                        String date = gankDateResult.results.get(0);
                        String[] dateWords = date.split("-");
                        return ApiDataManager.getInstance().getGankApi().getDateGankBydate(dateWords[0], dateWords[1], dateWords[2]);
                    }
                })
                .map(new Func1<DayGankResult, List<Gank>>() {

                    @Override
                    public List<Gank> call(DayGankResult dayGankResult) {
                            mGankList.clear();
                            mGankList.addAll(dayGankResult.results.androidList == null ? new ArrayList<Gank>(0) : dayGankResult.results.androidList);
                            mGankList.addAll(dayGankResult.results.appList == null ? new ArrayList<Gank>(0) : dayGankResult.results.appList);
                            mGankList.addAll(dayGankResult.results.extendSourceList == null ? new ArrayList<Gank>(0) : dayGankResult.results.extendSourceList);
                            mGankList.addAll(dayGankResult.results.iOSList == null ? new ArrayList<Gank>(0) : dayGankResult.results.iOSList);
                            mFuliGank = dayGankResult.results.meizhiList.get(0);
                            mGankList.addAll(dayGankResult.results.recommandList == null ? new ArrayList<Gank>(0) : dayGankResult.results.recommandList );
                            mGankList.addAll(dayGankResult.results.videoList == null ? new ArrayList<Gank>(0) : dayGankResult.results.videoList);
                        return mGankList;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<List<Gank>>() {
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
                        Log.e("error",e.toString());
                        mView.showMessage("error");
                        mView.hideLoading();
                    }

                    @Override
                    public void onNext(List<Gank> ganks) {
                        setGankData(ganks);
                    }
                });
        mSubscriptions.add(subscription);
    }

    private void setGankData(List<Gank> ganks) {
        mView.showGanks(ganks);
        mView.showPicture(mFuliGank);
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }


    @Override
    public void openGank(int position) {
        mView.showGankDetails(mGankList.get(position));
    }
}

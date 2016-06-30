package noahzu.github.io.gank.LatestGank;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Data.Constants;
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
public class LatestPresenter implements LatestGankContract.Presenter {
    private LatestGankContract.View mView;
    private CompositeSubscription mSubscriptions;
    private DayGankResult data;

    public LatestPresenter(LatestGankContract.View view) {
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
                .flatMap(new Func1<GankDateResult, Observable<DayGankResult>>() {
                    @Override
                    public Observable<DayGankResult> call(GankDateResult gankDateResult) {
                        String date = gankDateResult.results.get(0);
                        String[] dateWords = date.split("-");
                        return ApiDataManager.getInstance().getGankApi().getDateGankBydate(dateWords[0], dateWords[1], dateWords[2]);
                    }
                })
                .map(new Func1<DayGankResult, DayGankResult>() {

                    @Override
                    public DayGankResult call(DayGankResult dayGankResult) {
                        if(dayGankResult.results.androidList == null ){
                            dayGankResult.results.androidList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.appList == null){
                            dayGankResult.results.appList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.extendSourceList == null){
                            dayGankResult.results.extendSourceList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.iOSList == null){
                            dayGankResult.results.iOSList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.meizhiList == null){
                            dayGankResult.results.meizhiList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.recommandList == null){
                            dayGankResult.results.recommandList = new ArrayList<Gank>(0);
                        }
                        if (dayGankResult.results.videoList == null){
                            dayGankResult.results.videoList = new ArrayList<Gank>(0);
                        }
                        return dayGankResult;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<DayGankResult>() {
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
                    public void onNext(DayGankResult dayGankResult) {
                        data = dayGankResult;
                        setGankData();
                    }
                });
        mSubscriptions.add(subscription);
    }

    private void setGankData() {
        String selectedTab = mView.getCurrentTab();
        mView.showGanks(getGanksByTab(selectedTab));
    }

    @Override
    public void unsubscribe() {
        mSubscriptions.clear();
    }

    @Override
    public void onTabSelect(String tabText) {
        if(data != null){
            setGankData();
        }else {
            loadGanks();
        }
    }

    @Override
    public void openGank(int position) {
        mView.showGankDetails(getGanksByTab(mView.getCurrentTab()).get(position));
    }


    public List<Gank> getGanksByTab(String selectedTab){
        if (selectedTab.equals(Constants.android_)) {
            return data.results.androidList;
        } else if (selectedTab.equals(Constants.ios)) {
            return data.results.iOSList;
        } else if (selectedTab.equals(Constants.video)) {
            return data.results.videoList;
        } else if (selectedTab.equals(Constants.welfare)) {
            return data.results.meizhiList;
        } else if (selectedTab.equals(Constants.extendSource)) {
            return data.results.extendSourceList;
        } else if (selectedTab.equals(Constants.front)) {
            return data.results.androidList;
        } else if (selectedTab.equals(Constants.recommand)) {
            return data.results.recommandList;
        } else if (selectedTab.equals(Constants.app)) {
            return data.results.appList;
        }
        return null;
    }
}

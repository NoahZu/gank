package noahzu.github.io.gank.SearchGank;

import noahzu.github.io.gank.Data.entity.ApiDataManager;
import noahzu.github.io.gank.Data.entity.SearchGankResult;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.CompositeSubscription;

/**
 * Created by Administrator on 2016/8/16.
 */
public class SearchGankPresenter implements SearchGankContract.Presenter {
    private SearchGankContract.View mView;
    private CompositeSubscription compositeSubscription;


    public SearchGankPresenter(SearchGankContract.View view){
        this.mView = view;
        compositeSubscription = new CompositeSubscription();
        this.mView.setPresenter(this);
    }

    @Override
    public void openGank(SearchGankResult.SearchGank gank) {

    }

    @Override
    public void updateGankList(String keyWord) {
        Subscription subscription = ApiDataManager.getInstance()
                .getGankApi()
                .search(keyWord,"all",10,1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Subscriber<SearchGankResult>() {
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
                    }

                    @Override
                    public void onNext(SearchGankResult searchGankResult) {
                        mView.hideLoading();
                        mView.showGanks(searchGankResult.getResults());
                    }
                });
        compositeSubscription.add(subscription);
    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {
        compositeSubscription.unsubscribe();
    }
}

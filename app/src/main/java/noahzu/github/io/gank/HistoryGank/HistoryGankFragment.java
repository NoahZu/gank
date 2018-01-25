package noahzu.github.io.gank.HistoryGank;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.aspsine.irecyclerview.IRecyclerView;
import com.aspsine.irecyclerview.OnLoadMoreListener;
import com.aspsine.irecyclerview.OnRefreshListener;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.yixia.financelive.irecyclerview_refresh.LoadMoreFooterView;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.RecycleViewDivider;

/**
 * noahzu
 */
public class HistoryGankFragment extends BaseFragment implements HistoryGankContract.View{

    private IRecyclerView gankListRecylerView;
    private HistoryGankListAdapter adapter;
    private HistoryGankContract.Presenter presenter;
    private LoadMoreFooterView mLoadMoreFooterView;
    private int page = 1;
    private static final int PAGE_SIZE = 6;
    private List<HistoryGankResult.PreviewGank> data;

    public HistoryGankFragment() {

    }

    public static HistoryGankFragment newInstance(){
        HistoryGankFragment fragment = new HistoryGankFragment();
        return  fragment;
    }


    @Override
    protected void initListener() {
        gankListRecylerView.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh() {
                page = 1;
                presenter.loadGanks();
            }
        });
        gankListRecylerView.setOnLoadMoreListener(new OnLoadMoreListener() {
            @Override
            public void onLoadMore() {
                mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
                presenter.loadMoreGanks();
            }
        });
    }

    @Override
    protected void initData() {
        data = new ArrayList<HistoryGankResult.PreviewGank>(0);
        adapter = new HistoryGankListAdapter(getContext());
        gankListRecylerView.setIAdapter(adapter);
    }

    @Override
    protected void initView() {
        new HistoryGankPresenter(this);
        gankListRecylerView = (IRecyclerView) getContentView().findViewById(R.id.history_gank_list);
        mLoadMoreFooterView = (LoadMoreFooterView) gankListRecylerView.getLoadMoreFooterView();
        gankListRecylerView.setLayoutManager(new GridLayoutManager(getContext(),2));

    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_history_gank;
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(getContentView(),msg,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
    }

    @Override
    public void hideLoading() {
    }

    @Override
    public void showGanks(List<HistoryGankResult.PreviewGank> ganks) {
        adapter.getData().clear();
        adapter.getData().addAll(ganks);
        adapter.notifyDataSetChanged();
        gankListRecylerView.setRefreshing(false);
    }

    @Override
    public void addGanks(List<HistoryGankResult.PreviewGank> ganks) {
        adapter.getData().addAll(ganks);
        adapter.notifyDataSetChanged();
        mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }

    @Override
    public void showGankDetails(HistoryGankResult.PreviewGank gank) {
        // TODO: 2016/8/15 jump to the detail activity
    }

    @Override
    public void showPicture(HistoryGankResult.PreviewGank gank) {
        // TODO: 2016/8/15 show a picture dialog
    }

    @Override
    public int getCurrentPage() {
        return page;
    }

    @Override
    public void startRefresh() {
        gankListRecylerView.setRefreshing(true);
    }

    @Override
    public void stopRefresh() {
        gankListRecylerView.setRefreshing(false);
    }

    @Override
    public void startLoading() {
        mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.LOADING);
    }

    @Override
    public void stopLoadingMore() {
        mLoadMoreFooterView.setStatus(LoadMoreFooterView.Status.GONE);
    }


    @Override
    public void onResume() {
        super.onResume();
        presenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        presenter.unsubscribe();
    }

    @Override
    public void setPresenter(HistoryGankContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

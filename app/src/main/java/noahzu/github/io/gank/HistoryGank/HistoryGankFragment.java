package noahzu.github.io.gank.HistoryGank;


import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ProgressBar;

import com.chad.library.adapter.base.BaseQuickAdapter;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.RecycleViewDivider;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryGankFragment extends BaseFragment implements HistoryGankContract.View{

    private RecyclerView gankListRecylerView;
    private ProgressBar loadingProgressBar;
    private HistoryGankListAdapter adapter;
    private HistoryGankContract.Presenter presenter;
    private int page = 1;
    private static final int PAGE_SIZE = 10;

    public HistoryGankFragment() {

    }

    public static HistoryGankFragment newInstance(){
        HistoryGankFragment fragment = new HistoryGankFragment();
        return  fragment;
    }


    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        adapter = new HistoryGankListAdapter(getContext(),R.layout.his_gank_item,new ArrayList<HistoryGankResult.PreviewGank>(0));
        adapter.openLoadAnimation();
        adapter.openLoadMore(PAGE_SIZE,true);
        adapter.setOnLoadMoreListener(new BaseQuickAdapter.RequestLoadMoreListener() {
            @Override
            public void onLoadMoreRequested() {
                page++;
                presenter.loadGanks();
            }
        });
        gankListRecylerView.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        new HistoryGankPresenter(this);
        gankListRecylerView = (RecyclerView) getContentView().findViewById(R.id.history_gank_list);
        loadingProgressBar = (ProgressBar) getContentView().findViewById(R.id.loading_progress);

        gankListRecylerView.setLayoutManager(new LinearLayoutManager(getContext()));
        gankListRecylerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL));
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
        loadingProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        loadingProgressBar.setVisibility(View.GONE);
    }

    @Override
    public void showGanks(List<HistoryGankResult.PreviewGank> ganks) {
        adapter.setNewData(ganks);
    }

    @Override
    public void addGanks(List<HistoryGankResult.PreviewGank> ganks) {
        adapter.addData(ganks);
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

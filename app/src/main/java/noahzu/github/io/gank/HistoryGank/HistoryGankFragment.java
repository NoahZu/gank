package noahzu.github.io.gank.HistoryGank;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.Data.entity.PreviewGank;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.RecycleViewDivider;

/**
 * A simple {@link Fragment} subclass.
 */
public class HistoryGankFragment extends BaseFragment implements HistoryGankContract.View{

    private RecyclerView gankListRecylerView;
    private ProgressBar loadingProgressBar;
    private HistoryGankListAdapter adapter;

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
        adapter = new HistoryGankListAdapter(getContext(),new ArrayList<PreviewGank>(0));
        gankListRecylerView.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        gankListRecylerView = (RecyclerView) getContentView().findViewById(R.id.history_gank_list);
        loadingProgressBar = (ProgressBar) getContentView().findViewById(R.id.loading_progress);

        GridLayoutManager layoutManager = new GridLayoutManager(getContext(),3);
        gankListRecylerView.setLayoutManager(layoutManager);
        gankListRecylerView.addItemDecoration(new RecycleViewDivider(getContext(), layoutManager.HORIZONTAL));
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
    public void showGanks(List<Gank> ganks) {

    }

    @Override
    public void showGankDetails(Gank gank) {

    }

    @Override
    public void showPicture(Gank gank) {

    }

    @Override
    public void setPresenter(HistoryGankContract.Presenter presenter) {

    }
}

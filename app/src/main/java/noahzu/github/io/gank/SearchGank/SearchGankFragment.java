package noahzu.github.io.gank.SearchGank;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.Data.entity.SearchGankResult;
import noahzu.github.io.gank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SearchGankFragment extends BaseFragment implements SearchGankContract.View{
    private ProgressBar progressBar;
    private ImageView backImageView;
    private EditText searchEdit;
    private RecyclerView recyclerView;
    private SearchGankContract.Presenter presenter;
    private SearchGankListAdapter adapter;



    public SearchGankFragment() {

    }

    public static SearchGankFragment newInstance(){
        SearchGankFragment searchGankFragment = new SearchGankFragment();
        return searchGankFragment;
    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initData() {
        adapter = new SearchGankListAdapter(getContext(),R.layout.search_gank_item,new ArrayList<SearchGankResult.SearchGank>(0));
    }

    @Override
    protected void initView() {
        progressBar = (ProgressBar) getContentView().findViewById(R.id.progress_bar);
        backImageView = (ImageView) getContentView().findViewById(R.id.back_img);
        searchEdit = (EditText) getContentView().findViewById(R.id.search_edit);
        recyclerView = (RecyclerView) getContentView().findViewById(R.id.search_result);
    }

    @Override
    protected int getLayout() {
        return R.layout.fragment_search_gank;
    }

    @Override
    public void showMessage(String msg) {
        if (msg.length() > 12){
            Snackbar.make(getContentView(),msg,Snackbar.LENGTH_LONG).show();
        }else {
            Snackbar.make(getContentView(),msg,Snackbar.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoading() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void showGanks(List<SearchGankResult.SearchGank> ganks) {
        adapter.addData(ganks);
    }

    @Override
    public void showGankDetails(SearchGankResult.SearchGank gank) {
        presenter.openGank(gank);
    }

    @Override
    public void setPresenter(SearchGankContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

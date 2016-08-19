package noahzu.github.io.gank.SearchGank;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.Data.entity.ApiDataManager;
import noahzu.github.io.gank.Data.entity.SearchGankResult;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.RecycleViewDivider;

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
        new SearchGankPresenter(this);
    }

    public static SearchGankFragment newInstance(){
        SearchGankFragment searchGankFragment = new SearchGankFragment();
        return searchGankFragment;
    }

    @Override
    protected void initListener() {
        searchEdit.setOnEditorActionListener(new OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_SEND
                        || (event != null && event.getKeyCode() == KeyEvent.KEYCODE_ENTER)) {
                    // TODO: 2016/8/17 获取数据
                    presenter.updateGankList(searchEdit.getText().toString());
                    return true;
                }
                return false;
            }
        });
        backImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getActivity().finish();
            }
        });
    }

    @Override
    protected void initData() {
        adapter = new SearchGankListAdapter(getContext(),R.layout.search_gank_item,new ArrayList<SearchGankResult.SearchGank>(0));

        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void initView() {
        progressBar = (ProgressBar) getContentView().findViewById(R.id.progress_bar);
        backImageView = (ImageView) getContentView().findViewById(R.id.back_img);
        searchEdit = (EditText) getContentView().findViewById(R.id.search_edit);
        recyclerView = (RecyclerView) getContentView().findViewById(R.id.search_result);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL));
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
        adapter.setNewData(ganks);
    }

    @Override
    public void addGanks(List<SearchGankResult.SearchGank> ganks) {
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

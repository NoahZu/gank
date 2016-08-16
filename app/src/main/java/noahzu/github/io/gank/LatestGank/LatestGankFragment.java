package noahzu.github.io.gank.LatestGank;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.RecycleViewDivider;

/**
 * 最新的gank
 */
public class LatestGankFragment extends Fragment implements LatestGankContract.View,LatestGankListAdapter.OnItemClickListener{

    private RecyclerView mGankList;
    private LatestGankContract.Presenter mPresenter;
    private ProgressBar mLoadingProgress;
    private LatestGankListAdapter mAdapter;
    private View contentView;
    private ImageView mImageView;


    public LatestGankFragment() {

    }

    public static LatestGankFragment newInstance() {
        LatestGankFragment fragment = new LatestGankFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        mAdapter = new LatestGankListAdapter(new ArrayList<Gank>(0),getContext());
        contentView = inflater.inflate(R.layout.fragment_latest_gank, container, false);
        mPresenter = new LatestGankPresenter(this);
        initView();
        return contentView;
    }

    private void initView() {

        mGankList = (RecyclerView) contentView.findViewById(R.id.gank_list);
        mLoadingProgress = (ProgressBar) contentView.findViewById(R.id.loading_pro);
        mImageView = (ImageView) contentView.findViewById(R.id.fuli_pic);
        mGankList.setLayoutManager(new LinearLayoutManager(getContext()));
        mGankList.addItemDecoration(new RecycleViewDivider(getContext(), LinearLayoutManager.HORIZONTAL));
        mGankList.setAdapter(mAdapter);
        mAdapter.setOnItemClickLsitener(this);
    }
    @Override
    public void onResume() {
        super.onResume();
        mPresenter.subscribe();
    }

    @Override
    public void onPause() {
        super.onPause();
        mPresenter.unsubscribe();
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(contentView,msg,Snackbar.LENGTH_SHORT).show();
    }

    @Override
    public void showLoading() {
        mLoadingProgress.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideLoading() {
        mLoadingProgress.setVisibility(View.INVISIBLE);
    }

    @Override
    public void showGanks(List<Gank> ganks) {
        mAdapter.refreshData(ganks);
        hideLoading();
    }

    @Override
    public void showGankDetails(Gank gank) {
        GankDetailActivity.actionStart(getContext(),gank);
    }

    @Override
    public void showPicture(Gank gank) {
        Picasso.with(getContext()).load(gank.url).into(mImageView);

    }


    @Override
    public void setPresenter(LatestGankContract.Presenter presenter) {
        this.mPresenter = presenter;
    }

    @Override
    public void onItemClick(View v, int position) {
        mPresenter.openGank(position);
    }
}

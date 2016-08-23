package noahzu.github.io.gank.CommitGank;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import noahzu.github.io.gank.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommitGankFragment extends Fragment implements CommitGankContract.View{
    private CommitGankContract.Presenter presenter;

    public CommitGankFragment() {

    }

    public static CommitGankFragment newInstance() {
        CommitGankFragment fragment = new CommitGankFragment();
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        new CommitPresenter(this);
        return inflater.inflate(R.layout.fragment_commit_gank, container, false);
    }

    @Override
    public void close() {

    }

    @Override
    public GankType getType() {
        return null;
    }

    @Override
    public String getWho() {
        return null;
    }

    @Override
    public String getDesc() {
        return null;
    }

    @Override
    public String getUrl() {
        return null;
    }

    @Override
    public void showMessage(String msg) {

    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void setPresenter(CommitGankContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

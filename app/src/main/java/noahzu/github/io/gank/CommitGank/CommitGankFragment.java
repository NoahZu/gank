package noahzu.github.io.gank.CommitGank;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Spinner;

import noahzu.github.io.gank.Base.BaseFragment;
import noahzu.github.io.gank.R;
import noahzu.github.io.gank.widget.TipEditText;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommitGankFragment extends BaseFragment implements CommitGankContract.View{
    private CommitGankContract.Presenter presenter;
    private TipEditText descEditText;
    private EditText urlEditText;
    private EditText whoEditText;
    private Spinner typeSpinner;
    private Button commitButton;
    private ProgressBar progressBar;

    public CommitGankFragment() {

    }

    public static CommitGankFragment newInstance() {
        CommitGankFragment fragment = new CommitGankFragment();
        return fragment;
    }


    @Override
    protected void initListener() {
        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               presenter.commitGank();
            }
        });
    }

    @Override
    protected void initData() {

    }

    @Override
    protected void initView() {
        new CommitPresenter(this);
        descEditText = (TipEditText) getContentView().findViewById(R.id.text_desc);
        urlEditText = (EditText) getContentView().findViewById(R.id.text_url);
        whoEditText = (EditText) getContentView().findViewById(R.id.text_who);
        typeSpinner = (Spinner) getContentView().findViewById(R.id.spinner_type);
        commitButton = (Button) getContentView().findViewById(R.id.commit_btn);
        progressBar = (ProgressBar) getContentView().findViewById(R.id.progress_bar);
    }



    @Override
    protected int getLayout() {
        return R.layout.fragment_commit_gank;
    }

    @Override
    public void close() {

    }

    @Override
    public GankType getType() {
        return GankType.getGankType((int)typeSpinner.getSelectedItemId());
    }

    @Override
    public String getWho() {
        return whoEditText.getText().toString();
    }

    @Override
    public String getDesc() {
        return descEditText.getText().toString();
    }

    @Override
    public String getUrl() {
        return urlEditText.getText().toString();
    }

    @Override
    public void initSpinner() {
        ArrayAdapter adapter = ArrayAdapter.createFromResource(getContext(),R.array.types,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        typeSpinner.setAdapter(adapter);
    }

    @Override
    public void showMessage(String msg) {
        Snackbar.make(getContentView(),msg,Snackbar.LENGTH_SHORT).show();
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
    public void setPresenter(CommitGankContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

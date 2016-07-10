package noahzu.github.io.gank.Base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/7/10.
 */
abstract public class BaseFragment extends Fragment{
    private View contentView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        contentView = inflater.inflate(getLayout(), container, false);

        initView();
        initData();
        initListener();
        return contentView;
    }

    protected abstract void initListener();
    protected abstract void initData();
    protected abstract void initView();
    protected abstract int getLayout();

    protected View getContentView(){return contentView;}
}

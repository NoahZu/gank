package noahzu.github.io.gank.LatestGank;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import noahzu.github.io.gank.Data.entity.Gank;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LatestGankListAdapter extends BaseAdapter {
    private List<Gank> mGanks;
    private Context mContext;

    public LatestGankListAdapter(List<Gank> ganks,Context context){
        mGanks = ganks;
        mContext = context;
    }

    public void refreshData(List<Gank> ganks){
        this.mGanks = ganks;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mGanks.size();
    }

    @Override
    public Gank getItem(int position) {
        return mGanks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO: 2016/6/29 0029 绑定布局
        return null;
    }
}

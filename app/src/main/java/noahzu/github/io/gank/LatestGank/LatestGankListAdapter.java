package noahzu.github.io.gank.LatestGank;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.R;

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
        if(convertView == null){
            convertView = LayoutInflater.from(mContext).inflate(R.layout.gank_item,null);
            ViewHolder v = new ViewHolder(convertView);
            convertView.setTag(v);
        }
        ViewHolder v = (ViewHolder) convertView.getTag();
        v.setData(mGanks.get(position));
        return convertView;
    }

    class ViewHolder{
        TextView descTextView;
        TextView whoTextView;

        public ViewHolder(View v){
            descTextView = (TextView) v.findViewById(R.id.gank_desc_text);
            whoTextView = (TextView) v.findViewById(R.id.gank_who);
        }

        public void setData(Gank g){
            descTextView.setText(g.desc);
            whoTextView.setText(g.who);
        }
    }
}

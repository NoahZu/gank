package noahzu.github.io.gank.LatestGank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.List;

import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LatestGankListAdapter extends RecyclerView.Adapter<LatestGankListAdapter.MyViewHolder> {
    private List<Gank> mGanks;
    private Context mContext;
    private String currentType;

    public LatestGankListAdapter(List<Gank> ganks,Context mContext){
        this.mGanks = ganks;
        this.mContext = mContext;
        currentType = "start";
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.gank_item,null));
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Gank g = mGanks.get(position);
        if(!currentType.equals(g.type)){
            currentType = g.type;
            holder.setTitle(currentType);
        }else{
            holder.hideTitle();
        }
        holder.setGank(mGanks.get(position));
    }

    @Override
    public int getItemCount() {
        return mGanks == null ? 0 : mGanks.size();
    }



    public void refreshData(List<Gank> ganks){
        this.mGanks = ganks;
        notifyDataSetChanged();
    }

    static class MyViewHolder extends RecyclerView.ViewHolder{
        TextView titleView;
        TextView descView;
        TextView whoView;


        public MyViewHolder(View itemView) {
            super(itemView);

            titleView = (TextView) itemView.findViewById(R.id.title);
            descView = (TextView) itemView.findViewById(R.id.gank_desc_text);
            whoView = (TextView) itemView.findViewById(R.id.gank_who);
        }


        public void setTitle(String title){
            if(titleView.getVisibility() == View.GONE){
                titleView.setVisibility(View.VISIBLE);
            }
            titleView.setText(title);
        }

        public void hideTitle(){
            if(titleView.getVisibility() == View.VISIBLE){
                titleView.setVisibility(View.GONE);
            }
        }

        public void setGank(Gank gank){
            descView.setText(gank.desc);
            whoView.setText(gank.who);
        }
    }


}

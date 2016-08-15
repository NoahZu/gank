package noahzu.github.io.gank.HistoryGank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankListAdapter extends RecyclerView.Adapter<HistoryGankListAdapter.ViewHolder> {

    private List<HistoryGankResult.PreviewGank> ganks;
    private Context context;

    public HistoryGankListAdapter(Context context,List<HistoryGankResult.PreviewGank> ganks){
        this.ganks = ganks;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(this.context).inflate(R.layout.his_gank_item,null));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.setData(ganks.get(position),this.context);
        if(listener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(v,position);
                }
            });
        }
    }

    @Override
    public int getItemCount() {
        return ganks.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView;
        TextView textView;
        public View itemView;
        public ViewHolder(View itemView) {
            super(itemView);
            imageView = (ImageView) itemView.findViewById(R.id.gank_his_img);
            textView = (TextView) itemView.findViewById(R.id.gank_his_text);
        }

        public void setData(HistoryGankResult.PreviewGank gank, Context context){
            Picasso.with(context).load(gank.getImageUrl()).into(imageView);
            textView.setText(gank.title);
        }
    }

    private OnItemClickListener listener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.listener = listener;
    }

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
    }

    public void refreshData(List<HistoryGankResult.PreviewGank> ganks){
        this.ganks = ganks;
        notifyDataSetChanged();
    }
}

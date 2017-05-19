package noahzu.github.io.gank.HistoryGank;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import noahzu.github.io.gank.Common.CommonViewHolder;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;

/**
 * Created by zujinhao on 2016/7/10.
 */
public class HistoryGankListAdapter extends RecyclerView.Adapter<HistoryGankListAdapter.HistoryGankViewHolder>{

    private List<HistoryGankResult.PreviewGank> data;
    private Context context;

    public HistoryGankListAdapter(Context context){
        this.data = new ArrayList<HistoryGankResult.PreviewGank>();
        this.context = context;
    }

    @Override
    public HistoryGankViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new HistoryGankViewHolder(LayoutInflater.from(context).inflate(R.layout.his_gank_item,null));
    }

    @Override
    public void onBindViewHolder(HistoryGankViewHolder holder, int position) {
        final HistoryGankResult.PreviewGank gank = data.get(position);
        ImageView imageView = (ImageView) holder.getView(R.id.his_gank_img);
        Picasso.with(this.context).load(gank.getImageUrl()).into(imageView);
        ((TextView) holder.getView(R.id.his_gank_txt)).setText(gank.title);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PhotoActivity.class);
                intent.putExtra(PhotoActivity.IMAGE_URL,gank.getImageUrl());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return data.size();
    }


    public List<HistoryGankResult.PreviewGank> getData(){
        return data;
    }

    public static class HistoryGankViewHolder extends CommonViewHolder{

        public HistoryGankViewHolder(View itemView) {
            super(itemView);
        }
    }
}

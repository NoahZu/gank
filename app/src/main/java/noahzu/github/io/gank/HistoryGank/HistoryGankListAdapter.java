package noahzu.github.io.gank.HistoryGank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankListAdapter extends BaseQuickAdapter<HistoryGankResult.PreviewGank>{


    public HistoryGankListAdapter(Context context, int layoutResId, List<HistoryGankResult.PreviewGank> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, HistoryGankResult.PreviewGank previewGank) {
        ImageView imageView = holder.getView(R.id.gank_his_img);
        Picasso.with(mContext).load(previewGank.getImageUrl()).into(imageView);
        holder.setText(R.id.gank_his_text,previewGank.title);
    }

}

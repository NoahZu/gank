package noahzu.github.io.gank.LatestGank;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class LatestGankListAdapter extends BaseQuickAdapter<Gank> {
    private String preType;

    public LatestGankListAdapter(Context context, int layoutResId, List<Gank> data) {
        super(context, layoutResId, data);
        preType = null;
    }

    @Override
    protected void convert(BaseViewHolder holder, Gank gank) {
        holder.setText(R.id.title,gank.type);
        holder.setText(R.id.gank_desc_text,gank.desc);
        holder.setText(R.id.gank_who,"作者："+gank.who);
    }
}

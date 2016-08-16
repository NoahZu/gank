package noahzu.github.io.gank.SearchGank;

import android.content.Context;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;

import java.util.List;

import noahzu.github.io.gank.Data.entity.SearchGankResult;
import noahzu.github.io.gank.R;

/**
 * Created by Administrator on 2016/8/16.
 */
public class SearchGankListAdapter extends BaseQuickAdapter<SearchGankResult.SearchGank> {


    public SearchGankListAdapter(Context context, int layoutResId, List<SearchGankResult.SearchGank> data) {
        super(context, layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder holder, SearchGankResult.SearchGank gank) {
        holder.setText(R.id.gank_desc_text,gank.desc);
        holder.setText(R.id.title,gank.type);
    }
}

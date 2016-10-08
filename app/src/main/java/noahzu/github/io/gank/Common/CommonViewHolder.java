package noahzu.github.io.gank.Common;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * 作者：俎金好
 * 日期：2016/10/8
 * 功能描述：通用的ViewHolder
 */
public class CommonViewHolder extends RecyclerView.ViewHolder {
    private View itemView;

    public CommonViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
    }

    public View getView(int resource){
        return itemView.findViewById(resource);
    }
}

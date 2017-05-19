package noahzu.github.io.gank.Common

import android.support.v7.widget.RecyclerView
import android.view.View

/**
 * Created by zujinhao on 17/5/19.
 */
open class CommonViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
    private var view : View = itemView!!

    fun getView(source : Int) : View{
        return view.findViewById(source)
    }
}
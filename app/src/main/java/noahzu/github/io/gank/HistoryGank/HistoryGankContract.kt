package noahzu.github.io.gank.HistoryGank

import noahzu.github.io.gank.Base.BasePresenter
import noahzu.github.io.gank.Base.BaseView
import noahzu.github.io.gank.Data.entity.Gank
import noahzu.github.io.gank.Data.entity.HistoryGankResult

/**
 * Created by Administrator on 2016/7/10.
 */
class HistoryGankContract {
    internal interface View : BaseView<Presenter> {
        fun showGanks(ganks: List<HistoryGankResult.PreviewGank>)
        fun addGanks(ganks: List<HistoryGankResult.PreviewGank>)
        fun showGankDetails(gank: HistoryGankResult.PreviewGank)
        fun showPicture(gank: HistoryGankResult.PreviewGank)
        val currentPage: Int
        fun startRefresh()
        fun stopRefresh()
        fun startLoading()
        fun stopLoadingMore()
    }

    internal interface Presenter : BasePresenter {
        fun loadGanks()
        fun loadMoreGanks()
    }
}

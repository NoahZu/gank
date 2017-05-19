package noahzu.github.io.gank.Base

/**
 * Created by zujinhao on 17/5/19.
 */
public interface BaseView<T>{
    abstract fun showMessage(msg: String)
    abstract fun showLoading()
    abstract fun hideLoading()
    abstract fun setPresenter(presenter: T)
}
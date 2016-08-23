package noahzu.github.io.gank.Base;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public interface BaseView<T> {
    void showMessage(String msg);
    void showLoading();
    void hideLoading();
    void setPresenter(T presenter);
}

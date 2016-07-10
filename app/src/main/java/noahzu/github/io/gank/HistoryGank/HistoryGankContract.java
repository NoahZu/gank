package noahzu.github.io.gank.HistoryGank;

import java.util.List;

import noahzu.github.io.gank.Base.BasePresenter;
import noahzu.github.io.gank.Base.BaseView;
import noahzu.github.io.gank.Data.entity.Gank;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankContract {
    interface View extends BaseView<Presenter>{
        void showMessage(String msg);
        void showLoading();
        void hideLoading();
        void showGanks(List<Gank> ganks);
        void showGankDetails(Gank gank);
        void showPicture(Gank gank);
    }

    interface Presenter extends BasePresenter{

    }
}

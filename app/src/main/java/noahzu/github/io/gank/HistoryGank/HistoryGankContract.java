package noahzu.github.io.gank.HistoryGank;

import java.util.List;

import noahzu.github.io.gank.Base.BasePresenter;
import noahzu.github.io.gank.Base.BaseView;
import noahzu.github.io.gank.Data.entity.Gank;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;

/**
 * Created by Administrator on 2016/7/10.
 */
public class HistoryGankContract {
    interface View extends BaseView<Presenter>{
        void showMessage(String msg);
        void showLoading();
        void hideLoading();
        void showGanks(List<HistoryGankResult.PreviewGank> ganks);
        void showGankDetails(HistoryGankResult.PreviewGank gank);
        void showPicture(HistoryGankResult.PreviewGank gank);
        int getCurrentPage();
    }

    interface Presenter extends BasePresenter{

    }
}

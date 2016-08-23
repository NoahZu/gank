package noahzu.github.io.gank.CommitGank;

import noahzu.github.io.gank.Base.BasePresenter;
import noahzu.github.io.gank.Base.BaseView;
import retrofit2.http.Body;

/**
 * Created by Administrator on 2016/8/23.
 */
public class CommitGankContract {
    interface View extends BaseView<Presenter>{
        void close();
        GankType getType();
        String getWho();
        String getDesc();
        String getUrl();
    }

    interface Presenter extends BasePresenter{
        void commitGank();
    }
}

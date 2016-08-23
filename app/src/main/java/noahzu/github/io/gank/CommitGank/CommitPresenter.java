package noahzu.github.io.gank.CommitGank;

/**
 * Created by Administrator on 2016/8/23.
 */
public class CommitPresenter implements CommitGankContract.Presenter {
    private CommitGankContract.View mView;

    public CommitPresenter(CommitGankContract.View view){
        mView = view;
        mView.setPresenter(this);
    }

    @Override
    public void commitGank() {

    }

    @Override
    public void subscribe() {

    }

    @Override
    public void unsubscribe() {

    }
}

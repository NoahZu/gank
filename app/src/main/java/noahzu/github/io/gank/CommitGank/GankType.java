package noahzu.github.io.gank.CommitGank;

/**
 * Created by Administrator on 2016/8/23.
 */
public enum GankType {
    Android,iOS,Video,Welfare,ExtendSource,Front,Recommand,app;

    public static GankType getGankType(int id){
        switch (id){
            case 0:
                return Android;
            case 1:
                return iOS;
            case 2:
                return Video;
            case 3:
                return Welfare;
            case 4:
                return ExtendSource;
            case 5:
                return Front;
            case 6:
                return Recommand;
            case 7:
                return app;
            default:
                return Android;
        }
    }
}

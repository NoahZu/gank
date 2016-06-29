package noahzu.github.io.gank.Data.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class DayGankResult {
    boolean error;
    public Result results;
    public List<String> category;

    public class Result {
        @SerializedName("Android") public List<Gank> androidList;
        @SerializedName("休息视频") public List<Gank> videoList;
        @SerializedName("iOS") public List<Gank> iOSList;
        @SerializedName("福利") public List<Gank> meizhiList;
        @SerializedName("拓展资源") public List<Gank> extendSourceList;
        @SerializedName("瞎推荐") public List<Gank> recommandList;
        @SerializedName("App") public List<Gank> appList;
    }
}

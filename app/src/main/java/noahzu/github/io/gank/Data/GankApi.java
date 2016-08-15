package noahzu.github.io.gank.Data;

import noahzu.github.io.gank.Data.entity.CommitResult;
import noahzu.github.io.gank.Data.entity.DayGankResult;
import noahzu.github.io.gank.Data.entity.GankDateResult;
import noahzu.github.io.gank.Data.entity.HistoryGankResult;
import noahzu.github.io.gank.Data.entity.SearchGankResult;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import rx.Observable;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public interface GankApi {
    /**
     * 搜索gank
     * @param keywords
     * @param category
     * @param pageSize
     * @param page
     * @return
     */
    @GET("search/query/{keywords}/category/{category}/count/{size}/page/{page} ")
    Observable<SearchGankResult> search(
            @Path("keywords") String keywords,
            @Path("category") String category,
            @Path("size") int pageSize,
            @Path("page") int page);

    /**
     * 获取特定日期的gank
     * @param year
     * @param month
     * @param day
     * @return
     */
    @GET("day/{year}/{month}/{day}")
    Observable<DayGankResult> getDateGankBydate(
            @Path("year") String year,
            @Path("month") String month,
            @Path("day") String day);

    /**
     * 获取发表gank的日期
     * @return
     */
    @GET("day/history")
    Observable<GankDateResult> getGankDates();

    /**
     * 提交gank
     * @param url
     * @param desc
     * @param who
     * @param type
     * @param debug
     * @return
     */
    @POST("add2gank")
    Observable<CommitResult> commitGank(
            @Body String url,
            @Body String desc,
            @Body String who,
            @Body String type,
            @Body boolean debug);

    @GET("history/content/10/{page}")
    Observable<HistoryGankResult> getHistoryGank(@Path("page") int page);

}

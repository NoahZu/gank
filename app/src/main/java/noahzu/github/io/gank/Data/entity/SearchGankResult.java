package noahzu.github.io.gank.Data.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class SearchGankResult {
    int count;
    boolean error;
    List<SearchGank> results;
    public static class SearchGank {
        String desc;
        String ganhuo_id;
        String publishedAt;
        String readability;
        String url;
        String who;
        String type;
    }
}

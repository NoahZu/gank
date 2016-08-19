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
        public String desc;
        public String ganhuo_id;
        public String publishedAt;
        public String readability;
        public String url;
        public String who;
        public String type;
    }

    public boolean isError() {
        return error;
    }

    public List<SearchGank> getResults() {
        return results;
    }

    public int getCount() {
        return count;
    }
}

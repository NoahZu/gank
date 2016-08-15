package noahzu.github.io.gank.Data.entity;

import java.util.List;

/**
 * Created by Administrator on 2016/8/15.
 */
public class BeanWrapper<T> {
    boolean error;
    List<T> beans;

    public boolean isError() {
        return error;
    }

    public void setError(boolean error) {
        this.error = error;
    }

    public List<T> getBeans() {
        return beans;
    }

    public void setBeans(List<T> beans) {
        this.beans = beans;
    }
}

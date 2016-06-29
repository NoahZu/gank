package noahzu.github.io.gank.Data.entity;

import noahzu.github.io.gank.Data.Constants;
import noahzu.github.io.gank.Data.GankApi;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2016/6/29 0029.
 */
public class ApiDataManager {
    private static ApiDataManager instance = new ApiDataManager();
    private Retrofit httpRetrofit;
    private Retrofit httpsRetrofit;

    private GankApi gankApi;
    private GankApi httpsGankApi;

    public ApiDataManager(){
        httpRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.httpBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  //这是新加的
                .build();
        httpsRetrofit = new Retrofit.Builder()
                .baseUrl(Constants.httpsBaseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())  //这是新加的
                .build();
        gankApi = httpRetrofit.create(GankApi.class);
        httpsGankApi = httpsRetrofit.create(GankApi.class);
    }

    public static ApiDataManager getInstance(){
        return instance;
    }

    public GankApi getGankApi() {
        return gankApi;
    }

    public GankApi getHttpsGankApi() {
        return httpsGankApi;
    }
}

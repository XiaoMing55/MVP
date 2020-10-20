package com.alibaba.lib_core.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRetrofitManager {

    private static HttpRetrofitManager manager = new HttpRetrofitManager();

    public static HttpRetrofitManager getManager() {
        return manager;
    }

    private HttpRetrofitManager() {
    }

    private Retrofit retrofit;

    public Retrofit getRetrofit(String url) {
        if (retrofit == null) {
            create(url);
        }
        return retrofit;
    }

    private void create(String url) {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();

        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        OkHttpClient.Builder okbuilder = new OkHttpClient.Builder();
        okbuilder.addInterceptor(interceptor)
                .readTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .writeTimeout(60 * 1000, TimeUnit.MILLISECONDS)
                .connectTimeout(60 * 1000, TimeUnit.MILLISECONDS);

        Retrofit.Builder builder = new Retrofit.Builder();
        retrofit = builder.baseUrl(url)
                .client(okbuilder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    
}

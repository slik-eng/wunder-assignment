package com.sliksoft.wunder.net;

import android.content.Context;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;

import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import com.sliksoft.wunder.net.WunderApi;

import java.util.concurrent.TimeUnit;

/**
 * Created by Osama Slik on 31/08/2018.
 */

public class ApiClient {
    private static ApiClient SINGLETON = new ApiClient();
    final OkHttpClient okHttpClient =new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(30, TimeUnit.SECONDS)
            .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
            .build();
    public static ApiClient get() {
        return SINGLETON;
    }

    private static final String BASE_URL="https://s3-us-west-2.amazonaws.com/";
    private WunderApi wunderApi;

    public WunderApi getWunderApi() {
        return wunderApi;
    }

    public ApiClient init(Gson gson)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        wunderApi=retrofit.create(WunderApi.class);
        return this;
    }
}

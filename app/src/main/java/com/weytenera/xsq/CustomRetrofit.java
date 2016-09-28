package com.weytenera.xsq;


import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 *日志输出
 *@auth ccs
 *create at 2016/3/28 23:22
 */
public class CustomRetrofit {
    public static Retrofit getRetrofit(){
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);//日志输出
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();
        return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create()).baseUrl(BaseConfig.HOST).client(client).build();
    }



}

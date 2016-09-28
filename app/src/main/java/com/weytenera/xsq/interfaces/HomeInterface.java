package com.weytenera.xsq.interfaces;

import com.google.gson.JsonObject;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;


/**
 * Created by Administrator on 2016/2/21.
 */
public interface HomeInterface {

    @GET("/users/{user}")
    public void getFeed(@Path("user") String user);

//
//    //获取列表
//    @POST("/Shop/GetQzoneList")
//    Call<QzoneListBean> getQzoneList(@Body JsonObject bean);

    //注册
    @Headers({"Content-Type: application/json; charset=utf-8","access-key:123456789"})
    @POST("/api/User/Register")
    Call<JsonObject> register(@Body JsonObject jsonObject);

    //登录
//    @Headers("access-Key:123456789")
    @Headers({"Content-Type: application/json; charset=utf-8","access-Key:123456789"})
    @POST("/api/User/Login")
    Call<JsonObject> login(@Body JsonObject jsonObject);



    @POST("/api/User/GetApplications")
    Call<JsonObject> getList(@Body JsonObject jsonObject);





}

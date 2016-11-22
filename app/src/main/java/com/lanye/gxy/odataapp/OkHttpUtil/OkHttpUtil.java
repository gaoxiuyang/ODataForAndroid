package com.lanye.gxy.odataapp.OkHttpUtil;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;


/**
 * Created by gxy on 2016/10/18.
 */
public class OkHttpUtil {
    public final OkHttpClient client = new OkHttpClient.Builder()
            .readTimeout(30, TimeUnit.SECONDS)
            .connectTimeout(10, TimeUnit.SECONDS)
            .writeTimeout(60, TimeUnit.SECONDS)
            .build(); //设置各种超时时间
    public static final MediaType JSON
            = MediaType.parse("application/json; charset=utf-8");
    /**
     * OKHttp get请求
     * @param url
     * @return
     */
    public Response get(String url, Request.Builder builder){
        builder.url(url);
        final Request request = builder.build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            System.out.println("===="+response.code());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * OKHttp post 请求
     * @param url
     * @param json
     * @return
     */
    public Response post (String url, String json){
        RequestBody requestBody = RequestBody.create(JSON, json);
        //创建一个请求对象
        Request request = new Request.Builder()
                .url(url)
                .header("Content-Type","application/json")
                .post(requestBody)
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

    /**
     * OkHttp put请求
     * @param uploadUrl
     * @return
     * @throws IOException
     */
    public Response put(Request.Builder builder, String uploadUrl, String json) throws IOException {
        builder.url(uploadUrl);
        RequestBody body = RequestBody.create(JSON, json);
        builder.put(body);
        final Request request = builder.build();
        Response response = client.newCall(request).execute();
        return response;
    }

    /**
     * OkHttp delete请求
     * @param url
     * @return
     * @throws IOException
     */
    public  Response delete( String url) throws IOException {
        Request request = new Request.Builder()
                .url(url)
                .delete()
                .header("Content-Type","application/json")
                .build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;
    }

}

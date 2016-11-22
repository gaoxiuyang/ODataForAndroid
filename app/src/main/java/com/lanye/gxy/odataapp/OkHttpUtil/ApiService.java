package com.lanye.gxy.odataapp.OkHttpUtil;



import java.io.IOException;

import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Response;


/**
 * Created by gxy on 2016/11/7.
 */
public class ApiService {
    OkHttpUtil okHttpUtil = new OkHttpUtil();

    public Response read(String url) throws IOException {
        Request.Builder builder = new Request.Builder();
        requestHeaders(builder);
        return okHttpUtil.get(url,builder);
    }

    public Response create(String url, String json) throws IOException {
        return okHttpUtil.post(url,json);
    }

    public Response update(String uploadUrl, String json) throws IOException {
        Request.Builder builder = new Request.Builder();
        requestHeaders(builder);
        return okHttpUtil.put(builder,uploadUrl,json);
    }

    public Response delete(String url) throws IOException {
        return okHttpUtil.delete(url);
    }

//    public String batch(Request.Builder builder, String json) throws IOException {
//        UrlService urlService = new UrlService();
//        requestHeaders(builder);
//        return handleResponse(okHttpUtil.post(urlService.GetAllURL,builder,json));
//    }

    public String handleResponse(Response response) throws IOException {
        if (response.code()==200){
            System.out.println("Succeed"+response.body().string());
            return response.body().string();
        }else {
            return "";
        }
    }



    public Request.Builder requestHeaders(Request.Builder builder){
        builder.addHeader("Content-Type", "application/json");
        return builder;
    }
}

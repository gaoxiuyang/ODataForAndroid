package com.lanye.gxy.odataapp.Request;
import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.widget.Toast;
import com.lanye.gxy.odataapp.Activity.MainActivity;
import com.lanye.gxy.odataapp.Activity.ResultActivity;
import com.lanye.gxy.odataapp.OkHttpUtil.ApiService;
import java.io.IOException;
import okhttp3.Response;
/**
 * Created by Administrator on 2016/11/16.
 */
public class PostRequest extends AsyncTask<Void, Void, Response> {
    ApiService apiService = new ApiService();
    private ProgressDialog progressDialog;
    String url;
    String responseData;
    private String json = "{\n" +
            "    \"UserName\":\"aaa\",\n" +
            "    \"FirstName\":\"Lewis\",\n" +
            "    \"LastName\":\"Black\",\n" +
            "    \"Emails\":[\n" +
            "        \"lewisblack@example.com\"\n" +
            "    ],\n" +
            "    \"AddressInfo\": [\n" +
            "    {\n" +
            "      \"Address\": \"187 Suffolk Ln.\",\n" +
            "      \"City\": {\n" +
            "        \"Name\": \"Boise\",\n" +
            "        \"CountryRegion\": \"United States\",\n" +
            "        \"Region\": \"ID\"\n" +
            "      }\n" +
            "    }\n" +
            "    ]\n" +
            "}";
    Activity mainActivity;
    public PostRequest(MainActivity context, String url){
        this.mainActivity = context;
        this.url =url;
        progressDialog = new ProgressDialog(context);
        progressDialog.setMessage("请稍后");
    }
    @Override
    protected void onPreExecute() {
        progressDialog.show();
    }
    @Override
    protected Response doInBackground(Void... params) {
        try {
            Response response = apiService.create(url,json);
            responseData = response.body().string();
            return response;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
    @Override
    protected void onPostExecute(Response response) {
        if (response != null && response.isSuccessful()) {
            try {

                Intent intent = new Intent();
                intent.putExtra("testIntent", responseData);
                intent.setClass(mainActivity, ResultActivity.class);
                mainActivity.startActivity(intent);
            } catch (Exception e) {
                Toast.makeText(mainActivity,"请稍后再试",Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(mainActivity,"请稍后再试",Toast.LENGTH_SHORT).show();
        }
        progressDialog.dismiss();
    }
}

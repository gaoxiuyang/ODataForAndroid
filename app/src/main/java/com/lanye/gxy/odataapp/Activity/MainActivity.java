package com.lanye.gxy.odataapp.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.lanye.gxy.odataapp.Request.DeleteRequest;
import com.lanye.gxy.odataapp.Request.GetRequest;
import com.lanye.gxy.odataapp.OkHttpUtil.UrlService;
import com.lanye.gxy.odataapp.R;
import com.lanye.gxy.odataapp.Request.PostRequest;
import com.lanye.gxy.odataapp.Request.PutRequest;

import okhttp3.Response;
public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public Button btnQueryByKey,btnPost,btnPut,btnDelete,btnQueryAll,btnQueryOneAttribute;
    public Response response;
    public UrlService urlService = new UrlService();
    public  String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void init() {
        btnPost = (Button) findViewById(R.id.btnPost);
        btnPut = (Button) findViewById(R.id.btnPut);
        btnDelete = (Button) findViewById(R.id.btnDelete);
        btnQueryAll = (Button) findViewById(R.id.btnQueryAll);
        btnQueryByKey = (Button) findViewById(R.id.btnQueryByKey);
        btnQueryOneAttribute = (Button) findViewById(R.id.btnQueryOneAttribute);
        btnQueryOneAttribute.setOnClickListener(this);
        btnQueryAll.setOnClickListener(this);
        btnQueryByKey.setOnClickListener(this);
        btnPost.setOnClickListener(this);
        btnPut.setOnClickListener(this);
        btnDelete.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnQueryOneAttribute:
                url = urlService.GetOneAtt;
                GetRequest getOneAttributeRequest = new GetRequest(MainActivity.this,url);
                getOneAttributeRequest.execute();
                break;
            case R.id.btnQueryAll:
                url = urlService.GetAllURL;
                GetRequest getAllRequest = new GetRequest(MainActivity.this,url);
                getAllRequest.execute();
                break;
            case R.id.btnQueryByKey :
                url = urlService.GetOneByKey;
                GetRequest getByKeyRequest = new GetRequest(MainActivity.this,url);
                getByKeyRequest.execute();
                break;
            case R.id.btnPost:
                url = urlService.ADDURL;
                PostRequest postRequest = new PostRequest(MainActivity.this,url);
                postRequest.execute();
                break;
            case R.id.btnPut:
                url = urlService.PutURL;
                PutRequest putRequest = new PutRequest(MainActivity.this,url);
                putRequest.execute();
                break;
            case R.id.btnDelete:
                url = urlService.DeleteURL;
                DeleteRequest deleteRequest = new DeleteRequest(MainActivity.this,url);
                deleteRequest.execute();
                break;
        }
    }
}

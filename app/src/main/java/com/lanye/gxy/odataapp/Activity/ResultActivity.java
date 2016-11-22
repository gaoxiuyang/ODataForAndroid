package com.lanye.gxy.odataapp.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.lanye.gxy.odataapp.R;


/**
 * Created by Administrator on 2016/11/16.
 */
public class ResultActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        init();
    }

    private void init() {
        Intent intent = getIntent();
        //从Intent当中根据key取得value
        String value = intent.getStringExtra("testIntent");
        TextView tvBack = (TextView) findViewById(R.id.tvBack);
        tvBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ResultActivity.this.finish();
            }
        });
        TextView tvResult = (TextView) findViewById(R.id.tvResult);
        tvResult.setText(value);
    }

}

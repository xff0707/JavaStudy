package com.example.superuicomponents;

import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    int mProgress = 0;//进度条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //进度条-开心消消乐启动界面的进度条
        setContentView(R.layout.progressbartext);
        final ProgressBar progressBar = findViewById(R.id.progressbar);
        final Handler mHandler = new Handler(){
            @Override
            public void handleMessage(@NonNull Message msg) {
                if (msg.what==0x111){
                    progressBar.setProgress(mProgress);
                }else {
                    Toast.makeText(MainActivity.this,"耗时操作已完成",Toast.LENGTH_LONG).show();
                    progressBar.setVisibility(View.GONE);//设置进度条不显示
                }
            }
        };
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    mProgress = doWork();
                    Message m = new Message();
                    if (mProgress<100){
                        m.what = 0x111;
                        mHandler.sendMessage(m);
                    }else {
                        m.what = 0x110;
                        mHandler.sendMessage(m);
                        break;
                    }
                }
            }
            private int doWork(){
                mProgress += Math.random()*10;
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return mProgress;
            }
        }).start();




        /*
        //进度条
        setContentView(R.layout.progressbardemo);
         */
    }
}

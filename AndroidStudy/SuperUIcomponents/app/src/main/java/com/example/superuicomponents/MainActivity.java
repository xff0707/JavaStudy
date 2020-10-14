package com.example.superuicomponents;

import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    //int mProgress = 0;//进度条
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);


        //图像切换器
        setContentView(R.layout.imageswitcherdemo);
        ImageSwitcher is = findViewById(R.id.imageSwichter);
        is.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_out));
        is.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,android.R.anim.fade_in));
        is.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(R.drawable.img01);
                return imageView;
            }
        });
        is.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((ImageSwitcher)v).setImageResource(R.drawable.img02);
            }
        });






        /*
        //实现应用ImageView组件显示图像
        setContentView(R.layout.imageviewtext);






        /*
        //图像视图
        setContentView(R.layout.imageviewdemo);


        /*
        //星级评分条-实现手机淘宝评价页面的星级评分条
        setContentView(R.layout.ratingbartext);
        final RatingBar ratingBar = findViewById(R.id.ratingbar);
        Button button = findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float rating = ratingBar.getRating();
                Toast.makeText(MainActivity.this,"你得到了"+rating+"颗星",Toast.LENGTH_SHORT).show();
            }
        });





        /*
        //星级评分条
        setContentView(R.layout.ratingbardemo);
        RatingBar ratingBar = findViewById(R.id.ratingbar);
        String rating = String.valueOf(ratingBar.getRating());
        Toast.makeText(MainActivity.this,"Rating:"+rating,Toast.LENGTH_SHORT).show();
        String stepSize = String.valueOf(ratingBar.getStepSize());
        Toast.makeText(MainActivity.this,"StepSize:"+stepSize,Toast.LENGTH_SHORT).show();
        String progress = String.valueOf(ratingBar.getProgress());
        Toast.makeText(MainActivity.this,"Progress:"+progress,Toast.LENGTH_SHORT).show();
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                Toast.makeText(MainActivity.this,"rating:"+rating+",fromUser"+fromUser,Toast.LENGTH_SHORT).show();
            }
        });





        /*
        setContentView(R.layout.seekbardemo);
        SeekBar seekBar = findViewById(R.id.seekbar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                //进度改变时
                Toast.makeText(MainActivity.this,"速度改变"+progress,Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                //开始触摸时
                Toast.makeText(MainActivity.this,"开始触摸",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                //结束触摸时
                Toast.makeText(MainActivity.this,"停止触摸",Toast.LENGTH_SHORT).show();
            }
        });


        /*
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

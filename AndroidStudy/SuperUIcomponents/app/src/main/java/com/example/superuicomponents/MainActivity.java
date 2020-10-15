package com.example.superuicomponents;

import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.*;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    //int mProgress = 0;//进度条
    /*
    ImageSwitcher imageSwitcher;
    int index = 0;
    float touchDownX;
    float touchUpX;//图像切换器
    */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        //网格视图
        setContentView(R.layout.gridviewdemo);
        int[] picture = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};
        GridView gridView = findViewById(R.id.gridview);
        List<Map<String,Object>> listitem = new ArrayList<>();
        for (int i = 0; i < picture.length; i++) {
            Map<String,Object> map = new HashMap<>();
            map.put("image",picture[i]);
            listitem.add(map);
        }
        SimpleAdapter simpleAdapter = new SimpleAdapter(this,listitem,R.layout.cell,new String[]{"image"},new int[]{R.id.image});
        gridView.setAdapter(simpleAdapter);






        /*
        //图像切换器-实现类似手机相册的滑动查看相片功能
        setContentView(R.layout.imageswitchertext);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        final int[] arrayPictures = new int[]{R.drawable.img01,R.drawable.img02,R.drawable.img03,R.drawable.img04,R.drawable.img05,R.drawable.img06,R.drawable.img07,R.drawable.img08,R.drawable.img09};
        imageSwitcher = findViewById(R.id.imageSwichter);

        imageSwitcher.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setImageResource(arrayPictures[index]);
                return imageView;
            }
        });
        imageSwitcher.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction()==MotionEvent.ACTION_DOWN){
                    touchDownX = event.getX();
                    return true;
                }else if (event.getAction()==MotionEvent.ACTION_UP){
                    touchUpX = event.getX();
                    if (touchUpX-touchDownX>100){
                        //认为从左向右滑动
                        index = index==0?arrayPictures.length-1:index-1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_left));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_right));
                        imageSwitcher.setImageResource(arrayPictures[index]);
                    }else if (touchDownX-touchUpX>100){
                        //认为从右向左滑动
                        index = index==arrayPictures.length-1?0:index+1;
                        imageSwitcher.setInAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_in_right));
                        imageSwitcher.setOutAnimation(AnimationUtils.loadAnimation(MainActivity.this,R.anim.slide_out_left));
                        imageSwitcher.setImageResource(arrayPictures[index]);
                    }
                    return true;
                }
                return false;
            }
        });



        /*
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
        //拖动条
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

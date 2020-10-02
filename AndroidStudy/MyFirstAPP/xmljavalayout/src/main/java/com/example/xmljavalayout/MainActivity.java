package com.example.xmljavalayout;

import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ImageView[] img = new ImageView[12];
    private int[] imagePath = new int[]{
        R.mipmap.image01,R.mipmap.image02,R.mipmap.image03,R.mipmap.image04
            ,R.mipmap.image05,R.mipmap.image06,R.mipmap.image07,R.mipmap.image08
            ,R.mipmap.image09,R.mipmap.image10,R.mipmap.image11,R.mipmap.image12
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GridLayout layout = (GridLayout) findViewById(R.id.layout);
        for (int i = 0; i < imagePath.length; i++) {
            img[i] = new ImageView(MainActivity.this);
            img[i].setImageResource(imagePath[i]);
            img[i].setPadding(2,2,2,2);
            ViewGroup.LayoutParams params = new ViewGroup.LayoutParams(116,68);
            img[i].setLayoutParams(params);
            layout.addView(img[i]);
        }
    }
}

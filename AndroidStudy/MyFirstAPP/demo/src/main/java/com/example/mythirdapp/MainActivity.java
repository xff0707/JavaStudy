package com.example.mythirdapp;

import android.view.View;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.edittextdemo);
        //setContentView(R.layout.edittexttext);


        setContentView(R.layout.radiobuttondemo);
        final RadioGroup radioGroup = findViewById(R.id.radiogroup1);
        final TextView t = findViewById(R.id.text1);
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton r = findViewById(checkedId);
                System.out.println(r.getText());
                t.setText("（"+(char)(checkedId+64)+"）");
                Toast.makeText(MainActivity.this,"您选择了："+r.getText(),Toast.LENGTH_LONG).show();
            }
        });

        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for (int i = 0; i < radioGroup.getChildCount(); i++) {
                    RadioButton r = (RadioButton) radioGroup.getChildAt(i);
                    if (r.isChecked()){
                        //String boo = (i==3)?"，您的答案是正确的":"，您的答案是错误的";
                        //Toast.makeText(MainActivity.this,r.getText()+boo,Toast.LENGTH_LONG).show();
                        if (i==3){
                            Toast.makeText(MainActivity.this,"回答正确",Toast.LENGTH_LONG).show();
                        }else {
                            AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                            builder.setMessage("回答错误，没有解析谢谢");
                            builder.setPositiveButton("确定",null).show();
                        }
                        break;
                    }
                }
            }
        });


        /*
        setContentView(R.layout.imagebuttontext);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏显示
        ImageButton start = findViewById(R.id.start);
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"您单击了开始游戏按钮",Toast.LENGTH_LONG).show();
            }
        });
        ImageButton switch1 = findViewById(R.id.switch1);
        switch1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"您单击了切换账号按钮",Toast.LENGTH_LONG).show();
            }
        });
        */

        /*
        setContentView(R.layout.buttontext);

        Button log = findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"您已授权登录开心消消乐",Toast.LENGTH_LONG).show();
            }
        });
        */

        /*
        setContentView(R.layout.buttondemo);

        //单击事件监听器
        Button button = findViewById(R.id.button1);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"单击了按钮1",Toast.LENGTH_SHORT).show();
            }
        });
        */



        /*
        EditText et = findViewById(R.id.et1);//Android Studio需要强转类型
        et.getText();//获取编辑框类型

         */
    }
    public void myClick(View view){
        Toast.makeText(MainActivity.this,"单击了按钮2",Toast.LENGTH_LONG).show();
    }
}

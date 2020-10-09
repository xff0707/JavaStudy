package com.example.mythirdapp;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.edittextdemo);
        //setContentView(R.layout.edittexttext);



        setContentView(R.layout.buttontext);

        Button log = findViewById(R.id.login);
        log.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this,"您已授权登录开心消消乐",Toast.LENGTH_LONG).show();
            }
        });


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

package com.example.mythirdapp;

import android.app.Activity;
import android.os.SystemClock;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.*;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
//public class MainActivity extends Activity {//日期选择器显示不全需要继承Activity
//int year,month,day;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        //setContentView(R.layout.edittextdemo);
        //setContentView(R.layout.edittexttext);






        setContentView(R.layout.chronometertext);
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);//设置全屏
        //requestWindowFeature(Window.FEATURE_NO_TITLE);//报错？？
        final Chronometer ch = findViewById(R.id.chronometer);
        //ch.setBase(System.currentTimeMillis());
        ch.setBase(SystemClock.elapsedRealtime());//起始时间
        ch.setFormat("%s");//时间格式
        ch.start();
        ch.setOnChronometerTickListener(new Chronometer.OnChronometerTickListener() {
            @Override
            public void onChronometerTick(Chronometer chronometer) {
                if (SystemClock.elapsedRealtime()-ch.getBase()>=60*1000){
                    ch.stop();
                }
            }
        });


        //setContentView(R.layout.chronometerdemo);

        /*
        //时间选择器
        setContentView(R.layout.timepicker);
        TimePicker tp = findViewById(R.id.timepicker);
        tp.setIs24HourView(true);
        tp.setOnTimeChangedListener(new TimePicker.OnTimeChangedListener() {
            @Override
            public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
                String str = hourOfDay+"时"+minute+"分";
                Toast.makeText(MainActivity.this,str,Toast.LENGTH_SHORT).show();
            }
        });
        */

        /*
        //日期选择器
        setContentView(R.layout.datepickerdemo);
        DatePicker datePicker = findViewById(R.id.datepicker);
        Calendar calendar = Calendar.getInstance();
        year = calendar.get(calendar.YEAR);
        month = calendar.get(calendar.MONTH);
        day = calendar.get(calendar.DAY_OF_MONTH);
        datePicker.init(year,month,day, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                MainActivity.this.year = year;//更改本类中的年月日为选中的日期
                MainActivity.this.month = monthOfYear;
                MainActivity.this.day = dayOfMonth;
                show(year,monthOfYear,dayOfMonth);
            }
        });
        */


        /*
        //复选框
        setContentView(R.layout.checkboxtext);
        final Button btn_login = findViewById(R.id.btn_login);
        final CheckBox checkBox1 = findViewById(R.id.checkbox1);
        final CheckBox checkBox2 = findViewById(R.id.checkbox2);
        final CheckBox checkBox3 = findViewById(R.id.checkbox3);
        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = "";
                if (checkBox1.isChecked())
                    text+=checkBox1.getText().toString();
                if (checkBox2.isChecked())
                    text+=checkBox2.getText().toString();
                if (checkBox3.isChecked())
                    text+=checkBox3.getText().toString();
                Toast.makeText(MainActivity.this,text,Toast.LENGTH_LONG).show();
            }
        });
        */

        /*
        setContentView(R.layout.checkboxdemo);
        final CheckBox cb = findViewById(R.id.like1);
        cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (cb.isChecked())
                    Toast.makeText(MainActivity.this,cb.getText(),Toast.LENGTH_LONG).show();

            }
        });
        */

        /*
        //单选按钮
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
        */


        /*
        //图片按钮
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
        //图片按钮
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
        //按钮
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
        //编辑框
        EditText et = findViewById(R.id.et1);//Android Studio需要强转类型
        et.getText();//获取编辑框类型

         */
    }
    public void myClick(View view){
        Toast.makeText(MainActivity.this,"单击了按钮2",Toast.LENGTH_LONG).show();
    }



    private void show(int year, int month, int day){
        //配合日期选择器使用
        String str = year+"年"+(month+1)+"月"+day+"日";
        Toast.makeText(MainActivity.this,str,Toast.LENGTH_LONG).show();
    }
}

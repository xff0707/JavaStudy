package javastudy25days.Day18;

import java.util.Random;

import static java.lang.Math.ceil;
/*
练习：给定一个小数，
保留该小数的后两位

 */

public class MathDemo {
    public static void main(String[] args) {

        Random r = new Random();
        for(int x=0;x<10;x++)
        {
            //double d = (int) (Math.random()*10 + 1);
            int d = r.nextInt(10)+1;
            System.out.println(d);
        }
        show();
    }

    public static void show()
    {
        double d = ceil(12.34);
        double d0 = ceil(-12.34);//ceil返回大于指定数据的最小整数

        System.out.println("d="+d+",d1="+d0);


        double d1 = Math.floor(12.34);//floor返回小于指定数据的最小整数
        System.out.println("d1="+d1);

        long l = Math.round(12.34);//四舍五入
        System.out.println("l="+l);

        double d2 = Math.pow(2,3);
        System.out.println("d2="+d2);

    }



}

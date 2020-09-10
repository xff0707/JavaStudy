package supplementary.api;

import java.text.DecimalFormat;

public class NumberFormatDemo {
    public static void main(String[] args) {
        double d = 8888888.66666666;
        //默认构造函数，小数点后保留3位，每3位用逗号隔开
        DecimalFormat df = new DecimalFormat();
        //设置小数点后的位数
        df.setMaximumFractionDigits(4);
        //设置整数的位数
        df.setMaximumIntegerDigits(6);
        String dStr = df.format(d);
        System.out.println(dStr);

        double d1 = 0.123;
        df.applyPattern("##.##%");
        //String s = df.format(d1);
        df.applyPattern("0.###E0");

        double d2 = 80310140;
        String s = df.format(d2);
        System.out.println(s);


        format1("###,###.###",111222.34567) ;
        format1("000,000.000",11222.34567) ;
        format1("###,###.###￥",111222.34567) ;
        format1("000,000.000￥",11222.34567) ;
        format1("##.###%",0.345678) ;
        format1("00.###%",0.0345678) ;
        format1("###.###\u2030",0.345678) ;
    }


    public static void format1(String pattern,double value){	// 此方法专门用于完毕数字的格式化显示
        DecimalFormat df = null ;			// 声明一个DecimalFormat类的对象
        df = new DecimalFormat(pattern) ;	// 实例化对象，传入模板
        String str = df.format(value) ;		// 格式化数字
        System.out.println("使用" + pattern
                + "格式化数字" + value + "：" + str) ;
    }
}

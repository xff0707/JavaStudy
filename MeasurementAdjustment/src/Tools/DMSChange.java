package tools;

import java.text.DecimalFormat;

/**
 *用于坐标转换的工具类
 */
public class DMSChange {
    /**
     * 度.分秒(d.mmss)转弧度
     * @param dms 输入值为：度.分秒，例如90°30‘30’写成90.3030
     * @return 输出对应弧度值,取值范围为[0,2*PI)
     */
    public static double dmsToRad(double dms)
    {
        int deg = (int)dms;
        double m = (int)(dms*100-deg*100);
        double s = (dms*10000-deg*10000-m*100);
        double d = deg+m/60+s/3600;
        //double rad = Math.toRadians(dms);
        double rad = d*Math.PI/180;
        return rad;
    }


    /**
     * 弧度值转DD.mmss字符串
     * @param rad 弧度值
     * @return 输出DD.mmss格式字符串
     */
    public static String radToDMSStr(double rad)
    {
        double dd,mm,ss,deg;
        deg = rad * 180 / Math.PI;
        dd = (int) deg;
        mm = (int) (60 * (deg - dd));
        ss = 60 * (60 * (deg - dd) - mm);
        DecimalFormat df1 = new DecimalFormat();
        df1.setMaximumFractionDigits(2);//小数点后保留位数
        DecimalFormat df2 = new DecimalFormat();
        df2.setMaximumIntegerDigits(2);
        df2.setMinimumFractionDigits(0);
        DecimalFormat df3 = new DecimalFormat();
        df3.setMaximumFractionDigits(0);
        return df3.format(dd)+"°"+df2.format(mm)+"′"+df1.format(ss)+"″";
    }

}

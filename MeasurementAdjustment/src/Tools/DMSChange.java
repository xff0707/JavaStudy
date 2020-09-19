package tools;

import java.text.DecimalFormat;

/**
 *��������ת���Ĺ�����
 */
public class DMSChange {
    /**
     * ��.����(d.mmss)ת����
     * @param dms ����ֵΪ����.���룬����90��30��30��д��90.3030
     * @return �����Ӧ����ֵ,ȡֵ��ΧΪ[0,2*PI)
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
     * ����ֵתDD.mmss�ַ���
     * @param rad ����ֵ
     * @return ���DD.mmss��ʽ�ַ���
     */
    public static String radToDMSStr(double rad)
    {
        double dd,mm,ss,deg;
        deg = rad * 180 / Math.PI;
        dd = (int) deg;
        mm = (int) (60 * (deg - dd));
        ss = 60 * (60 * (deg - dd) - mm);
        DecimalFormat df1 = new DecimalFormat();
        df1.setMaximumFractionDigits(2);//С�������λ��
        DecimalFormat df2 = new DecimalFormat();
        df2.setMaximumIntegerDigits(2);
        df2.setMinimumFractionDigits(0);
        DecimalFormat df3 = new DecimalFormat();
        df3.setMaximumFractionDigits(0);
        return df3.format(dd)+"��"+df2.format(mm)+"��"+df1.format(ss)+"��";
    }

}

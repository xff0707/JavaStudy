package supplementary.api;

import java.text.DecimalFormat;

public class NumberFormatDemo {
    public static void main(String[] args) {
        double d = 8888888.66666666;
        //Ĭ�Ϲ��캯����С�������3λ��ÿ3λ�ö��Ÿ���
        DecimalFormat df = new DecimalFormat();
        //����С������λ��
        df.setMaximumFractionDigits(4);
        //����������λ��
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
        format1("###,###.###��",111222.34567) ;
        format1("000,000.000��",11222.34567) ;
        format1("##.###%",0.345678) ;
        format1("00.###%",0.0345678) ;
        format1("###.###\u2030",0.345678) ;
    }


    public static void format1(String pattern,double value){	// �˷���ר������������ֵĸ�ʽ����ʾ
        DecimalFormat df = null ;			// ����һ��DecimalFormat��Ķ���
        df = new DecimalFormat(pattern) ;	// ʵ�������󣬴���ģ��
        String str = df.format(value) ;		// ��ʽ������
        System.out.println("ʹ��" + pattern
                + "��ʽ������" + value + "��" + str) ;
    }
}

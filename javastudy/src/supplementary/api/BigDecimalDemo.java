package supplementary.api;

import java.math.BigDecimal;

public class BigDecimalDemo {
    public static void main(String[] args) {
        System.out.println(0.1+0.2);
        System.out.println((1.4-0.5)/0.9);
        BigDecimal bd1 = new BigDecimal("0.1");
        BigDecimal bd2 = new BigDecimal("0.2");

        //��
        BigDecimal bd3 = bd1.add(bd2);
        System.out.println("0.1+0.2="+bd3);
        //System.out.println(bd3.toString());

        //��
        BigDecimal bd4 = bd1.subtract(bd2);
        System.out.println("0.1-0.2="+bd4);

        //��
        BigDecimal bd5 = bd1.multiply(bd2);
        System.out.println("0.1*0.2="+bd5);

        //��
        BigDecimal bd6 = bd1.divide(bd2);
        System.out.println("0.1/0.2="+bd6);




        //����
        BigDecimal bd7 = bd1.divide(bd3,2,BigDecimal.ROUND_HALF_UP);
        System.out.println(bd7);


        BigDecimal bd8 = new BigDecimal("2").pow(10);
        System.out.println(bd8);

    }
}

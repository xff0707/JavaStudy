package javastudy25days.Day13;/*
JDK1.5版本以后出现的新特性。

 */

public class IntegerDemo1 {
    public static void main(String[] args) {
        //Integer x = new Integer(4);
        Integer x = 4;//自动装箱
        x = x/*x.intValue()*/ + 2;//x=2 进行自动拆箱，变成int类型和2进行加法运算
                    //再将和进行装箱赋给x
        //Integer y = null;//可以为空 先判断再运算，否则会有异常


        Integer m = 128;
        Integer n = 128;
        System.out.println("m==n:"+(m==n));//m==n:false

        Integer a = 127;
        Integer b = 127;
        System.out.println("a==b:"+(a==b));//a==b:true结果为true，因为a和b指向了同一个Integer对象，
                                            //因为当数值在byte范围内时，对于新特性，如果该数值已经存在，则不会再开辟新的空间。
        a = 128;
        System.out.println("a="+a);
        System.out.println("b="+b);

    }

    public static void method()
    {
        Integer x = new Integer("123");


        Integer y = new Integer(123);

        System.out.println("x==y:"+(x==y));//false
        System.out.println("x.equals(y):"+x.equals(y));//true
    }
}

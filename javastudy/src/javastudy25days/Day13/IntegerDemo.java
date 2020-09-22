package javastudy25days.Day13;

/*
基本数据类型对象包装类。

byte    Byte
short   Short
int     Integer
long    Long
boolean Boolean
float   Float
double  Double
char    Character



基本数据类型对象包装类的最常见作用，
就是用于基本数据类型和字符串类型之间做转换

基本数据类型转成字符串

        基本数据类型+""

        基本数据类型.toString(基本数据类型);

        如：  Integer.toString(34);//将34整数变成"34"

字符串转成基本数据类型

    xxx a = Xxx.parseXxx(String);

    int num = Integer.parseInt("123");

    double d = Double.parseDouble("123")

    boolean b = Boolean.parseBoolean("true");

    Integer i = new Integer("123");
    int num = i.intValue();

十进制转成其他进制
    toBinaryString()
    toHexString()
    Integer.toOctalString()

其他进制转成十进制
    pareseInt(string,radix);

*/
public class IntegerDemo {
    public static void main(String[] args) {
        //整数类型的最大值。
        //System.out.println("int max="+Integer.MAX_VALUE);

        //将一个字符串转换成整数。
        int num = Integer.parseInt("123");//必须传入数字格式的字符串
        //long x = Long.parseLong("123");

        //System.out.println("num="+num+x);

        //System.out.println(Integer.toBinaryString(-6));
        //System.out.println(Integer.toHexString(60));

        int x = Integer.parseInt("3c",16);
        System.out.println("x="+x);

    }
}

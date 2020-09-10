package playmyself;

public class Myplayer {
    public static void main(String[] args) {
        //byte b = 125;
        //System.out.println(b);
        //byte b = 3;
        //b = (byte)(b + 2);//强制转换
        //System.out.println(b);
        /*
        int x = 4;x = 10;
        byte b = 2;//-128~127
        //byte b1=128;//会报错
        short i = 41;
        float f = 2.3f;
        double d = 34.56;
        char ch = '4';					char ch1 = ' ';
        boolean bo = true;*/

/*
        int x = 4270;
        x = x / 1000 * 1000;
        System.out.println(x);
        System.out.println("a="+a+","+"b="+b);

        //字符串数据和任何数据使用+都是相连接，最终都会变成字符串
        System.out.println("5+5="+(5+5));
        int a,b,c;
        a = b = c = 5;

        //逻辑运算符用于连接boolean类型的表达式

        //x>3 & x<6 =true & true =true

        /*
        & 和    一假即假 全部运算
        | 或    一真即真
        ^ 亦或  两边相同为假，不同为真
        ! 非    反
        && 与   左边为假时右边不运算
        || 或   左边为真时右边不运算

        */
/*
        int m,n;
        m=3;
        n=8;
        System.out.println("m="+m+",n="+n);
        //1.通过第三方变量 开发时使用
        int temp;
        temp=m;
        m=n;
        n=temp;
        System.out.println("m="+m+",n="+n);

        //2.不用第三方变量
        n = n + m;//如果m和n的值非常大，容易超出范围
        m = n - m;
        n = n - m;
        System.out.println("m="+m+",n="+n);
        //3.技巧型方式
        n = n ^ m;
        m = n ^ m;//(n^m)^m
        n = n ^ m;//n^(n^m)
        System.out.println("m="+m+",n="+n);
*/

/*
        System.out.println(Integer.toBinaryString(60));

        int num=60;
        //获取60的最低四位，通过&15；
        //num & 15=12;
        int n1=num&15;
        System.out.println((char)(n1-10+'A'));
        //要获取下一组四位，将60右移四位。
        int temp =60>>4;//只能双右移，三位负数会循环
        //对temp的值进行最低四位的获取。
        //temp&15=3;
        int n2=temp &15;
        System.out.println(n2);
      /*
      0-9 'A' 'B' 'C' 'D' 'E' 'F'
           65  66  67
          10  11  12  13  14  15
      12-10=2+'A'=(char)67
      */
/*
        int x=3,y;
        y=(x>1)?100:200;
        System.out.println(y);
*/

    Son s = new Son();
    s.show();

    }
}

class Father
{
    private int x = 6;
    public void show()
    {
        System.out.println(x);
    }
}

class Son extends Father
{
    @Override
    public void show() {
        super.show();
    }
}
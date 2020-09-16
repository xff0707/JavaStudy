package supplementary.reflect;

public class test2 {
    public static void main(String[] args) {
        //类加载内存分析

        /*
        1.加载到内存，会产生一个类对应Class对象
        2.链接，链接结束后m=0
        3.初始化
            <clinit>(){
                Systrm.out.println("");
                m=0;默认值

                m=300;
                m=100;
            }



         */
        A a = new A();
        System.out.println(A.m);
    }
}

class A{
    static{
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A(){
        System.out.println("A类的无参构造初始化");
    }

}
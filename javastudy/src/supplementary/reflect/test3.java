package supplementary.reflect;

public class test3 {
    static {
        System.out.println("main类被加载");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //主动引用
        //Son s = new Son();

        //反射也会产生主动引用
        Class.forName("supplementary.reflect.Son");
    }
}

class Father{
    static int b = 2;
    static{
        System.out.println("父类被加载");
    }
}

class Son extends Father{
    static {
        System.out.println("子类被加载");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}

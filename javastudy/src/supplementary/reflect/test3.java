package supplementary.reflect;

public class test3 {
    static {
        System.out.println("main�౻����");
    }
    public static void main(String[] args) throws ClassNotFoundException {
        //��������
        //Son s = new Son();

        //����Ҳ�������������
        Class.forName("supplementary.reflect.Son");
    }
}

class Father{
    static int b = 2;
    static{
        System.out.println("���౻����");
    }
}

class Son extends Father{
    static {
        System.out.println("���౻����");
        m = 300;
    }
    static int m = 100;
    static final int M = 1;
}

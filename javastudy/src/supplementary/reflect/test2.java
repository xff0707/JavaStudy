package supplementary.reflect;

public class test2 {
    public static void main(String[] args) {
        //������ڴ����

        /*
        1.���ص��ڴ棬�����һ�����ӦClass����
        2.���ӣ����ӽ�����m=0
        3.��ʼ��
            <clinit>(){
                Systrm.out.println("");
                m=0;Ĭ��ֵ

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
        System.out.println("A�ྲ̬������ʼ��");
        m = 300;
    }

    static int m = 100;

    public A(){
        System.out.println("A����޲ι����ʼ��");
    }

}
package javastudy25days.Day13;/*
JDK1.5�汾�Ժ���ֵ������ԡ�

 */

public class IntegerDemo1 {
    public static void main(String[] args) {
        //Integer x = new Integer(4);
        Integer x = 4;//�Զ�װ��
        x = x/*x.intValue()*/ + 2;//x=2 �����Զ����䣬���int���ͺ�2���мӷ�����
                    //�ٽ��ͽ���װ�丳��x
        //Integer y = null;//����Ϊ�� ���ж������㣬��������쳣


        Integer m = 128;
        Integer n = 128;
        System.out.println("m==n:"+(m==n));//m==n:false

        Integer a = 127;
        Integer b = 127;
        System.out.println("a==b:"+(a==b));//a==b:true���Ϊtrue����Ϊa��bָ����ͬһ��Integer����
                                            //��Ϊ����ֵ��byte��Χ��ʱ�����������ԣ��������ֵ�Ѿ����ڣ��򲻻��ٿ����µĿռ䡣
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

package supplementary.reflect;

import java.lang.annotation.ElementType;

public class test {
    public static void main(String[] args) {
        Class c1 = Object.class;//��
        Class c2 = Comparable.class;//�ӿ�
        Class c3 = String[].class;//����
        Class c4 = int[][].class;//��ά����
        Class c5 = Override.class;//ע��
        Class c6 = ElementType.class;//ö��
        Class c7 = Integer.class;//������������
        Class c8 = void.class;//void
        Class c9 = Class.class;//Class

        System.out.println("c1:"+c1);
        System.out.println("c2:"+c2);
        System.out.println("c3:"+c3);
        System.out.println("c4:"+c4);
        System.out.println("c5:"+c5);
        System.out.println("c6:"+c6);
        System.out.println("c7:"+c7);
        System.out.println("c8:"+c8);
        System.out.println("c9:"+c9);

        //ֻҪԪ��������ά��һ��������ͬһ��Class
        int[] a = new int[10];
        int[] b = new int[100];
        System.out.println(a.getClass().hashCode());
        System.out.println(b.getClass().hashCode());



    }
}

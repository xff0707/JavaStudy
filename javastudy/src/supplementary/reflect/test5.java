package supplementary.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
        //��ͨ��ʽ10�ڴΣ�3
        //���䷽ʽ10�ڴΣ�2892
        //�رռ��10�ڴΣ�1075
    }


    //��ͨ��ʽ����
    public static void test01()
    {
        User u = new User();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            u.getName();
        }

        long end = System.currentTimeMillis();

        System.out.println("��ͨ��ʽ10�ڴΣ�"+(end-start));
    }

    //���䷽ʽ����
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class c1 = u.getClass();
        Method getName = c1.getDeclaredMethod("getName",null);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(u,null);
        }

        long end = System.currentTimeMillis();

        System.out.println("���䷽ʽ10�ڴΣ�"+(end-start));
    }


    //���䷽ʽ���ã��رռ��
    public static void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class c1 = u.getClass();
        Method getName = c1.getDeclaredMethod("getName",null);
        getName.setAccessible(true);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(u,null);
        }

        long end = System.currentTimeMillis();

        System.out.println("�رռ��10�ڴΣ�"+(end-start));
    }

}

class User{
    String  name;

    public String getName() {
        return name;
    }
}
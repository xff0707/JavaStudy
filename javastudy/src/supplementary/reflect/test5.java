package supplementary.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class test5 {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {
        test01();
        test02();
        test03();
        //普通方式10亿次：3
        //反射方式10亿次：2892
        //关闭检测10亿次：1075
    }


    //普通方式调用
    public static void test01()
    {
        User u = new User();

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            u.getName();
        }

        long end = System.currentTimeMillis();

        System.out.println("普通方式10亿次："+(end-start));
    }

    //反射方式调用
    public static void test02() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        User u = new User();
        Class c1 = u.getClass();
        Method getName = c1.getDeclaredMethod("getName",null);

        long start = System.currentTimeMillis();

        for (int i = 0; i < 1000000000; i++) {
            getName.invoke(u,null);
        }

        long end = System.currentTimeMillis();

        System.out.println("反射方式10亿次："+(end-start));
    }


    //反射方式调用，关闭检测
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

        System.out.println("关闭检测10亿次："+(end-start));
    }

}

class User{
    String  name;

    public String getName() {
        return name;
    }
}
package supplementary.fanshe;

import java.lang.reflect.Method;

public class ReflectDemo4 {
    public static void main(String[] args) throws Exception{
        //getMethodDemo_1();
        //getMethodDemo_2();
        getMethodDemo_3();
    }

    public static void getMethodDemo_3() throws Exception
    {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        Method method = clazz.getMethod("paramMethod",String.class,int.class);
        Object obj = clazz.newInstance();
        method.invoke(obj,"小强",60);
    }

    public static void getMethodDemo_2() throws Exception
    {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        Method method = clazz.getMethod("show",null);

    }

    /*
    * 获取指定class中的公共函数
    * */
    public static void getMethodDemo_1() throws Exception
    {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        Method[] methods = null;//clazz.getMethods();
        methods = clazz.getDeclaredMethods();
        for (Method m:methods)
        {
            System.out.println(m);
        }

    }
}

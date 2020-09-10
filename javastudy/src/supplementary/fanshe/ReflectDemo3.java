package supplementary.fanshe;

import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        getFieldDemo();
    }

    //获取字节码文件中的字段
    public static void getFieldDemo() throws Exception
    {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        //Field field = clazz.getDeclaredField("name");//getField("age")只能获取公有

        Field field = clazz.getDeclaredField("age");//只获取本类，但包含私有
        //System.out.println(field);
        field.setAccessible(true);//对私有字段的访问取消权限检查。暴力访问
        Object obj = clazz.newInstance();
        Object o = field.get(obj);
        System.out.println(o);

    }
}

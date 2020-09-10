package supplementary.fanshe;

import java.lang.reflect.Field;

public class ReflectDemo3 {
    public static void main(String[] args) throws Exception {
        getFieldDemo();
    }

    //��ȡ�ֽ����ļ��е��ֶ�
    public static void getFieldDemo() throws Exception
    {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        //Field field = clazz.getDeclaredField("name");//getField("age")ֻ�ܻ�ȡ����

        Field field = clazz.getDeclaredField("age");//ֻ��ȡ���࣬������˽��
        //System.out.println(field);
        field.setAccessible(true);//��˽���ֶεķ���ȡ��Ȩ�޼�顣��������
        Object obj = clazz.newInstance();
        Object o = field.get(obj);
        System.out.println(o);

    }
}

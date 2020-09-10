package supplementary.fanshe;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        //createNewObject_1();
        createNewObject_2();
    }

    public static void createNewObject_2() throws Exception {
        //supplementary.fanshe.Person p = new supplementary.fanshe.Person("Сǿ",13);
        /*
        * ����ȡָ�����ƶ�Ӧ���е������ֵĶ���ʱ�����ö����ʼ����ʹ�ÿղ����������ô���أ�
        * ��Ȼ��ͨ��ָ���Ĺ��캯�����ж����ʼ��
        * ����Ӧ���Ȼ�ȡ���ù��캯����ͨ���ֽ����ļ����󼴿����
        * �÷����ǣ�getConstructors
        *
        * */
        String name = "supplementary.fanshe.Person";
        Class clazz = Class.forName(name);
        Constructor constructor = clazz.getConstructor(String.class,int.class);

        //ͨ���ù����������newInstance�������ж���ĳ�ʼ��
        Object obj = constructor.newInstance("С��",38);


    }


    public static void createNewObject_1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //���ڣ�new��ʱ��������������Ѱ����ֽ����ļ������������ڴ棬�������ֽ����ļ����󣬲����Ŵ������ֽ����ļ���Ӧ��Person����
        //supplementary.fanshe.Person p = new supplementary.fanshe.Person();

        //����
        String name = "supplementary.fanshe.Person";
        //��Ѱ���������ļ��������ؽ��ڴ棬������class����
        Class clazz = Class.forName(name);
        //��β�������Ķ����أ�
        Object obj = clazz.newInstance();
    }
}

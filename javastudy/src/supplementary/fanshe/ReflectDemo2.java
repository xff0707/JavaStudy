package supplementary.fanshe;

import java.lang.reflect.Constructor;

public class ReflectDemo2 {
    public static void main(String[] args) throws Exception{
        //createNewObject_1();
        createNewObject_2();
    }

    public static void createNewObject_2() throws Exception {
        //supplementary.fanshe.Person p = new supplementary.fanshe.Person("小强",13);
        /*
        * 当获取指定名称对应类中的所体现的对象时，而该对象初始化不使用空参数构造该怎么办呢？
        * 既然是通过指定的构造函数进行对象初始化
        * 所以应该先获取到该构造函数，通过字节码文件对象即可完成
        * 该方法是：getConstructors
        *
        * */
        String name = "supplementary.fanshe.Person";
        Class clazz = Class.forName(name);
        Constructor constructor = clazz.getConstructor(String.class,int.class);

        //通过该构造器对象的newInstance方法进行对象的初始化
        Object obj = constructor.newInstance("小明",38);


    }


    public static void createNewObject_1() throws IllegalAccessException, InstantiationException, ClassNotFoundException {
        //早期，new的时候根据类的名称找寻类的字节码文件，并加载在内存，创建该字节码文件对象，并接着创建该字节码文件对应的Person对象
        //supplementary.fanshe.Person p = new supplementary.fanshe.Person();

        //现在
        String name = "supplementary.fanshe.Person";
        //找寻该名称类文件，并加载进内存，并产生class对象
        Class clazz = Class.forName(name);
        //如何产生该类的对象呢？
        Object obj = clazz.newInstance();
    }
}

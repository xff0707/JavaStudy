package supplementary.reflect;

public class test4 {
    public static void main(String[] args) throws ClassNotFoundException {
        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取系统类加载器的父类-->根加载器
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        //jdk.internal.loader.ClassLoaders$PlatformClassLoader@10f87f48
        //null
        //测试当前类是哪个加载器加载的
        ClassLoader classLoader = Class.forName("supplementary.reflect.test4").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内部的类是谁加载的（根）
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获得系统类加载器可以加载的路径
        System.out.println(System.getProperty("java.class.path"));
        //E:\IDEA-workspace\javastudy\out\production\javastudy;E:\IDEA-workspace\javastudy\lib\jsoup-1.13.1.jar

        //双亲委派机制
            //java.lang.String，自定义的不会运行，安全


    }
}

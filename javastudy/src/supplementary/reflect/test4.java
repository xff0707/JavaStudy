package supplementary.reflect;

public class test4 {
    public static void main(String[] args) throws ClassNotFoundException {
        //��ȡϵͳ��ļ�����
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //��ȡϵͳ��������ĸ���-->��չ�������
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //��ȡϵͳ��������ĸ���-->��������
        ClassLoader parent1 = parent.getParent();
        System.out.println(parent1);

        //jdk.internal.loader.ClassLoaders$AppClassLoader@3fee733d
        //jdk.internal.loader.ClassLoaders$PlatformClassLoader@10f87f48
        //null
        //���Ե�ǰ�����ĸ����������ص�
        ClassLoader classLoader = Class.forName("supplementary.reflect.test4").getClassLoader();
        System.out.println(classLoader);

        //����JDK�ڲ�������˭���صģ�����
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //��λ��ϵͳ����������Լ��ص�·��
        System.out.println(System.getProperty("java.class.path"));
        //E:\IDEA-workspace\javastudy\out\production\javastudy;E:\IDEA-workspace\javastudy\lib\jsoup-1.13.1.jar

        //˫��ί�ɻ���
            //java.lang.String���Զ���Ĳ������У���ȫ


    }
}

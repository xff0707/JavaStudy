package supplementary.fanshe;

public class ReflectDemo1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //getClassObject_1();
        //getClassObject_2();
        getClassObject_3();
    }

    public static void getClassObject_3() throws ClassNotFoundException {
        Class clazz = Class.forName("supplementary.fanshe.Person");
        System.out.println(clazz);
    }

    public static void getClassObject_2()
    {
        Class clazz = Person.class;
        Class clazz1 = Person.class;
        System.out.println(clazz==clazz1);
    }

    //获取字节码对象的方式
    public static void getClassObject_1()
    {
        //1. Object类中的getClass()方法
        Person p = new Person();
        //Class<Person> clazz = p.getClass();
        Class clazz = p.getClass();

        Person p1 = new Person();
        Class class1 = p1.getClass();
        System.out.println(p==p1);

    }
}

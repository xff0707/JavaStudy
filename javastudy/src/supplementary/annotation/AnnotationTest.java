package supplementary.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

public class AnnotationTest {
    public static void main(String[] args) {
        Date data = new Date(2020,9,15);//��ʱ�ˣ��������ã�������ʹ�ã����ڸ��õ�ѡ��

        System.out.println(data);
        @SuppressWarnings("unused")
        int num = 10;//numΪ��ɫ��ʾ������û���ã����ᾯ��

        @SuppressWarnings({"unused", "rawtypes"})
        ArrayList list = new ArrayList();

        Class clazz = Student.class;
        Annotation[] annotations = clazz.getAnnotations();
        for (int i = 0; i < annotations.length; i++) {
            System.out.println(annotations[i]);
        }
    }
}

interface Info{
    void show();
}

//@MyAnnotation(value = "halou")
//@MyAnnotation(value = "hi")
//jdk8֮ǰ��������
//@MyAnnotations({@MyAnnotation(value = "halou"),@MyAnnotation(value = "hi")})
//@MyAnnotation(value = "hi")
//@MyAnnotation(value = "haha")
class Person{
    private String name;
    private int age;

    public Person() {
    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void work()
    {
        System.out.println("����·");
    }

    public void eat()
    {
        System.out.println("�˳Է�");
    }
}

class Student extends Person implements Info{
    @Override
    public void work() {
        System.out.println("ѧ����·");
    }

    @Override
    public void show() {
        System.out.println("Student Show");
    }
}


//�����͵�ע�����@Target({ElementType.TYPE_PARAMETER})
class Generic<@MyAnnotation T>{
    //ע�����ElementType.TYPE_USE
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }

}


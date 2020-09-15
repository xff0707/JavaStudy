package supplementary.annotation;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Date;

public class AnnotationTest {
    public static void main(String[] args) {
        Date data = new Date(2020,9,15);//过时了，还可以用，不建议使用，存在更好的选择

        System.out.println(data);
        @SuppressWarnings("unused")
        int num = 10;//num为灰色表示定义了没有用，不会警告

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
//jdk8之前的做法：
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
        System.out.println("人走路");
    }

    public void eat()
    {
        System.out.println("人吃饭");
    }
}

class Student extends Person implements Info{
    @Override
    public void work() {
        System.out.println("学生走路");
    }

    @Override
    public void show() {
        System.out.println("Student Show");
    }
}


//给泛型的注解加上@Target({ElementType.TYPE_PARAMETER})
class Generic<@MyAnnotation T>{
    //注解加入ElementType.TYPE_USE
    public void show() throws @MyAnnotation RuntimeException{
        ArrayList<@MyAnnotation String> list = new ArrayList<>();
        int num = (@MyAnnotation int) 10L;
    }

}


package supplementary.reflect;

import java.lang.annotation.*;
import java.lang.reflect.Field;

public class test7 {
    //ORM
    //�������ע��
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException {
        Class<?> c1 = Class.forName("supplementary.reflect.Student2");

        //ͨ��������ע��
        Annotation[] annotations = c1.getAnnotations();
        for (Annotation a : annotations)
        {
            System.out.println(a);
        }


        //���ע���value��ֵ
        Tablekuang tablekuang = c1.getAnnotation(Tablekuang.class);
        String value = tablekuang.value();
        System.out.println(value);

        //�����ָ����ע��
        Field f = c1.getDeclaredField("name");
        Fieldkuang annotation = f.getAnnotation(Fieldkuang.class);
        System.out.println(annotation.columnName());
        System.out.println(annotation.type());
        System.out.println(annotation.length());

    }

}

@Tablekuang("db_student")
class Student2{

    @Fieldkuang(columnName = "db_id", type = "int",length = 10)
    private int id;

    @Fieldkuang(columnName = "db_age", type = "int",length = 10)
    private int age;

    @Fieldkuang(columnName = "db_name", type = "varchar",length = 3)
    private String name;

    public Student2(int id, int age, String name) {
        this.id = id;
        this.age = age;
        this.name = name;
    }

    public Student2() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "student2{" +
                "id=" + id +
                ", age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}

//������ע��
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface Tablekuang{
    String value();
}

//���Ե�ע��
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Fieldkuang{
    String columnName();
    String type();
    int length();
}
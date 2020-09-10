package Day21;

import java.io.Serializable;

public class Person implements Serializable {
    static final long serialVersionUID = 42L;
    private String name;
    private int age;
    static String country = "cn";//静态不能被序列化
    transient int d3;//加transient也不可以被序列化
    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString()
    {
        return name+":"+age+":"+country;
    }
}

package Day14;
/*
将自定义对象作为元素存到ArrayList中，并去除重复元素。

比如：存人对象，同姓名同年龄，视为同一个人，为重复元素。


思路：
1. 对人描述，将数据封装进人对象
2. 定义容器，将人存入
3. 取出。



List集合判断元素是否相同，依据的是元素的equals方法

 */

import java.util.ArrayList;
import java.util.Iterator;

class Person
{
    private String name;
    private int age;
    Person(String name,int age)
    {
        this.age = age;
        this.name = name;
    }
    /**/
    public boolean equals(Object obj)
    {

        if(!(obj instanceof Person))
        {
            return false;
        }
        Person p = (Person)obj;
        System.out.println(this.name+"..."+p.name);
        return this.name.equals(p.name) && this.age == p.age;
    }


    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }


}

public class ArrayListTest2 {
    public static void main(String[] args) {
        ArrayList al = new ArrayList();
        al.add(new Person("lisi01",30));//a1.add(Object);//Object obj = new Person("")
        //al.add(new Person("lisi02",32));
        al.add(new Person("lisi02",32));
        al.add(new Person("lisi03",33));
        al.add(new Person("lisi04",35));
        //al.add(new Person("lisi04",35));

        //al = singleElement(al);

        System.out.println("remove03:"+al.remove(new Person("lisi03",33)));

        Iterator it = al.iterator();

        while(it.hasNext())
        {
            //Object obj = it.next();
            Person p = (Person)it.next();
            System.out.println(p.getName()+"::"+p.getAge());
        }
    }

    public static ArrayList singleElement(ArrayList al)
    {
        //定义一个临时容器。
        ArrayList newAl = new ArrayList();

        Iterator it = al.iterator();

        while(it.hasNext())
        {
            Object obj = it.next();
            if(!newAl.contains(obj))
            {
                newAl.add(obj);
            }
        }

        return newAl;

    }
}

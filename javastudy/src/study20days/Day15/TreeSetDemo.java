package Day15;

import java.util.Iterator;
import java.util.TreeSet;

/*
Set：无序，不可以重复元素
    |--HashSet：数据结构是哈希表，线程是非同步的。
                保证元素唯一性的原理，判断元素的hashCode值是否相同。
                如果相同，还会继续判断元素的equals方法，是否为true

    |--TreeSet：可以对set集合中的元素进行排序。
                底层数据结构是二叉树。
                保证元素唯一性的依据：
                compareTo方法return 0；

                TreeSet排序的第一种方式：让元素自身具备比较性。
                元素需要实现Comparable接口，覆盖compareTo方法，
                这种方式也称为元素的自然顺序，或者叫做默认顺序。

                TreeSet集合第二种排序方式。
                当元素自身不具备比较性时，或者具备的比较性不是所需要的。
                这时就需要让集合自身具备比较性。
                在集合初始化时，就有了比较方式


需求：
往TreeSet集合中存储自定义对象学生。
想按照学生的年龄进行排序。


记住：排序时，当主要条件相同时，一定要判断次要条件。

 */
public class TreeSetDemo {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet();
        /*
        ts.add("cba");
        ts.add("abcd");
        ts.add("AAbcd");
        ts.add("aaa");
        ts.add("bca");

         */
        ts.add(new Student("lisi02",22));
        ts.add(new Student("lisi007",20));
        ts.add(new Student("lisi09",19));
        ts.add(new Student("lisi08",19));
        ts.add(new Student("lisi00",40));
        ts.add(new Student("lisi00",40));


        Iterator it = ts.iterator();

        while(it.hasNext())
        {
            Student stu = (Student) it.next();
            System.out.println(stu.getName()+"...."+stu.getAge());
        }
    }
}


class Student implements Comparable
{
    private String name;
    private int age;
    Student(String name,int age)
    {
        this.age = age;
        this.name = name;
    }

    @Override
    public int compareTo(Object o) {
        //不做判断直接return 1即可完成存取顺序一致
        if(!(o instanceof Student))
            throw new RuntimeException("不是学生对象");

        Student s = (Student)o;

        //System.out.println(this.name+":"+this.age+"....compareto...."+s.name+":"+s.age);

        if(this.age>s.age)
            return 1;
        if(this.age == s.age)
            return this.name.compareTo(s.name);
        return -1;
    }

    public String getName()
    {
        return  name;
    }

    public int getAge() {
        return age;
    }
}

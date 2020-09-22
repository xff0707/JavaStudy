package javastudy25days.Day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/*
当元素自身不具备比较性时，或者具备的比较性不是所需要的
这时就需要让集合自身具备比较性。
定义了比较器，将比较对象作为参数传递给TreeSet集合的构造函数

当两种排序都存在时，以比较器为主。

定义一个类，实现Comparator接口，覆盖compare方法
 */
public class TreeSetDemo2 {
    public static void main(String[] args) {
        TreeSet ts = new TreeSet(new MyCompare());
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
        ts.add(new Student("lisi08",18));
        //ts.add(new Student("lisi00",40));
        //ts.add(new Student("lisi00",40));


        Iterator it = ts.iterator();

        while(it.hasNext())
        {
            Student stu = (Student) it.next();
            System.out.println(stu.getName()+"...."+stu.getAge());
        }
    }
}


class MyCompare implements Comparator
{
    @Override
    public int compare(Object o1, Object o2) {
        Student s1 = (Student)o1;
        Student s2 = (Student)o2;
        int num = s1.getName().compareTo(s2.getName());
        if(num==0) {

            return new Integer(s1.getAge()).compareTo(new Integer(s2.getAge()));
            /*
            if(s1.getAge()>s2.getAge())
                return 1;
            if(s1.getAge()==s2.getAge())
                return 0;
            return -1;

             */
        }
        return num;
    }
}



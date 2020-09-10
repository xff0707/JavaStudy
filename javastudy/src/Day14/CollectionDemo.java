package Day14;
/*
1. add方法的参数类型是Object，以便于接收任意类型对象。

2. 集合中存放的是对象的引用(地址)

什么是迭代器呢？
其实就是集合的取出元素的方式。



 */

import java.util.ArrayList;
import java.util.Iterator;

public class CollectionDemo {
    public static void main(String[] args) {
        base_method();
        //method_2();
        //method_get();
    }

    public static void method_get()
    {
        ArrayList al = new ArrayList();

        al.add("Java01");
        al.add("Java02");
        al.add("Java03");
        al.add("Java04");
        /*
        Iterator it = al.iterator();//获取迭代器，用于取出集合中的元素。

        while (it.hasNext()) {
            System.out.println(it.next());
        }

        */
        //al.add(new Integer("100"));//可以添加不同类型的数据，不同对象或者基本数据类型都可以
        al.add(1.0d);

        for(Iterator it = al.iterator(); it.hasNext();)
        {
            System.out.println(it.next());
        }

    }

    public static void method_2()
    {
        ArrayList al1 = new ArrayList();

        al1.add("Java01");
        al1.add("Java02");
        al1.add("Java03");
        al1.add("Java04");

        ArrayList al2 = new ArrayList();

        al2.add("Java01");
        al2.add("Java02");
        al2.add("Java05");
        al2.add("Java06");

        ArrayList al3 = new ArrayList();

        al3.add("Java03");
        al3.add("Java04");
        al3.add("Java05");
        al3.add("Java06");

        System.out.println("al1:"+al1);

        al1.retainAll(al2);//取交集，al1只会保留与al2相同的元素
        //al1.removeAll(al3);//移除交集
        //al1.addAll(al2);//al2全体元素加入al1

        System.out.println("al1:"+al1);
        System.out.println("al2:"+al2);
        System.out.println("al3:"+al3);

        /*
        ArrayList al4 = new ArrayList();
        al4.add("Java01");
        al4.add("Java02");
        al4.add("Java03");
        al4.add("Java04");
        al4.add("Java05");
        System.out.println(al4.containsAll(al1));

         */

    }

    public static void base_method()
    {
        //创建一个集合容器，使用collection接口的子类，ArrayList
        ArrayList al = new ArrayList();

        //1. 添加元素
        al.add("Java01");//add(Object obj);
        al.add("Java02");
        al.add("Java03");
        al.add("Java04");

        //打印原集合。
        System.out.println("原来:"+al);

        //3. 删除元素
        //al.remove("Java02");
        //al.clear();//清空集合

        //4. 判断元素。
        System.out.println("java03是否存在？"+al.contains("Java03"));
        System.out.println("集合是否为空？"+al.isEmpty());

        //2. 获取个数，集合长度
        System.out.println("Size="+al.size());

        //打印改变后的集合
        System.out.println(al);

        //System.out.println();
    }
}

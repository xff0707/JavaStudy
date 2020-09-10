package Day14;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/*
Collection
    |--List：元素是有序的，元素可以重复，因为该集合体系有索引
        |--ArrayList：底层的数据结构使用的是数组结构。特点：查询速度很快，但是增删很慢。线程不同步
        |--LinkedList：底层使用的是链表数据结构。特点：增删的速度很快，查询很慢。
        |--Vector：底层使数组数据结构。线程同步

        ArrayList：默认长度10，50%延长
        Vector：默认长度10，100%延长
    |--set：元素是无序，元素不可以重复

List：
    特有方法：凡是可以操作角标的方法都是体系特有的方法。

增
    add(index,element);
    addAll(index,Collection);


删
    remove(index);

改
    set(index,element);

查
    get(index);
    subList(from,to);
    listIterator();



List特有的迭代器。ListIterator是Iterator的子接口。

在迭代时，不可以通过集合对象的方法操作集合中的元素。
因为会发生ConcurrentModificationException异常

所以，在迭代时，只能用迭代器的方法操作元素，可是Iterator方法是有限的，
只能对元素进行判断，取出，删除的操作。
如果想要其他的操作，如添加、修改等，就需要使用其子接口，ListIterator，

该接口只能通过List集合的ListIterator方法获取。


 */
public class ListDemo {
    public static void main(String[] args) {

        //演示列表迭代器。
        ArrayList al = new ArrayList();

        //1. 添加元素
        al.add("Java01");
        al.add("Java02");
        al.add("Java03");

        System.out.println(al);

        ListIterator li = al.listIterator();



        while(li.hasNext())
        {
            Object obj = li.next();

            if(obj.equals("Java02"))
                //li.add("Java009");
                li.set("Java006");

        }

        while(li.hasPrevious())
        {
            System.out.println("previous"+li.previous());
        }


        System.out.println("hasNext():"+li.hasNext());
        System.out.println("hasPrevious():"+li.hasPrevious());

        System.out.println(al);


        /*
        //在迭代过程中准备添加或者删除元素
        Iterator it = al.iterator();//这时候迭代器只知道有3个元素，不允许并发修改，不可以增加，可以删除。

        while(it.hasNext())
        {
            Object obj = it.next();

            if(obj.equals("Java02"))
            {
                //al.add("Java008");//并发访问引发并发修改异常
                it.remove();//将Java02的引用从集合中删除了。
            }

            System.out.println("Obj="+obj);
        }

        System.out.println(al);

         */

    }

    public static void method()
    {
        ArrayList al = new ArrayList();

        //1. 添加元素
        al.add("Java01");
        al.add("Java02");
        al.add("Java03");
        al.add("Java04");

        System.out.println("原集合是："+al);
        //在指定位置添加元素
        al.add(1,"Java09");

        //删除指定位置的元素
        //al.remove(2);

        //修改元素
        //al.set(2,"Java07");

        //通过角标获取元素
        System.out.println("get(1):"+al.get(1));

        System.out.println(al);

        //获取所有元素
        for (int x=0;x<al.size();x++)
        {
            System.out.println("al("+x+")="+al.get(x));
        }

        Iterator it = al.iterator();

        while(it.hasNext())
        {
            System.out.println("next="+it.next());
        }


        //通过Index获取对象的位置
        System.out.println("index="+al.indexOf("Java02"));

        List sub = al.subList(1,3);
        System.out.println("sub="+sub);
    }

}

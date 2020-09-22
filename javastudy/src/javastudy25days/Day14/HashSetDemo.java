package javastudy25days.Day14;

import java.util.HashSet;
import java.util.Iterator;

/*
|--Set：元素是无序（存入和取出的顺序不一定一致），元素不可以重复。
    |--HashSet：底层数据结构是哈希表
            HashSet是如何保证元素唯一性的呢？
            是通过元素的两个方法，hasCode和equals来完成。
            如果元素的HashCode值相同，才会判断equals是否为true。
            如果元素的HashCode值不同，不会调用equals。

            注意：对于判断元素是否存在，以及删除等操作，依赖的方法是元素的hashcode和equals方法。

    |--TreeSet：
Set集合的功能和Collection是一致的


 */
public class HashSetDemo {
    public static void main(String[] args) {
        HashSet hs = new HashSet();

        System.out.println(hs.add("java01"));
        System.out.println(hs.add("java01"));
        hs.add("java02");
        hs.add("java03");
        hs.add("java03");
        hs.add("java03");
        hs.add("java04");

        Iterator it = hs.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }


        /*
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        System.out.println(d1);
        System.out.println(d2);

         */
    }
}
/*
class Demo
{
    public int hashCode()
    {
        return 60;
    }
}

 */
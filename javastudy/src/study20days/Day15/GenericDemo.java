package Day15;
/*
泛型：JDK1.5之后出现的新特性，用于解决安全问题，是一个类型安全机制。

好处
1. 将运行时期出现的问题ClassCastException，转移到了编译时期。
    方便于程序员解决问题，让运行时期问题减少

2. 避免了强制转换的麻烦。


泛型格式：通过<>来定义要操作的引用数据引用类型。

在使用java提供的对象时，什么时候写泛型呢？

通常在集合框架中很常见。
只要见到<>就要定义泛型。

其实<>就是用来接收类型的。

当使用集合时，将集合中要存储的数据类型作为参数传递到<>中即可

 */

import java.util.ArrayList;
import java.util.Iterator;

public class GenericDemo {
    public static void main(String[] args) {
        int[] arr = new int[3];
        arr[0] = 4;
        arr[1] = (int) 3.5;


        ArrayList<String> al = new ArrayList<String>();

        al.add("abc01");
        al.add("abc0992");
        al.add("abc014");

        //al.add(4);

        Iterator<String> it = al.iterator();
        while(it.hasNext())
        {
            String s = it.next();
            System.out.println(s+":"+s.length());
        }

    }
}

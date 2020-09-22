package javastudy25days.Day14;

import java.util.LinkedList;

/*
使用LinkList模拟一个堆栈或者队列数据结构。

 堆栈：先进后出 如同一个杯子
 队列：先进先出 First in First out 如同一个水管

 */
public class LinkedListTest {
    public static void main(String[] args) {
        Duilie dl = new Duilie();
        dl.myAdd("java01");
        dl.myAdd("java02");
        dl.myAdd("java03");
        dl.myAdd("java04");
        while(!dl.isNull())
            System.out.println(dl.myGet());
    }

}

class Duilie
{
    private LinkedList link;

    Duilie()
    {
        link = new LinkedList();
    }

    public void myAdd(Object obj)
    {
        link.addFirst(obj);
    }

    public Object myGet()
    {
        //return link.removeLast();//队列
        return link.removeFirst();//栈
    }

    public boolean isNull()
    {
        return link.isEmpty();
    }

}


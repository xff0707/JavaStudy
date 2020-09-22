package javastudy25days.Day17;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/*
高级for循环

格式：
for (数据类型 变量名 : 被遍历的集合(Collection)或者数组)
{

}

对集合进行遍历。
只能获取元素，但是不能对集合进行操作。

迭代器，除了遍历，还可以进行remove集合中元素的动作。
如果使用ListIterator，还可以在遍历过程中进行增删改查的动作。

传统for和高级for有什么区别呢？

高级for有一个局限性，必须有被遍历的目标。

建议在遍历数组的时候，还是希望使用传统for，因为传统for可以定义角标

 */
public class ForEachDemo {
    public static void main(String[] args) {
        ArrayList<String> al = new ArrayList<String>();
        al.add("abc1");
        al.add("abc2");
        al.add("abc3");
        al.add("abc4");

        for(String s:al)
        {
            s = "kk";
            System.out.println(s);
        }
        System.out.println(al);

        /*
        Iterator it = al.iterator();

        while (it.hasNext())
        {
            System.out.println(it.next());
        }
         */

        int[] arr = {3,5,7};
        for(int i :arr)
        {
            System.out.println("i:"+i);
        }

        HashMap<Integer,String> hm = new HashMap<Integer, String>();

        hm.put(1,"a");
        hm.put(2,"b");
        hm.put(3,"c");
        hm.put(4,"d");
        hm.put(5,"e");

        Set<Integer> keyset = hm.keySet();

        for (Integer i:keyset)
        {
            System.out.println(i+"::"+hm.get(i));
        }

        //Set<Map.Entry<Integer,String>> entrySet = hm.entrySet();
        //for (Map.Entry<Integer,String> me :entrySet)

        for(Map.Entry<Integer,String> me : hm.entrySet())
        {
            System.out.println(me.getKey()+"-----"+me.getValue());
        }

        /*
        for(int a = 0;a<100;a++)
        {
            System.out.println(Math.cos(2*a*Math.PI));
        }
        */

    }
}

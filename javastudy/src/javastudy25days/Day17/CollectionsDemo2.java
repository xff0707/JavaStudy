package javastudy25days.Day17;

import java.util.*;

public class CollectionsDemo2 {
    public static void main(String[] args) {
        //fillDemo();
        //replaceDemo();
        //orderDemo();
        shuffleDemo();
    }

    public static void shuffleDemo()
    {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("z");
        list.add("z");
        list.add("kkkkk");
        list.add("qq");

        System.out.println(list);

        Collections.shuffle(list);

        System.out.println(list);

    }


    public static void orderDemo()
    {
        //TreeSet<String> ts = new TreeSet<String>(new StrComparator());
        //TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder());
        TreeSet<String> ts = new TreeSet<String>(Collections.reverseOrder(new StrlenComparator()));

        ts.add("abcde");
        ts.add("aaa");
        ts.add("k");
        ts.add("cc");

        Iterator it = ts.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }

    }

    public static void replaceDemo()
    {
        List<String> list = new ArrayList<String>();

        list.add("asdasd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");

        System.out.println(list);

        Collections.replaceAll(list,"aaa","pp");
        System.out.println(list);

        Collections.reverse(list);
        System.out.println(list);
    }

    /*
    练习。fill方法可以将list集合中的所有元素替换成指定元素。
    将集合中部分元素替换成指定元素。
    fillDemo(list,start,end)
     */
    public static void fillDemo()
    {
        List<String> list = new ArrayList<String>();

        list.add("asdasd");
        list.add("aaa");
        list.add("zz");
        list.add("kkkkk");


        System.out.println(list);
        Collections.fill(list,"pp");
        System.out.println(list);
    }

}

class StrComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        /*
        int num = o1.compareTo(o2);
        if (num>0)
            return -1;
        else if (num<0)
            return 1;
        return num;
        */
        return o2.compareTo(o1);
    }
}

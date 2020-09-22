package javastudy25days.Day17;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
集合框架的工具类。
Collections

 */
public class CollectionsDemo {
    public static void main(String[] args) {
        //sortDemo();
        //MaxDemo();
        binarySearchDemo();
    }

    public static void binarySearchDemo()
    {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("z");
        list.add("kkkkk");
        list.add("qq");

        Collections.sort(list);
        System.out.println(list);

        //int index = Collections.binarySearch(list,"aaaa");
        int index = halfSearch(list,"cc");

        System.out.println("index="+index);

    }

    public static int halfSearch(List<String> list,String key)
    {
        int max,min,mid;
        max = list.size()-1;
        min = 0;

        while(min<=max)
        {
            mid = (max+min)>>1;//   /2

            String str = list.get(mid);

            int num = str.compareTo(key);

            if (num>0)
            {
                max = mid - 1;
            }
            else if (num<0)
            {
                min = mid + 1;
            }
            else
                return mid;
        }
        return -min-1;
    }

    public static int halfSearch2(List<String> list,String key,Comparator<String> cmp)
    {
        int max,min,mid;
        max = list.size()-1;
        min = 0;

        while(min<=max)
        {
            mid = (max+min)>>1;//   /2

            String str = list.get(mid);

            int num = cmp.compare(str,key);

            if (num>0)
            {
                max = mid - 1;
            }
            else if (num<0)
            {
                min = mid + 1;
            }
            else
                return mid;
        }
        return -min-1;
    }

    public static void MaxDemo() {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("zz");
        list.add("z");
        list.add("kkkkk");
        list.add("qq");

        Collections.sort(list/*,new StrlenComparator()*/);
        System.out.println(list);

        String max = Collections.max(list);
        System.out.println("max="+max);

    }

    public static void sortDemo()
    {
        List<String> list = new ArrayList<String>();

        list.add("abcd");
        list.add("aaa");
        list.add("z");
        list.add("z");
        list.add("kkkkk");
        list.add("qq");

        System.out.println(list);

        //Collections.sort(list);
        Collections.sort(list,new StrlenComparator());
        //Collections.swap(list,1,2);置换

        System.out.println(list);
    }
}


class StrlenComparator implements Comparator<String>
{
    @Override
    public int compare(String o1, String o2) {
        if (o1.length()>o2.length())
            return 1;
        if (o1.length()<o2.length())
            return -1;
        return o1.compareTo(o2);
    }
}

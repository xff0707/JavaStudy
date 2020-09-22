package javastudy25days.Day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo2 {
    public static void main(String[] args) {
        TreeSet<String> ts = new TreeSet<String>(new StrLenComparator2());

        ts.add("asa");
        ts.add("sdfaa");
        ts.add("dfga");
        ts.add("fghaaa");

        Iterator<String> it = ts.iterator();

        while(it.hasNext())
        {
            String s = it.next();
            System.out.println(s);
        }

    }
}


class StrLenComparator2 implements Comparator<String>
{

    @Override
    public int compare(String o1, String o2) {
        int num = new Integer(o1.length()).compareTo(new Integer(o2.length()));//换顺序将元素o1、o2换位置即可
        if(num==0)
            return o1.compareTo(o2);

        return num;
    }
}

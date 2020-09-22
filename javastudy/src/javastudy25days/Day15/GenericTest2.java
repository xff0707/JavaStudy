package javastudy25days.Day15;

import java.util.Iterator;
import java.util.TreeSet;

public class GenericTest2 {
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


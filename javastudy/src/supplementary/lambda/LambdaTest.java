package supplementary.lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class LambdaTest {
    public static void main(String[] args) {
        test1();
    }
    public static void test1()
    {
        List<String> list = new ArrayList<>();
        list.add("ss");
        list.add("ddd");
        list.add("fffff");
        list.add("vvvvvv");
        list.add("a");
        Collections.sort(list,(o1,o2)->Integer.compare(o1.length(),o2.length()));
        list.forEach(System.out::println);
    }
}

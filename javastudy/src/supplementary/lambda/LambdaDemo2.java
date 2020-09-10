package supplementary.lambda;

import java.util.Comparator;
import java.util.function.Consumer;

public class LambdaDemo2 {
    public static void main(String[] args) {
        //demo();
        //demo2();
        //demo3();
        demo4();
    }
    public static void demo()
    {
        Runnable r1 = ()->{
            System.out.println("hello λ");
        };
        r1.run();
    }
    static void demo2()
    {
        Consumer<String> con = (x)-> System.out.println(x);
        con.accept("山水有相逢");
    }
    static void demo3()
    {
        Comparator<Integer> com = (x,y)->{
            return x.compareTo(y);
        };
    }

    static void demo4()
    {
        Integer i = operation(100,(x)->x*x);
        System.out.println(i);
    }

    static Integer operation(Integer num,MyFun mf)
    {
        return mf.getValue(num);
    }
}

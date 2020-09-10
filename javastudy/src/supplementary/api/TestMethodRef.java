package supplementary.api;


import supplementary.lambda.Employee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
方法引用：若Lambda体中的内容有方法已经实现了，我们可以使用“方法引用”（可以理解为lambda表达式的另外一种表现形式）
主要有三种语法格式：

对象::实例方法名

类::静态方法名

类::实例方法名

注意
    lambda体中调用方法的参数列表与返回值类型，要与函数式接口中抽象方法的函数列表和返回值类型保持一致
    若lambda参数列表中的第一参数是 实例方法的调用者，而第二个参数是实例方法的参数时，可以使用ClassName::method


构造器引用：
    格式： ClassName::new
    注意：需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致


数组引用


 */
public class TestMethodRef {
    public static void main(String[] args) {
        test1();
        test2();
        test3();
        test4();
        test5();
        test6();
        test7();

    }
    static void test7()
    {
        //数组引用

        Function<Integer,String[]> fun = (x)->new String[x];
        String[] s = fun.apply(10);
        System.out.println(s.length);

        Function<Integer,String[]> fun2 = String[]::new;
        String[] s1 = fun2.apply(20);
        System.out.println(s1.length);
    }
    static void test6()
    {
        Function<Integer,Employee> fun = (x) -> new Employee(x);


        Function<Integer,Employee> fun2 = Employee::new;
        System.out.println(fun2.apply(10));

    }


    static void test5()
    {
        Supplier<Employee> sup = () -> new Employee();

        //构造器引用方式
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }
    static void test4()
    {
        //类::实例方法名
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        System.out.println(bp.test("10","10"));
                                        //(1,2)->参数1.方法(参数2)
                                        //        ↓
                                        //类名::实例方法名
        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("20","30"));


    }

    static void test3()
    {
        //类::静态方法名

        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        System.out.println(com.compare(1,3));



        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com.compare(2,1));

    }

    static void test2()
    {
        //对象::实例方法名
        //Supplier<String> sup = ()->Long.toString(System.currentTimeMillis());
        Long l = System.currentTimeMillis();
        Supplier<String> sup = ()-> l.toString();
        System.out.println(sup.get());

        Supplier<String> sup2 = l::toString;
        System.out.println(sup2.get());

    }

    static void test1()
    {
        //对象::实例方法名
        //输入一个参数，无返回值
        Consumer<String> con = (x)-> System.out.println(x);
        //con.accept("我爱你");

        PrintStream ps = System.out;
        Consumer<String> con1 = ps::println;

        Consumer<String> con2 = System.out::println;

    }

    static void show()
    {

        byte b = -2;
        System.out.println(b);
        int c = b;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        int d = c&0xff;
        System.out.println(d);

    }
}

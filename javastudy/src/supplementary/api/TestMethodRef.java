package supplementary.api;


import supplementary.lambda.Employee;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/*
�������ã���Lambda���е������з����Ѿ�ʵ���ˣ����ǿ���ʹ�á��������á����������Ϊlambda���ʽ������һ�ֱ�����ʽ��
��Ҫ�������﷨��ʽ��

����::ʵ��������

��::��̬������

��::ʵ��������

ע��
    lambda���е��÷����Ĳ����б��뷵��ֵ���ͣ�Ҫ�뺯��ʽ�ӿ��г��󷽷��ĺ����б�ͷ���ֵ���ͱ���һ��
    ��lambda�����б��еĵ�һ������ ʵ�������ĵ����ߣ����ڶ���������ʵ�������Ĳ���ʱ������ʹ��ClassName::method


���������ã�
    ��ʽ�� ClassName::new
    ע�⣺��Ҫ���õĹ������Ĳ����б�Ҫ�뺯��ʽ�ӿ��г��󷽷��Ĳ����б���һ��


��������


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
        //��������

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

        //���������÷�ʽ
        Supplier<Employee> sup2 = Employee::new;
        System.out.println(sup2.get());
    }
    static void test4()
    {
        //��::ʵ��������
        BiPredicate<String,String> bp = (x,y)->x.equals(y);
        System.out.println(bp.test("10","10"));
                                        //(1,2)->����1.����(����2)
                                        //        ��
                                        //����::ʵ��������
        BiPredicate<String,String> bp2 = String::equals;
        System.out.println(bp2.test("20","30"));


    }

    static void test3()
    {
        //��::��̬������

        Comparator<Integer> com = (x,y)-> Integer.compare(x,y);
        System.out.println(com.compare(1,3));



        Comparator<Integer> com2 = Integer::compare;
        System.out.println(com.compare(2,1));

    }

    static void test2()
    {
        //����::ʵ��������
        //Supplier<String> sup = ()->Long.toString(System.currentTimeMillis());
        Long l = System.currentTimeMillis();
        Supplier<String> sup = ()-> l.toString();
        System.out.println(sup.get());

        Supplier<String> sup2 = l::toString;
        System.out.println(sup2.get());

    }

    static void test1()
    {
        //����::ʵ��������
        //����һ���������޷���ֵ
        Consumer<String> con = (x)-> System.out.println(x);
        //con.accept("�Ұ���");

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

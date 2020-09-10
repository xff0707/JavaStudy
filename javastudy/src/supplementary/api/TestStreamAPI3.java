package supplementary.api;

import supplementary.lambda.Employee;

import java.util.*;
import java.util.stream.Collectors;

/*
终止操作
查找与匹配
allMatch--检查是否匹配所有元素
anyMatch--检查是否至少匹配一个元素
noneMatch--检查是否没有匹配所有元素
findFirst--返回第一个元素
findAny--返回当前流中的任意元素
count--返回流中元素的总个数
max--返回流中最大值
min--返回流中最小值


归约
reduce(T indentity, BinaryOperator) / reduce(BinaryOperator) --可以将流中元素反复结合起来，得到一个值。
        起始值    返回T               可能为空，返回Optional<T>
备注：map和reduce的连接通常成为map-reduce模式，因Google用它来进行网络搜索而出名。


收集
collect--将流转换为其他形式，接受一个Collector接口的实现，用于给stream中元素做汇总的方法


*/
public class TestStreamAPI3 {
    private static List<Employee> employees = Arrays.asList(
            new Employee(15,"小明",2700, Employee.Status.BUSY),
            new Employee(50,"何兰",5600, Employee.Status.FREE),
            new Employee(45,"紫婷",3000, Employee.Status.VOCATION),
            new Employee(23,"雪伦",2300, Employee.Status.VOCATION),
            new Employee(34,"沙发",4300, Employee.Status.FREE));
    public static void main(String[] args) {
        test1();
        System.out.println("--------------");
        test2();
        System.out.println("--------------");
        test3();
        System.out.println("--------------");
        test4();
        System.out.println("--------------");
        test5();
        System.out.println("--------------");
        test6();
        System.out.println("--------------");
        test7();
        System.out.println("--------------");
        test8();
        System.out.println("--------------");
        test9();
    }

    public static void test9()
    {
        //返回一个 Collector ，以遇到的顺序连接由指定的分隔符分隔的输入元素。
        String s = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }


    public static void test8()
    {
        //返回一个 Collector ， double生产映射函数应用于每个输入元素，并返回结果值的汇总统计信息。
        DoubleSummaryStatistics ds = employees.stream()
                .collect(Collectors.summarizingDouble(Employee::getMoney));
        System.out.println(ds);
        System.out.println(ds.getMax());
        System.out.println(ds.getMin());
        System.out.println(ds.getSum());
        System.out.println(ds.getAverage());
        System.out.println(ds.getCount());



    }


    public static void test7()
    {
        //分区
        Map<Boolean,List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e)->e.getMoney()>5000));
        System.out.println(map);
    }


    public static void test6()
    {
        //分组
        Map<Employee.Status,List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        //多级分组
        Map<Employee.Status,Map<String,List<Employee>>> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e)->
                {
                    if (e.getAge() < 20)
                        return "童工";
                    else if (e.getAge() <40)
                        return "中年";
                    else
                        return "老年";

                }
                )));
        System.out.println(map2);

    }


    public static void test5()
    {
        long sum = employees.stream()
                .collect(Collectors.counting());
        System.out.println("总个数："+sum);

        System.out.println("-------------------");

        double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getMoney));
        System.out.println("平均工资："+avg);

        System.out.println("-------------------");

        double sumMoney = employees.stream()
                .collect(Collectors.summingDouble(Employee::getMoney));
        System.out.println("总工资："+sumMoney);

        System.out.println("-------------------");

        Optional<Double> max = employees.stream()
                .map(Employee::getMoney)
                .collect(Collectors.maxBy((Double::compareTo)));
        System.out.println("最高工资："+max.get());


        System.out.println("-------------------");

        Optional<Double> min = employees.stream()
                .map(Employee::getMoney)
                .collect(Collectors.minBy((Double::compareTo)));
        System.out.println("最低工资："+min.get());
    }


    public static void test4()
    {
        List<String> list = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        list.forEach(System.out::println);

        System.out.println("----------------");

        Set<String> set = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toSet());
        set.forEach(System.out::println);


        System.out.println("----------------");

        HashSet<String> hs = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.toCollection(HashSet::new));
        hs.forEach(System.out::println);
    }




    public static void test3()
    {
        List<Integer> list = Arrays.asList(1,2,3,4,5,6,7,8,9,10);

        Integer sum = list.stream()
                .reduce(0, (x,y) -> x + y);
        //计算过程
        //1 + 2
        //3 + 3
        //6 + 4
        //  + 5
        //  + 6
        // ......
        //55
        System.out.println("sum="+sum);

        System.out.println("------------------");

        Optional<Double> op = employees.stream()
                .map(Employee::getMoney)
                .reduce(Double::sum);
        System.out.println(op.get());

    }


    public static void test2()
    {
        long count = employees.stream()
                .count();
        System.out.println(count);


        Optional<Employee> op1 = employees.stream()
                .max((e1,e2) -> Double.compare(e1.getMoney(),e2.getMoney()));
        System.out.println(op1.get());

        Optional<Double> op2 = employees.stream()
                .map(Employee::getMoney)
                .min(Double::compareTo);
        System.out.println(op2.get());

    }

    public static void test1()
    {
        boolean b1 = employees.stream()
                .allMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("是否全部忙碌："+b1);

        boolean b2 = employees.stream()
                .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("是否至少有一个忙碌："+b2);

        boolean b3 = employees.stream()
                .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("是否没有(人)忙碌："+b3);

        Optional<Employee> op = employees.stream()
                .sorted((x,y)->Double.compare(x.getMoney(),y.getMoney()))
                .findFirst();
        System.out.println("查找第一个(工资最低)"+op.get());

        Optional<Employee> op2 = employees.stream()//串行
                .filter((e)->e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        Optional<Employee> op3 = employees.parallelStream()//并行
                .filter((e)->e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println("串行寻找结果："+op2.get());
        System.out.println("并行寻找结果："+op3.get());

    }
}

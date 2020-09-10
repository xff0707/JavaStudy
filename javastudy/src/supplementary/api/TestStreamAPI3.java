package supplementary.api;

import supplementary.lambda.Employee;

import java.util.*;
import java.util.stream.Collectors;

/*
��ֹ����
������ƥ��
allMatch--����Ƿ�ƥ������Ԫ��
anyMatch--����Ƿ�����ƥ��һ��Ԫ��
noneMatch--����Ƿ�û��ƥ������Ԫ��
findFirst--���ص�һ��Ԫ��
findAny--���ص�ǰ���е�����Ԫ��
count--��������Ԫ�ص��ܸ���
max--�����������ֵ
min--����������Сֵ


��Լ
reduce(T indentity, BinaryOperator) / reduce(BinaryOperator) --���Խ�����Ԫ�ط�������������õ�һ��ֵ��
        ��ʼֵ    ����T               ����Ϊ�գ�����Optional<T>
��ע��map��reduce������ͨ����Ϊmap-reduceģʽ����Google��������������������������


�ռ�
collect--����ת��Ϊ������ʽ������һ��Collector�ӿڵ�ʵ�֣����ڸ�stream��Ԫ�������ܵķ���


*/
public class TestStreamAPI3 {
    private static List<Employee> employees = Arrays.asList(
            new Employee(15,"С��",2700, Employee.Status.BUSY),
            new Employee(50,"����",5600, Employee.Status.FREE),
            new Employee(45,"����",3000, Employee.Status.VOCATION),
            new Employee(23,"ѩ��",2300, Employee.Status.VOCATION),
            new Employee(34,"ɳ��",4300, Employee.Status.FREE));
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
        //����һ�� Collector ����������˳��������ָ���ķָ����ָ�������Ԫ�ء�
        String s = employees.stream()
                .map(Employee::getName)
                .collect(Collectors.joining(","));
        System.out.println(s);
    }


    public static void test8()
    {
        //����һ�� Collector �� double����ӳ�亯��Ӧ����ÿ������Ԫ�أ������ؽ��ֵ�Ļ���ͳ����Ϣ��
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
        //����
        Map<Boolean,List<Employee>> map = employees.stream()
                .collect(Collectors.partitioningBy((e)->e.getMoney()>5000));
        System.out.println(map);
    }


    public static void test6()
    {
        //����
        Map<Employee.Status,List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus));
        System.out.println(map);

        //�༶����
        Map<Employee.Status,Map<String,List<Employee>>> map2 = employees.stream()
                .collect(Collectors.groupingBy(Employee::getStatus,Collectors.groupingBy((e)->
                {
                    if (e.getAge() < 20)
                        return "ͯ��";
                    else if (e.getAge() <40)
                        return "����";
                    else
                        return "����";

                }
                )));
        System.out.println(map2);

    }


    public static void test5()
    {
        long sum = employees.stream()
                .collect(Collectors.counting());
        System.out.println("�ܸ�����"+sum);

        System.out.println("-------------------");

        double avg = employees.stream()
                .collect(Collectors.averagingDouble(Employee::getMoney));
        System.out.println("ƽ�����ʣ�"+avg);

        System.out.println("-------------------");

        double sumMoney = employees.stream()
                .collect(Collectors.summingDouble(Employee::getMoney));
        System.out.println("�ܹ��ʣ�"+sumMoney);

        System.out.println("-------------------");

        Optional<Double> max = employees.stream()
                .map(Employee::getMoney)
                .collect(Collectors.maxBy((Double::compareTo)));
        System.out.println("��߹��ʣ�"+max.get());


        System.out.println("-------------------");

        Optional<Double> min = employees.stream()
                .map(Employee::getMoney)
                .collect(Collectors.minBy((Double::compareTo)));
        System.out.println("��͹��ʣ�"+min.get());
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
        //�������
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
        System.out.println("�Ƿ�ȫ��æµ��"+b1);

        boolean b2 = employees.stream()
                .anyMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("�Ƿ�������һ��æµ��"+b2);

        boolean b3 = employees.stream()
                .noneMatch((e)->e.getStatus().equals(Employee.Status.BUSY));
        System.out.println("�Ƿ�û��(��)æµ��"+b3);

        Optional<Employee> op = employees.stream()
                .sorted((x,y)->Double.compare(x.getMoney(),y.getMoney()))
                .findFirst();
        System.out.println("���ҵ�һ��(�������)"+op.get());

        Optional<Employee> op2 = employees.stream()//����
                .filter((e)->e.getStatus().equals(Employee.Status.FREE))
                .findAny();

        Optional<Employee> op3 = employees.parallelStream()//����
                .filter((e)->e.getStatus().equals(Employee.Status.FREE))
                .findAny();
        System.out.println("����Ѱ�ҽ����"+op2.get());
        System.out.println("����Ѱ�ҽ����"+op3.get());

    }
}

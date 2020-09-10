package supplementary.api;


import supplementary.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
һ��Stream��������������

1. ����Stream

2. �м����

3. ��ֹ�������ն˲�����





*/
public class TestStreamAPI1 {
    public static void main(String[] args) {
        test1();
    }

    static void test1()
    {
        //����Stream
        //1ͨ��Collectionsϵ�м����ṩ��stream()������ �� parallelStream()������
        List<String> list = new ArrayList<>();
        Stream<String> stream1 = list.stream();

        //2.ͨ��Arrays�еľ�̬����stream��ȡ������
        Employee[] emp = new Employee[10];
        Stream<Employee> stream2= Arrays.stream(emp);

        //3.ͨ��Stream���еľ�̬���� of()
        Stream<String> stream3 = Stream.of("aa","bb","cc");

        //4.����������
        //����
        Stream<Integer> stream4 = Stream.iterate(0,(x)->x+2);
        //stream4.limit(10).forEach(System.out::println);
        //����
        Stream.generate(()->Math.random())
                .limit(10)
                .forEach(System.out::println);

    }
}

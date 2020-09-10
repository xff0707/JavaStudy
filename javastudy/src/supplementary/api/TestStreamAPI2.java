package supplementary.api;

import supplementary.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
�м����

ɸѡ����Ƭ
filter--����Lambda���������ų�ĳЩԪ��
limit--�ض�����ʹ��Ԫ�ز�������������
skip(n)--����Ԫ�أ�����һ���ӵ���ǰn��Ԫ�ص�����������Ԫ�ز���n�����򷵻�һ����������limit(n)����
distinct--ɸѡ��ͨ����������Ԫ�ص�hashCode()��equals()ȥ���ظ�Ԫ��

//ӳ��
map()����lambda����Ԫ��ת��������ʽ���ȡ��Ϣ������һ��������Ϊ�������ú����ᱻӦ�õ�ÿһ��Ԫ���ϣ�������ӳ���һ���ĵ�Ԫ��
flatmap()����һ��������Ϊ�����������е�ÿ��ֵ��������һ������Ȼ������������ӳ�һ����

//����
sorted()--��Ȼ����comparable
sorted(Comparator com)--��������comparator

 */
public class TestStreamAPI2 {
    private static List<Employee> employees = Arrays.asList(
            new Employee(15,"С��",2700),
            new Employee(50,"����",5600),
            new Employee(45,"����",3000),
            new Employee(23,"ѩ��",2300),
            new Employee(34,"ɳ��",4300));
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();
    }

    static void test3()
    {
        List<String> list = Arrays.asList("aaa","bb","ccc","jjj","ddd");
        list.stream().sorted()
                .forEach(System.out::println);

        list.stream().sorted((e1,e2)->{return Integer.compare(e1.length(),e2.length());})
                .forEach(System.out::println);
    }


    static void test2()
    {
        //map
        List<String> list = Arrays.asList("aaa","bbb","ccc");
        employees.stream()
                .map((e)->e.getAge())
                .forEach(System.out::println);

        Stream<Stream<Character>> c = list.stream().map(TestStreamAPI2::filterCharacter);
        c.forEach((sm)->{sm.forEach(System.out::println);});

        Stream<Character> s= list.stream().flatMap(TestStreamAPI2::filterCharacter);
        s.forEach(System.out::println);
    }
    public static Stream<Character> filterCharacter(String str)
    {
        List<Character> list = new ArrayList<>();

        for (Character c : str.toCharArray())
        {
            list.add(c);
        }
        return list.stream();
    }

    static void test1()
    {
        Stream s = employees.stream()
                .filter((e)->e.getAge()>35);
        s.forEach(System.out::println);

        employees.stream()
                .skip(3)
                .forEach(System.out::println);

        employees.stream()
                .limit(3)
                .forEach(System.out::println);

        Stream<String> stream3 = Stream.of("aa","bb","cc");
        stream3.map((str)->str.toUpperCase())
                .forEach(System.out::println);

        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}

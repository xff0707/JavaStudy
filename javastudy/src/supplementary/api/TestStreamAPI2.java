package supplementary.api;

import supplementary.lambda.Employee;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/*
中间操作

筛选与切片
filter--接受Lambda，从流中排除某些元素
limit--截断流，使其元素不超过给定数量
skip(n)--跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与limit(n)互补
distinct--筛选，通过流所生成元素的hashCode()和equals()去除重复元素

//映射
map()接受lambda，将元素转成其他形式或获取信息。接受一个函数作为参数，该函数会被应用到每一个元素上，并将其映射成一个心得元素
flatmap()接受一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流

//排序
sorted()--自然排序comparable
sorted(Comparator com)--定制排序comparator

 */
public class TestStreamAPI2 {
    private static List<Employee> employees = Arrays.asList(
            new Employee(15,"小明",2700),
            new Employee(50,"何兰",5600),
            new Employee(45,"紫婷",3000),
            new Employee(23,"雪伦",2300),
            new Employee(34,"沙发",4300));
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

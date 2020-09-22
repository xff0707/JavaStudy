package supplementary.lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaDemo {
    public static void main(String[] args) {
        //demo1();
        //demo2();
        demo3();
    }
    public static void demo1()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(15,"С��",2700));
        employees.add(new Employee(50,"����",5600));
        employees.add(new Employee(45,"����",3000));
        employees.add(new Employee(23,"ѩ��",2300));
        employees.add(new Employee(34,"ɳ��",4300));
        employees.forEach(System.out::println);
    }

    public static void demo2()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(15,"С��",2700));
        employees.add(new Employee(50,"����",5600));
        employees.add(new Employee(45,"����",3000));
        employees.add(new Employee(23,"ѩ��",2300));
        employees.add(new Employee(34,"ɳ��",4300));
        employees.stream()
                .filter((e)->e.getMoney()>2500)
                .limit(2)
                .forEach(System.out::println);
    }

    public static void demo3()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(15,"С��",2700));
        employees.add(new Employee(50,"����",5600));
        employees.add(new Employee(45,"����",3000));
        employees.add(new Employee(23,"ѩ��",2300));
        employees.add(new Employee(34,"ɳ��",4300));
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}
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
        employees.add(new Employee(15,"小明",2700));
        employees.add(new Employee(50,"何兰",5600));
        employees.add(new Employee(45,"紫婷",3000));
        employees.add(new Employee(23,"雪伦",2300));
        employees.add(new Employee(34,"沙发",4300));
        employees.forEach(System.out::println);
    }

    public static void demo2()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(15,"小明",2700));
        employees.add(new Employee(50,"何兰",5600));
        employees.add(new Employee(45,"紫婷",3000));
        employees.add(new Employee(23,"雪伦",2300));
        employees.add(new Employee(34,"沙发",4300));
        employees.stream()
                .filter((e)->e.getMoney()>2500)
                .limit(2)
                .forEach(System.out::println);
    }

    public static void demo3()
    {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(15,"小明",2700));
        employees.add(new Employee(50,"何兰",5600));
        employees.add(new Employee(45,"紫婷",3000));
        employees.add(new Employee(23,"雪伦",2300));
        employees.add(new Employee(34,"沙发",4300));
        employees.stream()
                .map(Employee::getName)
                .forEach(System.out::println);
    }
}

class Employee
{
    int age;
    String name;
    int money;

    public Employee() {
        super();
    }

    public Employee(int age, String name, int money) {
        this.age = age;
        this.name = name;
        this.money = money;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
}
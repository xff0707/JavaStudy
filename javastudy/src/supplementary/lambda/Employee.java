package supplementary.lambda;

public class Employee {
    int age;
    String name;
    double money;
    private Status status;

    public Employee(int age, String name, int money, Status status) {
        this.age = age;
        this.name = name;
        this.money = money;
        this.status = status;
    }

    public Employee() {
        super();
    }

    public Employee(int age) {
            this.age = age;
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

    public double getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", money=" + money +
                '}';
    }
    public enum Status{
        FREE,
        BUSY,
        VOCATION;
    }
}

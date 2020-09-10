package supplementary.fanshe;

public class Person {
    private int age;
    private String name;

    public Person(String name , int age) {
        this.age = age;
        this.name = name;
        System.out.println("Person agename run"+this.age+":::"+this.name);
    }

    Person(){
        super();
        System.out.println("Person run");
    }

    public void show()
    {
        System.out.println(name+"...show run..."+age);
    }

    private void privatemethod()
    {
        System.out.println("method run");
    }

    public void paramMethod(String str, int num)
    {
        System.out.println("paramMethod"+str+":"+num);
    }

    public static void staticMethod(String str, int num)
    {
        System.out.println("paramMethod"+str+":"+num);
    }

}

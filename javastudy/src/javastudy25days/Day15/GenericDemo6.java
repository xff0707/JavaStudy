package javastudy25days.Day15;
/*
？通配符。也可以理解为占位符。
泛型的限定：
？ extends E：可以获取E类型或者E的子类型。上限。
？ super E：可以接受E类型或者E的父类型。下限。

 */
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo6 {
    public static void main(String[] args) {
        /*
        ArrayList<String> al = new ArrayList<String>();

        al.add("abc1");
        al.add("abc2");
        al.add("abc3");

        ArrayList<Integer> al1 = new ArrayList<Integer>();

        al1.add(4);
        al1.add(7);
        al1.add(1);

        printColi(al);
        printColi(al1);

         */




        ArrayList<Person> al = new ArrayList<Person>();

        al.add(new Person("abc1"));
        al.add(new Person("abc2"));
        al.add(new Person("abc3"));
        printColi(al);



        ArrayList<Student6> al1 = new ArrayList<Student6>();

        al1.add(new Student6("abc``1"));
        al1.add(new Student6("abc``2"));
        al1.add(new Student6("abc``3"));
        printColi(al1);//ArrayList<Person> al = new ArrayList<Student>();error


        TreeSet<Student66> ts = new TreeSet<Student66>(new Comp());
        ts.add(new Student66("abc123"));
        ts.add(new Student66("abc456"));
        ts.add(new Student66("abc789"));
        /*
        Iterator it = ts.iterator();
        while(it.hasNext())
            System.out.println(it.next().toString());

         */


    }

    public static void printColi(ArrayList<? extends Person> al)//？ super student
    {
        Iterator<? extends Person> it = al.iterator();


        while(it.hasNext())
        {
            System.out.println(it.next().getName());
        }
    }



    /*
    //public static <T> void printColi(ArrayList<T> al)
    public static void printColi(ArrayList<?> al)//ArrayList al = new ArrayList<Integer>();error
    {
        //Iterator<T> it = al.iterator();
        Iterator<?> it = al.iterator();


        while(it.hasNext())
        {
            //T t = al.next();
            System.out.println(it.next().toString());
        }
    }

     */

}

class Person
{
    private String name;
    Person(String name)
    {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}


class Student6 extends Person
{

    Student6(String name) {
        super(name);
    }
}


class Student66 extends Person implements Comparable<Student66>//<? super E>
{
    Student66(String name) {
        super(name);
    }

    @Override
    public int compareTo(Student66 o) {
        return 0;
    }
}



class Comp implements Comparator<Student66>
{
    @Override
    public int compare(Student66 o1, Student66 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}














package Day15;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

public class GenericDemo7 {
    public static void main(String[] args) {
        /**/
        TreeSet<Student7> ts = new TreeSet<Student7>(new Comp77());

        ts.add(new Student7("abc03"));
        ts.add(new Student7("abc02"));
        ts.add(new Student7("abc06"));
        ts.add(new Student7("abc01"));

        Iterator<Student7> it = ts.iterator();

        while(it.hasNext())
            System.out.println(it.next().getName());



        //TreeSet<Worker7> ts1 = new TreeSet<Worker7>(new WorComp7());
        TreeSet<Worker7> ts1 = new TreeSet<Worker7>(new Comp77());

        ts1.add(new Worker7("wabc---03"));
        ts1.add(new Worker7("wabc---02"));
        ts1.add(new Worker7("wabc---06"));
        ts1.add(new Worker7("wabc---01"));




        Iterator<Worker7> it1 = ts1.iterator();

        while(it1.hasNext())
            System.out.println(it1.next().getName());

    }
}
/*
class StuComp7 implements Comparator<Student7>
{
    @Override
    public int compare(Student7 o1, Student7 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

class WorComp7 implements Comparator<Worker7>
{
    @Override
    public int compare(Worker7 o1, Worker7 o2) {
        return o1.getName().compareTo(o2.getName());
    }
}

 */

class Comp77 implements Comparator<Person7>
{

    @Override
    public int compare(Person7 o1, Person7 o2) {
        return o2.getName().compareTo(o1.getName());
    }
}


class Person7
{
    private String name;
    Person7(String name)
    {
        this.name = name;
    }

    public String getName()
    {
        return name;
    }

    public String toString()
    {
        return "person:"+name;
    }

}


class Student7 extends Person7
{

    Student7(String name) {
        super(name);
    }
}


class Worker7 extends Person7
{
    Worker7(String name)
    {
        super(name);
    }
}
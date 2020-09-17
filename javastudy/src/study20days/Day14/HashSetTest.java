package Day14;

import java.util.HashSet;
import java.util.Iterator;

public class HashSetTest {
    public static void main(String[] args) {
        HashSet hs = new HashSet();

        hs.add(new Person1("a1",11));
        hs.add(new Person1("a2",12));
        hs.add(new Person1("a3",13));
        //hs.add(new Person1("a2",12));
        //hs.add(new Person1("a4",14));
        //hs.add(new Person1("a5",11));

        //System.out.println(hs.contains(new Person1("a2",12)));

        System.out.println(hs.remove(new Person1("a4",13)));

        Iterator it = hs.iterator();

        while(it.hasNext())
        {
            Person1 p = (Person1)it.next();
            System.out.println(p.getName()+"::"+p.getAge());
        }

    }
}


class Person1
{
    private String name;
    private int age;
    Person1(String name,int age)
    {
        this.age = age;
        this.name = name;
    }

    public int hashCode()
    {
        System.out.println(this.name+"...hascode");
        return name.hashCode()+age*39;
    }
    /**/
    public boolean equals(Object obj)
    {

        if(!(obj instanceof Person1))
        {
            return false;
        }
        Person1 p = (Person1)obj;
        System.out.println(this.name+"...equals..."+p.name);
        return this.name.equals(p.name) && this.age == p.age;
    }


    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }


}
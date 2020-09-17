package Day16;

import java.util.*;

/*


 */
public class MapTest2 {
    public static void main(String[] args) {
        TreeMap<Student,String> tm = new TreeMap<Student,String>(new StuNameComparator());
        //TreeMap<Student,String> tm = new TreeMap<Student,String>(Collections.reverseOrder(new StuNameComparator()));

        tm.put(new Student("blisi3",24),"nanjing");
        tm.put(new Student("lisi1",21),"beijing");
        tm.put(new Student("lisi1",21),"tianjin");
        tm.put(new Student("alisi4",25),"wuhan");
        tm.put(new Student("lisi2",22),"shanghai");

        Set<Map.Entry<Student,String>> entrySet = tm.entrySet();

        Iterator<Map.Entry<Student,String>> it = entrySet.iterator();

        while(it.hasNext())
        {
            Map.Entry<Student,String> me  = it.next();

            Student stu = me.getKey();
            String addr = me.getValue();
            System.out.println(stu+":::"+addr);
        }



    }
}


class StuNameComparator implements Comparator<Student>
{

    @Override
    public int compare(Student o1, Student o2) {
        int num = o1.getName().compareTo(o2.getName());
        if(num==0)
            return new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
        return num;
    }
}
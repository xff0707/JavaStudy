package javastudy25days.Day21;
/*
有五个学生，每个学生有3门课得成绩，
从键盘输入以上数据（包括姓名，三门课成绩），
输入的格式为：如：张三， 30 ， 40， 60计算出总成绩，
并把学生的信息和计算出的总分数高低顺序存放在磁盘文件"stud.txt"中。

1. 描述学生对象。
2. 定义一个可以操作学生对象的工具类。

思想：
1. 通过获取键盘录入一行数据，并将该行中的信息取出封装成学生对象。
2. 因为学生有很多，那么就需要存储，使用到集合。因为要对学生的总分排序。
    所以可以使用TreeSet。
3. 将集合中的信息写入到一个文件中。

 */

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>
{
    private String name;
    private int ma,cn,en;
    private int sum;

    public Student(String name, int ma, int cn, int en) {
        this.name = name;
        this.ma = ma;
        this.cn = cn;
        this.en = en;
        sum = ma + cn + en;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", ma=" + ma +
                ", cn=" + cn +
                ", en=" + en +
                ", sum=" + sum +
                '}';
    }

    public String getName() {
        return name;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public int hashCode() {
        return name.hashCode()+sum*78;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Student))
            throw new ClassCastException("类型不匹配");
        Student s = (Student)o;

        return this.name.equals(s.name) && this.sum==s.sum;
    }

    @Override
    public int compareTo(Student o) {
        int num = new Integer(this.sum).compareTo(new Integer(o.sum));
        if (num==0)
            return this.name.compareTo(o.name);
        return num;
    }
}

class StudentInfoTool
{
    public static Set<Student> getStudents() throws IOException {
        return getStudents(null);
    }

    public static Set<Student> getStudents(Comparator<Student> cmp) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));

        String line = null;

        Set<Student> stus = null;
        if (cmp==null)
            stus = new TreeSet<Student>();
        else
            stus = new TreeSet<Student>(cmp);

        while ((line = bufr.readLine())!=null)
        {
            if ("over".equals(line))
                break;

            String[] info = line.split(",");

            Student stu = new Student(info[0],Integer.parseInt(info[1]),Integer.parseInt(info[2]),Integer.parseInt(info[3]));

            stus.add(stu);
        }
        bufr.close();
        return stus;
    }

    public static void write2File(Set<Student> stus) throws IOException {
        BufferedWriter bufw = new BufferedWriter(new FileWriter("myfile\\day21\\studentinfo.txt"));

        for (Student stu : stus)
        {
            //bufw.write(stu.getName()+'\t');
            //bufw.write(stu.getSum()+"");
            bufw.write(stu.toString());
            bufw.newLine();
            bufw.flush();
        }

        bufw.close();
    }
}

public class StudentInfoTest {
    public static void main(String[] args) throws IOException {

        Comparator<Student> cmp = Collections.reverseOrder();

        Set<Student> stus = StudentInfoTool.getStudents(cmp);

        StudentInfoTool.write2File(stus);

    }
    /*
    张三,50,30,90
    李四,60,90,40
    王五,60,99,50
    over
     */
}

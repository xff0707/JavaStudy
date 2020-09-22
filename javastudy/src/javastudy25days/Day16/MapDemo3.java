package javastudy25days.Day16;

import java.util.*;

/*
map扩展知识。

map集合被使用是因为具备映射关系。

预热班 01 张三---->预热班 Student(01 张三)

预热班 02 李四---->预热班 Student(02 李四)

就业班 01 王五---->就业班 Student(01 王五)

就业办 02 赵六---->就业班 Student(02 赵六)

-----


 */
public class MapDemo3 {
    public static void Demo()
    {
        HashMap<String, List<Student>> czbk = new HashMap<String, List<Student>>();

        List yure = new ArrayList<Student>();
        List jiuye = new ArrayList<Student>();

        yure.add(new Student("zhangsan",1));
        yure.add(new Student("lisi",4));
        jiuye.add(new Student("wangwu",1));
        jiuye.add(new Student("zhaoliu",2));

        czbk.put("yure",yure);
        czbk.put("jiuye",jiuye);



        Iterator<String> it = czbk.keySet().iterator();

        while(it.hasNext())
        {
            String roomName = it.next();
            List<Student> room = czbk.get(roomName);

            System.out.println(roomName);
            getInfo(room);
        }




    }

    public static void getInfo(List<Student> list)
    {
        Iterator<Student> it = list.iterator();

        while(it.hasNext())
        {
            Student s =  it.next();
            System.out.println(s.getAge()+":"+s.getName());
        }

    }



    public static void main(String[] args) {

        Demo();

        /*
        HashMap<String,String> yure = new HashMap<String,String>();

        yure.put("01","zhangsan");
        yure.put("02","lisi");

        HashMap<String,String> jiuye = new HashMap<String,String>();

        jiuye.put("01","wangwu");
        jiuye.put("02","zhaoliu");

        HashMap<String,HashMap<String,String>> czbk = new HashMap<String,HashMap<String,String>>();

        czbk.put("yure",yure);
        czbk.put("jiuye",jiuye);


        //遍历czbk集合。获取所有的教室
        Iterator<String> it = czbk.keySet().iterator();

        while(it.hasNext())
        {
            String roomName = it.next();
            HashMap<String,String> room = czbk.get(roomName);

            System.out.println(roomName);
            getStudentinfo(room);
        }

        //getStudentinfo(jiuye);
        //getStudentinfo(yure);

         */

    }

    public static void getStudentinfo(HashMap<String,String> roomMap)
    {
        Iterator<String> it = roomMap.keySet().iterator();

        while(it.hasNext())
        {
            String id = it.next();
            String name = roomMap.get(id);
            System.out.println(id+":"+name);
        }
    }
}




















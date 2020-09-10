package Day14;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class Coll {
    public static void main(String[] args) {
        for (int i=0;i<128;i++)
        {
            System.out.println("\t"+i+"="+(char)i);
        }
    }
    public static void main13(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream("吹雪.jpg");
        fis.close();
    }
    public static void main12(String[] args) {
        //File dir = new File("d:\\迅雷下载");
        //showDir(dir,0);
    }
    public static String getLevel(int level)
    {
        StringBuilder sb = new StringBuilder();
        sb.append("|--");
        for (int x=0;x<level;x++)
        {
            //sb.append(" ");
            //sb.append("|--");
            sb.insert(0,"|  ");
        }
        return sb.toString();
    }
    public static void showDir(File dir,int level)
    {
        System.out.println(getLevel(level)+dir.getName());

        level++;
        File[] files = dir.listFiles();
        for (int x = 0;x<files.length;x++)
        {
            //System.out.println(dir);
            if (files[x].isDirectory())
            {
                showDir(files[x],level);
            }
            else
                System.out.println(getLevel(level)+files[x]);
        }
    }

    public static void main11(String[] args) throws IOException {
        BufferedReader bufr = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader bufr = new BufferedReader(new InputStreamReader(new FileInputStream("demo.txt")));

        BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("d2.txt"),"UTF-8"));
        //BufferedWriter bufw = new BufferedWriter(new OutputStreamWriter(System.out));

        String line = null;

        while ((line = bufr.readLine())!=null)
        {
            if ("over".equals(line))
                break;
            bufw.write(line.toUpperCase());
            bufw.newLine();
            bufw.flush();
        }
        bufr.close();
    }

    public static void main10(String[] args) throws IOException {
        InputStream in = System.in;
        int by = in.read();
        int by1 = in.read();
        int by2 = in.read();

        System.out.println(by);
        System.out.println(by1);
        System.out.println(by2);
        System.out.println('\r'+0);
        System.out.println('\n'+0);
    }

    public static void main9(String[] args) throws IOException {
        FileReader fr = new FileReader("我的文本.txt");

        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        lnr.setLineNumber(100);
        while ((line=lnr.readLine())!=null)
        {
            System.out.println(lnr.getLineNumber()+":"+line);
        }

        lnr.close();
    }
    public static void main8(String[] args) throws IOException {
        System.out.println("I Love U\nI Miss U");

        //创建一个文件读取流对象，和指定名称的文件相关联
        //要保证该文件是已经存在的，如果不存在，会发生异常FileNotFoundException
        FileReader fr = new FileReader("我的文本.txt");

        //调用读取流对象的read方法
        //read方法一次读一个字符，会自动往下读
        int ch;

        while((ch= fr.read())!=-1)
        {
            System.out.println("ch="+(char)ch);
        }

    }
    public static void main7(String[] args) {

        Calendar c = Calendar.getInstance();
        System.out.println(c);


        //System.out.println(c.get(Calendar.YEAR)+"年");
        //System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日");

        System.out.println(c.get(Calendar.YEAR)+"年");

        //String[] mons = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};

        //int indexM = c.get(Calendar.MONTH);
        //System.out.println((c.get(Calendar.MONTH)+1)+"月");
        ///System.out.println(mons[indexM]);
        System.out.println((c.get(Calendar.MONTH)+1)+"月");

        System.out.println(c.get(Calendar.DAY_OF_MONTH)+"日");

        //String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        //int indexW = c.get(Calendar.DAY_OF_WEEK);
        //System.out.println("星期"+c.get(Calendar.DAY_OF_WEEK));
        //System.out.println(weeks[indexW]);
        //System.out.println(indexW);

        System.out.println("星期"+c.get(Calendar.DAY_OF_WEEK));
    }
    public static void main6(String[] args) {
        Date d = new Date();
        System.out.println(d);//打印的时间看不懂，希望有些格式。

        //将模式封装到SimpleDateformat对象中
        SimpleDateFormat sdf = new SimpleDateFormat("YYYY年MM月dd日E hh:mm:ss ---z");

        //调用format方法让模式格式化指定date对象。

        String time = sdf.format(d);

        System.out.println("time:"+time);



        long l = System.currentTimeMillis();

        Date d1 = new Date(l);

        System.out.println("dl:"+d1);
    }


    public static void main5(String[] args) throws IOException {
        Runtime r = Runtime.getRuntime();

        //Process p = r.exec("F:\\BaiduNetdiskDownload\\GrammarlyAddInSetup.exe");

        //r.exec("D:\\Game\\QSanguosha-v2-20181004\\QSanguosha.exe");
        /*
        try {
        }
        catch (IOException e)
        {
            System.out.println("有错！！！！！！！！！！");
        }
        */
        Process p = r.exec("F:\\t.txt");

        //Thread.sleep(4000);
        //p.destroy();
        //Thread.sleep(10000);
    }


    public static void main4(String[] args) {
        long start = System.currentTimeMillis();

        int starti = 0;
        int endi = 1000_0000;
        while (true)
        {
            starti++;
            if (starti>endi)
                break;
        }


        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }
    public static void main3(String[] args) {
        HashSet hs = new HashSet();

        System.out.println(hs.add("java01"));
        System.out.println(hs.add("java01"));
        hs.add("java02");
        hs.add("java03");
        hs.add("java03");
        hs.add("java03");
        hs.add("java04");

        Iterator it = hs.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next());
        }


        /*
        Demo d1 = new Demo();
        Demo d2 = new Demo();

        System.out.println(d1);
        System.out.println(d2);

         */
    }



    public static void main2(String[] args) {
        ArrayList al = new ArrayList();

        al.add("java01");
        al.add("java02");
        al.add("java01");
        al.add("java02");
        al.add("java01");
        al.add("java03");

        /*
        在迭代时循环中next调用一次，就要hasNext判断一次

        Iterator it = al.iterator();

        while(it.hasNext())
        {
            System.out.println(it.next()+"...."+it.next());
        }

         */


        /**/
        System.out.println(al);

        ArrayList newal = singleElement(al);

        System.out.println(newal);




    }

    public static ArrayList singleElement(ArrayList al)
    {
        //定义一个临时容器。
        ArrayList newAl = new ArrayList();

        Iterator it = al.iterator();

        while(it.hasNext())
        {
            Object obj = it.next();
            if(!newAl.contains(obj))
            {
                newAl.add(obj);
            }
        }

        return newAl;

    }
    public static void main1(String[] args) {



        //演示列表迭代器。
        ArrayList al = new ArrayList();

        //1. 添加元素
        al.add("Java01");
        al.add("Java02");
        al.add("Java03");

        System.out.println(al);

        ListIterator li = al.listIterator();



        while(li.hasNext())
        {
            Object obj = li.next();

            if(obj.equals("Java02"))
                //li.add("Java009");
                li.set("Java006");

        }

        while(li.hasPrevious())
        {
            System.out.println("previous"+li.previous());
        }


        System.out.println("hasNext():"+li.hasNext());
        System.out.println("hasPrevious():"+li.hasPrevious());

        System.out.println(al);

        /*
        ArrayList al = new ArrayList();

            //1. 添加元素
            al.add("Java01");
            al.add("Java02");
            al.add("Java03");
            al.add("Java04");

            System.out.println("原集合是："+al);
            //在指定位置添加元素
            al.add(1,"Java09");

            //删除指定位置的元素
            //al.remove(2);

            //修改元素
            //al.set(2,"Java07");

            //通过角标获取元素
            System.out.println("get(1):"+al.get(1));

            System.out.println(al);

            //获取所有元素
            for (int x=0;x<al.size();x++)
            {
                System.out.println("al("+x+")="+al.get(x));
            }

            Iterator it = al.iterator();

            while(it.hasNext())
            {
                System.out.println("next="+it.next());
            }


            //通过Index获取对象的位置
            System.out.println("index="+al.indexOf("Java02"));

            List sub = al.subList(1,3);
            System.out.println("sub="+sub);




        /*

        ArrayList al1 = new ArrayList();

        al1.add("Java01");
        al1.add("Java02");
        al1.add("Java03");
        al1.add("Java04");

        ArrayList al2 = new ArrayList();

        al2.add("Java01");
        al2.add("Java02");
        al2.add("Java05");
        al2.add("Java06");

        ArrayList al3 = new ArrayList();

        al3.add("Java03");
        al3.add("Java04");
        al3.add("Java05");
        al3.add("Java06");

        System.out.println("al1:"+al1);

        //al1.retainAll(al2);//取交集，al1只会保留与al2相同的元素
        //al1.removeAll(al3);//移除交集
        al1.addAll(al2);//al2全体元素加入al1

        System.out.println("al1:"+al1);
        System.out.println("al2:"+al2);
        System.out.println("al3:"+al3);

        ArrayList al4 = new ArrayList();
        al4.add("Java01");
        al4.add("Java02");
        al4.add("Java03");
        al4.add("Java04");
        al4.add("Java05");
        System.out.println(al4.containsAll(al1));

        /*
        //创建一个集合容器，使用collection接口的子类，ArrayList
        ArrayList al = new ArrayList();

        //1. 添加元素
        al.add("Java01");//add(Object obj);
        al.add("Java02");
        al.add("Java03");
        al.add("Java04");

        //打印原集合。
        System.out.println("原来:"+al);

        //3. 删除元素
        //al.remove("Java02");
        //al.clear();//清空集合

        //4. 判断元素。
        System.out.println("java03是否存在？"+al.contains("Java03"));
        System.out.println("集合是否为空？"+al.isEmpty());

        //2. 获取个数，集合长度
        System.out.println("Size="+al.size());

        //打印改变后的集合
        System.out.println(al);

        //System.out.println();

         */
    }
}

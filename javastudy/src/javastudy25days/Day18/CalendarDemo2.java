package javastudy25days.Day18;

import java.util.Calendar;
/*
两个练习：
1. 获取任意年的二月有多少天
    思路：根据指定年设置一个时间就是
    c.set(year,2,1)//某一年的三月一日
    c.add(Calender.DAY_OD_MONTH,-1);//3月1日往前推一天就是二月最后一天。

2. 获取昨天的现在的这个时刻。
    c.c.add(Calender.DAY_OD_MONTH,-1);

 */
public class CalendarDemo2 {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();

        //c.set(2012,2,23);

        printCalendar(c);

        c.add(Calendar.YEAR,4);
        c.add(Calendar.MONTH,-4);
        c.add(Calendar.DAY_OF_MONTH,18);

        printCalendar(c);
    }

    public static void printCalendar(Calendar c)
    {
        System.out.println(c.get(Calendar.YEAR)+"年");

        String[] mons = {"一月","二月","三月","四月","五月","六月","七月","八月","九月","十月","十一月","十二月"};

        int indexM = c.get(Calendar.MONTH);
        //System.out.println((c.get(Calendar.MONTH)+1)+"月");
        System.out.println(mons[indexM]);

        System.out.println(c.get(Calendar.DAY_OF_MONTH)+"日");

        String[] weeks = {"","星期日","星期一","星期二","星期三","星期四","星期五","星期六"};
        int indexW = c.get(Calendar.DAY_OF_WEEK);
        //System.out.println("星期"+c.get(Calendar.DAY_OF_WEEK));
        System.out.println(weeks[indexW]);
        //System.out.println(indexW);

    }


}

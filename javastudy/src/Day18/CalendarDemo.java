package Day18;

import java.util.Calendar;

public class CalendarDemo {
    public static void main(String[] args) {
        Calendar c = Calendar.getInstance();



        //System.out.println(c.get(Calendar.YEAR)+"年");
        //System.out.println(c.get(Calendar.YEAR)+"年"+(c.get(Calendar.MONTH)+1)+"月"+c.get(Calendar.DAY_OF_MONTH)+"日");

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



        /*
        Date d = new Date();

        SimpleDateFormat sdf = new SimpleDateFormat("YYYY");

        String year = sdf.format(d);

        System.out.println(year);
        */
    }
}











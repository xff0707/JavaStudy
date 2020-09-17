package Day13;

/*
3. 获取一个字符串在另一个字符串中出现的次数。
    "abkkcdkkefkkskk"
    思路：
    1. 定义一个计数器。
    2. 获取kk第一次出现的位置。
    3. 从第一次出现位置后剩余的字符串中继续获取kk出现的位置。
        每获取一次就计数一次。
    4. 当获取不到时，计数完成。


4.获取两个字符串中最大相同字串，第一个动作：将短的那个串进行长度一次递减的子串打印。
    "abcwerthelloyuiodef"
    "cvhellobnm"
    思路：
        1. 将短的那个子串按照长度递减的方式获取到。
        2. 将获取到的子串去长串中判断是否包含，
            如果包含，已经找到！。
*/
public class StringTest2 {
    /*
    练习三。
    */
    public static int getSubCount(String str,String key)
    {
        int count = 0;
        int index = 0;

        while((index=str.indexOf(key))!=-1)//子串第一次出现的位置
        {
            System.out.println("str="+str);
            str = str.substring(index+key.length());//子串第一次出现的位置+子串长度＝下次查找的串

            count++;
        }
        return count;
    }

    /*
    练习三，方式二。
     */
    public static int getSubCount_2(String str,String key)
    {
        int count = 0;
        int index = 0;

        while((index=str.indexOf(key,index))!=-1)//子串第一次出现的位置
        {
            System.out.println("index="+index);
           index += key.length();

            count++;
        }
        return count;
    }

    public static void main(String[] args) {
        String str = "abkkcdkkefkkskk";

        //System.out.println("count======"+str.split("kk").length);//不建议使用

        //System.out.println("count="+getSubCount(str,"kk"));
        System.out.println("count="+getSubCount_2(str,"kk"));
    }
}

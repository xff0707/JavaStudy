package javastudy25days.Day13;

public class Stringtest {
    public static void sop(String str)
    {
        System.out.println(str);
    }
    public static void main(String[] args) {
        //String s = "      asdja a     ";
        String s = "zxcvbnm ";
        sop("("+s+")");

        sop("("+reverseString(s,3,5)+")");

        //sop("("+reverseString(s)+")");

        //sop("("+myTrim(s)+")");
    }

    //练习二：将字符串反转
    /*
    思路：
    1. 将字符串变成数组
    2. 对数组反转
    3. 将数组变成字符串
    */
    public static String reverseString(String s,int start,int end)
    {
        //将字符串变成数组
        char[] chs = s.toCharArray();

        //对数组反转
        reverse(chs,start,end);

        //将数组变成字符串
        return new String(chs);
    }
    private static void reverse(char[] arr,int x,int y)
    {
        for(int start=x,end=y-1;start<end;start++,end--)
        {
            swap(arr,start,end);
        }
    }
    public static String reverseString(String s)
    {

        return reverseString(s,0,s.length());
        /*
        //将字符串变成数组
        char[] chs = s.toCharArray();

        //对数组反转
        reverse(chs);

        //将数组变成字符串
        return new String(chs);
         */
    }
    private static void reverse(char[] arr)
    {
        for(int start=0,end=arr.length-1;start<end;start++,end--)
        {
            swap(arr,start,end);
        }
    }
    private static void swap(char[] arr,int x,int y)
    {
        char temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }

    //练习一：去除字符串两端的空格
    public static String myTrim(String str)
    {
        int start = 0,end = str.length()-1;
        while (start<=end && str.charAt(start)==' ')
            start++;
        while (start<=end && str.charAt(end)==' ')
            end--;
        return  str.substring(start,end+1);
    }
}

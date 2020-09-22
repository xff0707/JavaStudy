package javastudy25days.Day13;

import java.util.Arrays;

/*
StringBuffer是字符串缓冲区。

是一个容器。
特点：
1. 而且长度是可变化的。
2. 可以直接操作多个数据类型。
3. 最终会通过toString方法变成字符串。

C create U update R read D delete

1. 存储。
    StringBuffer append();将指定数据作为参数添加到已有数据结尾处。
    StringBuffer insert(index,数据);可以将数据插入到指定的index位置。

2. 删除。
    StringBuffer delete(start,end);删除缓冲区中的数据，包含start，不包含end。
    StringBuffer deleteCharAt(index);删除指定位置的字符

3. 获取。
    char charAt(int index);返回 char在指定索引在这个序列值。
    int indexOf(String str, int fromIndex);返回指定子字符串第一次出现的字符串内的索引。
    int lastIndexOf(String str);返回指定子字符串最右边出现的字符串内的索引。
    int length();返回长度（字符数）。
    String substring(int start, int end);返回一个新的 String ，其中包含此序列中当前包含的字符的子序列。

4. 修改。
    StringBuffer replace(int start, int end, String str);用指定的String中的字符替换此序列的子字符串中的 String
    void setCharAt(int index, char ch);指定索引处的字符设置为 ch 。

5. 反转。
    StringBuffer reverse();导致该字符序列被序列的相反代替。

6. 将缓冲区的指定数据存储到指定数组(的指定位置)中。
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
                字符从该序列复制到目标字符数组 dst 。


在JDK1.5之后出现了StringBuilder.

StringBuffer是线程同步。
Stringbuilder是线程不同步。

以后开发，建议使用StringBuilder。代码将StringBuffer改成StringBuilder即可

升级三个因素：
1. 提高效率
2. 简化书写
3. 提高安全性

 */
public class StringBufferDemo {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("abcdef");
        char ch = sb.charAt(1);
        int i = sb.indexOf("abc",1);
        System.out.println("sb="+sb);
        StringBuffer sb1 = sb.replace(1,3,"我");
        System.out.println("sb="+sb);
        System.out.println("sb1="+sb1);
        System.out.println("ch="+ch);
        System.out.println("i="+i);

        char[] c = new char[1024];
        sb.getChars(3,sb.length(),c,0);
        System.out.println(Arrays.toString(c));
        //通过自己测试，基本都在原有对象上修改。除非返回字符串或者其他类型


        /*
        //method_update();

        StringBuffer sb = new StringBuffer(("abcdef"));

        char[] chs = new char[4];
        sb.getChars(1,4,chs,1);

        for(int x=0;x<chs.length;x++)
        {
            System.out.println("chs["+x+"]="+chs[x]+";");
         */
    }

    public static void method_update()
    {
        StringBuffer sb = new StringBuffer("abcde");
        System.out.println(sb.toString());

        //sb.replace(1,4,"java");
        sb.setCharAt(2,'x');

        System.out.println(sb.toString());
    }


    public static void method_del()
    {
        StringBuffer sb = new StringBuffer("abcde");

        System.out.println(sb.toString());

        //sb.delete(1,3);
        //清空缓冲区。
        //sb = new StringBuffer();
        //sb.delete(0,sb.length());

        //sb.delete(2,3);
        sb.deleteCharAt(2);

        System.out.println(sb.toString());
    }

    public static void method_add()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("abc").append(true).append(34);//方法调用链

        System.out.println(sb.toString());

        sb.insert(1,"qq");
        System.out.println(sb.toString());
        //StringBuffer sb1 = sb.append(34);
        //System.out.println("sb==sb1:"+(sb==sb1));
        //System.out.println(sb.toString());
        //System.out.println(sb1.toString());

    }


}

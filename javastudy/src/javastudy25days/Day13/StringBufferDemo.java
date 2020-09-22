package javastudy25days.Day13;

import java.util.Arrays;

/*
StringBuffer���ַ�����������

��һ��������
�ص㣺
1. ���ҳ����ǿɱ仯�ġ�
2. ����ֱ�Ӳ�������������͡�
3. ���ջ�ͨ��toString��������ַ�����

C create U update R read D delete

1. �洢��
    StringBuffer append();��ָ��������Ϊ������ӵ��������ݽ�β����
    StringBuffer insert(index,����);���Խ����ݲ��뵽ָ����indexλ�á�

2. ɾ����
    StringBuffer delete(start,end);ɾ���������е����ݣ�����start��������end��
    StringBuffer deleteCharAt(index);ɾ��ָ��λ�õ��ַ�

3. ��ȡ��
    char charAt(int index);���� char��ָ���������������ֵ��
    int indexOf(String str, int fromIndex);����ָ�����ַ�����һ�γ��ֵ��ַ����ڵ�������
    int lastIndexOf(String str);����ָ�����ַ������ұ߳��ֵ��ַ����ڵ�������
    int length();���س��ȣ��ַ�������
    String substring(int start, int end);����һ���µ� String �����а����������е�ǰ�������ַ��������С�

4. �޸ġ�
    StringBuffer replace(int start, int end, String str);��ָ����String�е��ַ��滻�����е����ַ����е� String
    void setCharAt(int index, char ch);ָ�����������ַ�����Ϊ ch ��

5. ��ת��
    StringBuffer reverse();���¸��ַ����б����е��෴���档

6. ����������ָ�����ݴ洢��ָ������(��ָ��λ��)�С�
void getChars(int srcBegin, int srcEnd, char[] dst, int dstBegin)
                �ַ��Ӹ����и��Ƶ�Ŀ���ַ����� dst ��


��JDK1.5֮�������StringBuilder.

StringBuffer���߳�ͬ����
Stringbuilder���̲߳�ͬ����

�Ժ󿪷�������ʹ��StringBuilder�����뽫StringBuffer�ĳ�StringBuilder����

�����������أ�
1. ���Ч��
2. ����д
3. ��߰�ȫ��

 */
public class StringBufferDemo {
    public static void main(String[] args) {

        StringBuffer sb = new StringBuffer("abcdef");
        char ch = sb.charAt(1);
        int i = sb.indexOf("abc",1);
        System.out.println("sb="+sb);
        StringBuffer sb1 = sb.replace(1,3,"��");
        System.out.println("sb="+sb);
        System.out.println("sb1="+sb1);
        System.out.println("ch="+ch);
        System.out.println("i="+i);

        char[] c = new char[1024];
        sb.getChars(3,sb.length(),c,0);
        System.out.println(Arrays.toString(c));
        //ͨ���Լ����ԣ���������ԭ�ж������޸ġ����Ƿ����ַ���������������


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
        //��ջ�������
        //sb = new StringBuffer();
        //sb.delete(0,sb.length());

        //sb.delete(2,3);
        sb.deleteCharAt(2);

        System.out.println(sb.toString());
    }

    public static void method_add()
    {
        StringBuffer sb = new StringBuffer();

        sb.append("abc").append(true).append(34);//����������

        System.out.println(sb.toString());

        sb.insert(1,"qq");
        System.out.println(sb.toString());
        //StringBuffer sb1 = sb.append(34);
        //System.out.println("sb==sb1:"+(sb==sb1));
        //System.out.println(sb.toString());
        //System.out.println(sb1.toString());

    }


}

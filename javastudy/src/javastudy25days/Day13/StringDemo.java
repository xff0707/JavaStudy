package javastudy25days.Day13;

public class StringDemo {
    public static void main(String[] args) {
        String s1 = "abc";//s1��һ�������ͱ�����"abc"��һ������
                        //�ַ�������ص㣺һ������ʼ���Ͳ����Ա��ı䡣
        //s1 = "kk";

        String s2 = new String("abc");

        //s1��s2ʲô����
        //s1���ڴ�����һ������
        //s2���ڴ�������������

        //System.out.println(s1);
        System.out.println(s1 == s2);//��ַ��ͬfalse
        System.out.println(s1.equals(s2));//String�ิд��Object����equals������
                                        //�÷��������ж��ַ����Ƿ���ͬ��

    }
}
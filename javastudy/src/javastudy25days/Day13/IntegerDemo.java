package javastudy25days.Day13;

/*
�����������Ͷ����װ�ࡣ

byte    Byte
short   Short
int     Integer
long    Long
boolean Boolean
float   Float
double  Double
char    Character



�����������Ͷ����װ���������ã�
�������ڻ����������ͺ��ַ�������֮����ת��

������������ת���ַ���

        ������������+""

        ������������.toString(������������);

        �磺  Integer.toString(34);//��34�������"34"

�ַ���ת�ɻ�����������

    xxx a = Xxx.parseXxx(String);

    int num = Integer.parseInt("123");

    double d = Double.parseDouble("123")

    boolean b = Boolean.parseBoolean("true");

    Integer i = new Integer("123");
    int num = i.intValue();

ʮ����ת����������
    toBinaryString()
    toHexString()
    Integer.toOctalString()

��������ת��ʮ����
    pareseInt(string,radix);

*/
public class IntegerDemo {
    public static void main(String[] args) {
        //�������͵����ֵ��
        //System.out.println("int max="+Integer.MAX_VALUE);

        //��һ���ַ���ת����������
        int num = Integer.parseInt("123");//���봫�����ָ�ʽ���ַ���
        //long x = Long.parseLong("123");

        //System.out.println("num="+num+x);

        //System.out.println(Integer.toBinaryString(-6));
        //System.out.println(Integer.toHexString(60));

        int x = Integer.parseInt("3c",16);
        System.out.println("x="+x);

    }
}

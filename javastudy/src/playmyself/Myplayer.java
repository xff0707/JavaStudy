package playmyself;

public class Myplayer {
    public static void main(String[] args) {
        //byte b = 125;
        //System.out.println(b);
        //byte b = 3;
        //b = (byte)(b + 2);//ǿ��ת��
        //System.out.println(b);
        /*
        int x = 4;x = 10;
        byte b = 2;//-128~127
        //byte b1=128;//�ᱨ��
        short i = 41;
        float f = 2.3f;
        double d = 34.56;
        char ch = '4';					char ch1 = ' ';
        boolean bo = true;*/

/*
        int x = 4270;
        x = x / 1000 * 1000;
        System.out.println(x);
        System.out.println("a="+a+","+"b="+b);

        //�ַ������ݺ��κ�����ʹ��+���������ӣ����ն������ַ���
        System.out.println("5+5="+(5+5));
        int a,b,c;
        a = b = c = 5;

        //�߼��������������boolean���͵ı��ʽ

        //x>3 & x<6 =true & true =true

        /*
        & ��    һ�ټ��� ȫ������
        | ��    һ�漴��
        ^ ���  ������ͬΪ�٣���ͬΪ��
        ! ��    ��
        && ��   ���Ϊ��ʱ�ұ߲�����
        || ��   ���Ϊ��ʱ�ұ߲�����

        */
/*
        int m,n;
        m=3;
        n=8;
        System.out.println("m="+m+",n="+n);
        //1.ͨ������������ ����ʱʹ��
        int temp;
        temp=m;
        m=n;
        n=temp;
        System.out.println("m="+m+",n="+n);

        //2.���õ���������
        n = n + m;//���m��n��ֵ�ǳ������׳�����Χ
        m = n - m;
        n = n - m;
        System.out.println("m="+m+",n="+n);
        //3.�����ͷ�ʽ
        n = n ^ m;
        m = n ^ m;//(n^m)^m
        n = n ^ m;//n^(n^m)
        System.out.println("m="+m+",n="+n);
*/

/*
        System.out.println(Integer.toBinaryString(60));

        int num=60;
        //��ȡ60�������λ��ͨ��&15��
        //num & 15=12;
        int n1=num&15;
        System.out.println((char)(n1-10+'A'));
        //Ҫ��ȡ��һ����λ����60������λ��
        int temp =60>>4;//ֻ��˫���ƣ���λ������ѭ��
        //��temp��ֵ���������λ�Ļ�ȡ��
        //temp&15=3;
        int n2=temp &15;
        System.out.println(n2);
      /*
      0-9 'A' 'B' 'C' 'D' 'E' 'F'
           65  66  67
          10  11  12  13  14  15
      12-10=2+'A'=(char)67
      */
/*
        int x=3,y;
        y=(x>1)?100:200;
        System.out.println(y);
*/

    Son s = new Son();
    s.show();

    }
}

class Father
{
    private int x = 6;
    public void show()
    {
        System.out.println(x);
    }
}

class Son extends Father
{
    @Override
    public void show() {
        super.show();
    }
}
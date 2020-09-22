package supplementary.nio;

import java.nio.ByteBuffer;


/*
һ��������(Buffer)����Java NIO�и������ݵĴ�ȡ���������������顣���ڴ洢��ͬ�������͵�����

�����������Ͳ�ͬ(Boolean)���⣬�ṩ����Ӧ�Ļ�������
ByteBuffer
CharBuffer
ShortBuffer
IntBuffer
LongBuffer
FloatBuffer
DoubleBuffer


�����������Ĺ���ʽ����һ�£�ͨ��allocate()��ȡ������


�����������洢���ݵ��������ķ�����
put():�������ݵ���������
get():��ȡ�������е�����

�������������ĸ��������ԣ�
capacity����������ʾ�����������洢���ݵ�������һ���������ܸı䡣
limit�����ޣ���ʾ�������п��Բ������ݵĴ�С��(limit�����ݲ��ܽ��ж�д)
position��λ�ã���ʾ�����������ڲ������ݵ�λ�á�

mark����ǣ���ʾ��¼��ǰposition��λ�á�����ͨ��reset()�ָ���markλ��

position <= limit <= capacity


�ġ�ֱ�ӻ��������ֱ�ӻ�������
��ֱ�ӻ�������ͨ��allocate()�������仺��������������������JVM���ڴ���
ֱ�ӻ�������ͨ��allocateDirect()��������ֱ�ӻ��������������������������ڴ��У��������Ч��


 */


public class TestBuffer {
    public static void main(String[] args) {
        //test1();
        //test2();
        test3();

    }

    public static void test3(){
        //����ֱ�ӻ�����
        ByteBuffer buf = ByteBuffer.allocateDirect(1024);

        System.out.println(buf.isDirect());//�ж��Ƿ�Ϊֱ�ӻ�����

    }
    public static void test2(){
        String str = "abcde";

        //1.����һ��ָ����С�Ļ�����
        ByteBuffer buf = ByteBuffer.allocate(1024);

        buf.put(str.getBytes());

        buf.flip();

        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));//ab
        System.out.println(buf.position());//2


        //mark���
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));//cd

        System.out.println(buf.position());//4


        //reset()�ָ���markλ��
        buf.reset();
        System.out.println(buf.position());//2


        //�жϻ��������Ƿ���ʣ������
        if (buf.hasRemaining())
        {
            //��ȡ�������п��Բ�����
            System.out.println(buf.remaining());//3
        }


    }



    public static void test1()
    {

        String str = "abcde";

        //1.����һ��ָ����С�Ļ�����
        ByteBuffer buf = ByteBuffer.allocate(1024);

        System.out.println("--------------allocate--------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//0,1024,1024


        //2.����put() �������ݵ���������
        buf.put(str.getBytes());


        System.out.println("-----------------put----------------");
        System.out.println(buf.position());//5��ָ����д������һ������λ��
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//5,1024,1024


        //3.�л���ȡ����ģʽ
        buf.flip();

        System.out.println("-----------------flip----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//0,5,1024


        //4.����get()��ȡ�������е�����
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst, 0, dst.length));

        System.out.println("-----------------get----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//5,5,1024


        //5.rewind()�����ظ�������
        buf.rewind();

        System.out.println("-----------------rewind----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//0,5,1024


        //6.clear()����ջ����������ǻ������е�������Ȼ���ڣ����Ǵ��ڡ���������״̬
        buf.clear();

        System.out.println("-----------------clear----------------");
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());//0,1024,1024

        /*
        for (int i = 0; i < 6; i++) {
            System.out.println((char) buf.get());
        }
        */

    }




}

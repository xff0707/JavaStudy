package supplementary.nio;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.Pipe;

public class TestPipe {
    public static void main(String[] args) throws IOException {
        test1();
    }

    public static void test1() throws IOException {
        //1.��ȡ�ܵ�
        Pipe pipe = Pipe.open();

        //2.���������е�����д��ܵ�
        ByteBuffer buf = ByteBuffer.allocate(1024);

        Pipe.SinkChannel sinkChannel = pipe.sink();
        buf.put("ͨ������ܵ���������".getBytes());
        buf.flip();
        sinkChannel.write(buf);

        //3.��ȡ�������е�����
        Pipe.SourceChannel sourceChannel = pipe.source();
        buf.flip();
        int len = sourceChannel.read(buf);
        System.out.println(new String(buf.array(),0, len));

        sourceChannel.close();
        sinkChannel.close();


    }
}

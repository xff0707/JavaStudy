package Day03;

public class OtherDemo {
    public static void main(String[] args) {
        //break
        w:for(int x=0;x<4;x++)
        {
            for (int y=0;y<3;y++)
            {
                System.out.println("x="+x+",y="+y);
                break;//ֱ��������ѭ��
            }
        }
        //continue
        for(int x=0;x<4;x++)
        {
            for (int y=0;y<3;y++)
            {
                System.out.println("x="+x+",y="+y);
                continue;//������һ��ѭ����y++Ҳ��ִ��
            }
        }
    }
}

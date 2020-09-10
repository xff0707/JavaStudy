package Day03;

public class OtherDemo {
    public static void main(String[] args) {
        //break
        w:for(int x=0;x<4;x++)
        {
            for (int y=0;y<3;y++)
            {
                System.out.println("x="+x+",y="+y);
                break;//直接天跳出循环
            }
        }
        //continue
        for(int x=0;x<4;x++)
        {
            for (int y=0;y<3;y++)
            {
                System.out.println("x="+x+",y="+y);
                continue;//继续下一次循环，y++也会执行
            }
        }
    }
}

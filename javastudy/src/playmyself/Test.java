package playmyself;

public class Test {
    public static void main(String[] args) {
        //Scanner input = new Scanner(System.in);
        //long m = input.nextInt();
        /*
        long a = System.currentTimeMillis();
        long n = 3;
        long sum = 0;
        long j = 1;
        for(long x = 1;x<=n;x++)
        {
            for(long y = 1;y<=x;y++)
            {
                j*=y;
            }
            sum+=j;
            j=1;
            System.out.println("1!+...+"+x+"!="+sum);
        }
        System.out.println(sum);
        System.out.println(Long.MAX_VALUE);
        System.out.println(sqrt(164));
        System.out.println(System.currentTimeMillis()-a);

         */

        /*
        Properties prop = System.getProperties();

        for(Object obj : prop.keySet())
        {
            String value = (String)prop.get(obj);

            System.out.println(obj+"::"+value);
        }

         */

        /*
        double y,d;
        for(int x=1;x<50000;x+=50)
        {
            y = Math.pow(1+1/(double)x,x);
            d = Math.abs(Math.E-y);
            System.out.println("x="+x+",e="+y+",de="+d);
        }
        System.out.println(Math.E);
        */

        /*
        for (int i=1;i<10;i++)
        {
            int a1 = (int)Math.random();
            int a2 = (int)Math.random();
            int a3 = (int)Math.random();
            int a4 = (int)Math.random();
            int a5 = (int)Math.random();
            int a6 = (int)Math.random();
            System.out.println(a);
        }
         */

        /*
        //int a1,a2,a3,a4,a5,a6;
        int a1 = 1;
        int a2 = 1;
        int a3 = 1;
        int a4 = 1;
        int a5 = 1;
        int a6 = 1;
        int x = 1;
        while (!(a1==8&a2==8&a3==8&a4==8&a5==8&a6==8))
        {
            a1 = (int) (Math.random() * 8) + 1;
            a2 = (int) (Math.random() * 8) + 1;
            a3 = (int) (Math.random() * 8) + 1;
            a4 = (int) (Math.random() * 8) + 1;
            a5 = (int) (Math.random() * 8) + 1;
            a6 = (int) (Math.random() * 8) + 1;
            System.out.println(x+":"+a1+".."+a2+".."+a3+".."+a4+".."+a5+".."+a6);
            x++;
        }

         */
        //From1 f = new From1();

        //f.setVisible(true);

        System.out.println(10.9*3/20/4);

    }


    public static int demo(int x)
    {
        if (x==1 || x==2)
            return 1;
        return demo(x-1)+demo(x-2);
    }
}

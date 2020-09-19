import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    public static void main(String[] args) {
        /*
        System.out.println(Math.cos(Math.toRadians(90)));
        double d = Tools.DMSChange.DMSToRad(90.3030);
        System.out.println(d);
         */

        JFrame jf = new JFrame();
        jf.setTitle("支导线平差计算程序");
        jf.setBounds(300,200,400,300);

        /*
        JMenuBar jmb = new JMenuBar();
        JMenuItem jm1 = new JMenuItem("打开");
        JMenuItem jm2 = new JMenuItem("计算");
        JMenuItem jm3 = new JMenuItem("清除");
        JMenuItem jm4 = new JMenuItem("关闭");
        jmb.add(jm1);
        jmb.add(jm2);
        jmb.add(jm3);
        jmb.add(jm4);
        jf.setJMenuBar(jmb);



        jm1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                System.out.println("sss");
                JTextArea jt = ft.getTextArea1();

            }
        });

         */











        /*




        /*
        Line.Traverse t = new Line.Traverse(new Line.Point(100,100),new Line.Point(200,200));
        t.add(Math.PI*3/2,100*Math.sqrt(2));
        ArrayList<Line.Point> ps = t.getPoints();
        //System.out.println(p);
        for (Line.Point p : ps)
        {
            System.out.println(p);
        }



        /*
        double a = Math.atan(-1);
        System.out.println(a);
        double a2 = Math.atan2(10,-10);
        System.out.println(a2);
        System.out.println(35*20);

         */
    }
}

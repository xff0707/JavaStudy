package javastudy25days.Day22;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MouseAnfKeyEvent {

    //定义该图形所需的组件的引用。
    private Frame f;
    private Button but;
    TextField tf;

    MouseAnfKeyEvent()
    {
        init();
    }

    public void init()
    {
        f = new Frame("my frame");

        f.setBounds(300,100,600,500);
        f.setLayout(new FlowLayout());

        tf = new TextField(20);

        but = new Button("My button");

        f.add(tf);
        f.add(but);

        myEvent();

        f.setVisible(true);
    }

    private void myEvent()
    {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        //给but添加一个键盘监听
        but.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                //System.out.println(e.getKeyChar()+"....."+e.getKeyCode()+"....."+KeyEvent.getKeyText(e.getKeyCode()));
                if (e.getKeyCode()==KeyEvent.VK_ESCAPE)
                    System.out.println("esc");
                    //System.exit(0);
                if (e.isControlDown() && e.getKeyCode()==KeyEvent.VK_ENTER)//组合键
                    System.out.println("ctrl+回车");
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
                {
                    System.out.println(code+".....是非法的");
                    e.consume();
                }
            }
        });

        /*
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("活动");
            }
        });

        but.addMouseListener(new MouseAdapter() {
            private int count = 1;
            private int clickcount = 1;
            @Override
            public void mouseEntered(MouseEvent e) {
                System.out.println("鼠标进入到该组件"+count++);
            }

            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2)
                    System.out.println("鼠标双击"+clickcount++);
            }
        });

         */

    }

    public static void main(String[] args) {
        new MouseAnfKeyEvent();
    }
}

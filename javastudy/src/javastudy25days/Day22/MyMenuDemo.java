package javastudy25days.Day22;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyMenuDemo {
    private Frame f;
    private MenuBar mb;
    private Menu m,subm;
    private MenuItem closeItem,subItem;

    public MyMenuDemo() {
        init();
    }

    public void init() {
        f = new Frame("my window");
        f.setBounds(300, 100, 600, 700);
        f.setLayout(new FlowLayout());

        mb = new MenuBar();

        m = new Menu("文件");

        subm = new Menu("子菜单");



        subItem = new MenuItem("子条目");
        closeItem = new MenuItem("退出");

        subm.add(subItem);

        m.add(subm);
        m.add(closeItem);
        mb.add(m);

        f.setMenuBar(mb);

        myEvent();

        f.setVisible(true);



    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new MyMenuDemo();
    }
}

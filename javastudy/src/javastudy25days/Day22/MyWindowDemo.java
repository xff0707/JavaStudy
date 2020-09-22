package javastudy25days.Day22;

import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class MyWindowDemo {
    private Frame f;
    private TextField tf;
    private Button but;
    private TextArea ta;

    private Dialog d;
    private Label lab;
    private Button okbut;

    public MyWindowDemo() {
        init();
    }
    public void init()
    {
        f = new Frame("my window");
        f.setBounds(300,100,600,500);
        f.setLayout(new FlowLayout());

        tf = new TextField(60);

        but = new Button("转到");

        ta = new TextArea(28,70);


        d = new Dialog(f,"提示信息-self",true);//true为强制前置
        d.setBounds(400,200,200,200);
        d.setLayout(new FlowLayout());
        lab = new Label();
        okbut = new Button("确定");

        d.add(lab);
        d.add(okbut);



        f.add(tf);
        f.add(but);
        f.add(ta);

        myEvent();
        f.setVisible(true);
    }

    private void myEvent()
    {
        but.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showDir();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        d.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                d.setVisible(false);
            }
        });

        okbut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                d.setVisible(false);
            }
        });

        tf.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode()==KeyEvent.VK_ENTER)
                    showDir();
            }
        });

    }

    private void showDir()
    {
        String dirpath = tf.getText();

        File dir = new File(dirpath);

        if (dir.exists() && dir.isDirectory())
        {
            ta.setText("");
            String[] names = dir.list();
            for (String name : names)
            {
                //ta.setText(name+"\n");
                ta.append(name+"\n");
            }
        }
        else
        {
            String info = "您输入的信息："+dirpath+"是错误的，请重新输入";
            lab.setText(info);
            d.setVisible(true);
        }

        //ta.setText(text);
        //System.out.println(text);
        //tf.setText("");
    }

    public static void main(String[] args) {
        new MyWindowDemo();
    }
}

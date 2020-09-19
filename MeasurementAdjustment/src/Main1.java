import gui.ChangeCoorsForm;
import gui.TraverseForm;
import gui.WelcomeFrom;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main1 {
    public static void main(String[] args) {
        //欢迎界面
        WelcomeFrom w = new WelcomeFrom();
        JButton changecoor = w.getChangeBut();
        JButton spur = w.getspurTra();


        //坐标转换界面
        ChangeCoorsForm c = new ChangeCoorsForm();
        //c.setVisible(true);
        JButton backButc = c.getBackBut();

        //事件监听器
        changecoor.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.setVisible(true);
                w.setVisible(false);
            }
        });
        c.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                c.setVisible(false);
                w.setVisible(true);
            }
        });
        backButc.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                c.setVisible(false);
                w.setVisible(true);
            }
        });


        //支导线界面
        TraverseForm s = new TraverseForm();
        JButton backButs = s.getBackBut();
        spur.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s.setVisible(true);
                w.setVisible(false);
            }
        });
        s.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                s.setVisible(false);
                w.setVisible(true);
            }
        });
        backButs.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                s.setVisible(false);
                w.setVisible(true);
            }
        });


    }
}

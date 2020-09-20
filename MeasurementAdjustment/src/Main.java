import Jama.Matrix;
import gui.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * 主类，用于组织各窗体以成为一个整体
 * @version V1.0
 * @author xff07
 */
public class Main {
    public static void main(String[] args) {
        //欢迎界面
        WelcomeFrom w = new WelcomeFrom();




        //坐标转换界面
        ChangeCoorsForm c = new ChangeCoorsForm();
        JButton changeBut = w.getChangeBut();
        JButton backButc = c.getBackBut();

        //事件监听器
        lister(changeBut, w, c, backButc);

        /*
        changeBut.addMouseListener(new MouseAdapter() {
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
         */


        //导线界面
        TraverseForm s = new TraverseForm();
        JButton spurBut = w.getspurTra();
        JButton backButs = s.getBackBut();
        lister(spurBut, w, s, backButs);


        //交会定点界面
        IntersectionForm i = new IntersectionForm();
        JButton interBut = w.getIntersectionBut();
        JButton backButi = i.getBackBut();
        lister(interBut, w, i, backButi);


        //空间后方交会界面
        SpaceRearRendezvousForm sR = new SpaceRearRendezvousForm();
        JButton spaceBut = w.getSpaceBut();
        JButton backButSR = sR.getBackBut();
        lister(spaceBut, w, sR, backButSR);



    }

    /**
     * 添加事件监听，以便实现界面的切换功能
     * @param mainForm 主窗口
     * @param form 对应另一窗体
     * @param bt2 对应另一窗体的返回按钮
     */
    private static void lister(JButton bt,JFrame mainForm, JFrame form, JButton bt2)
    {
        bt.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                form.setVisible(true);
                mainForm.setVisible(false);
            }
        });
        form.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                form.setVisible(false);
                mainForm.setVisible(true);
            }
        });
        bt2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                form.setVisible(false);
                mainForm.setVisible(true);
            }
        });
    }
}

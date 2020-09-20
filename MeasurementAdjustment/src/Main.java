import Jama.Matrix;
import gui.*;

import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

/**
 * ���࣬������֯�������Գ�Ϊһ������
 * @version V1.0
 * @author xff07
 */
public class Main {
    public static void main(String[] args) {
        //��ӭ����
        WelcomeFrom w = new WelcomeFrom();




        //����ת������
        ChangeCoorsForm c = new ChangeCoorsForm();
        JButton changeBut = w.getChangeBut();
        JButton backButc = c.getBackBut();

        //�¼�������
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


        //���߽���
        TraverseForm s = new TraverseForm();
        JButton spurBut = w.getspurTra();
        JButton backButs = s.getBackBut();
        lister(spurBut, w, s, backButs);


        //���ᶨ�����
        IntersectionForm i = new IntersectionForm();
        JButton interBut = w.getIntersectionBut();
        JButton backButi = i.getBackBut();
        lister(interBut, w, i, backButi);


        //�ռ�󷽽������
        SpaceRearRendezvousForm sR = new SpaceRearRendezvousForm();
        JButton spaceBut = w.getSpaceBut();
        JButton backButSR = sR.getBackBut();
        lister(spaceBut, w, sR, backButSR);



    }

    /**
     * ����¼��������Ա�ʵ�ֽ�����л�����
     * @param mainForm ������
     * @param form ��Ӧ��һ����
     * @param bt2 ��Ӧ��һ����ķ��ذ�ť
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

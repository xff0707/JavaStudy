package gui;

import javax.swing.*;
import java.awt.*;

public class WelcomeFrom extends JFrame {

    private JButton spurTra, changeBut;
    //����һ��JLayeredPane���ڷֲ�ġ�
    JLayeredPane layeredPane;
    //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������
    JPanel jp;
    JLabel jl;
    ImageIcon image;


    public JButton getspurTra() {
        return spurTra;
    }

    public JButton getChangeBut() {
        return changeBut;
    }

    public WelcomeFrom() throws HeadlessException {


        layeredPane = new JLayeredPane();
        image = new ImageIcon("image\\��ӭ.jpg");
        jp = new JPanel();
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        jl = new JLabel(image);
        jp.add(jl);
        changeBut = new JButton("����ת��");
        changeBut.setBounds(10,200,100,100);
        spurTra = new JButton("���߼���");
        spurTra.setBounds(210,200,100,100);

        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(changeBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spurTra,JLayeredPane.MODAL_LAYER);

        setLayeredPane(layeredPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("��ӭ����");
        //setLocation(500,200);
        setSize(640,360);
        setLocationRelativeTo(null);//������ʾ




        setVisible(true);
    }
}

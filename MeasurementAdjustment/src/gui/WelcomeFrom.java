package gui;

import javax.swing.*;
import java.awt.*;

public class WelcomeFrom extends JFrame {

    private JButton spurTra, changeBut;
    //创建一个JLayeredPane用于分层的。
    JLayeredPane layeredPane;
    //创建一个Panel和一个Label用于存放图片，作为背景。
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
        image = new ImageIcon("image\\欢迎.jpg");
        jp = new JPanel();
        jp.setBounds(0,0,image.getIconWidth(),image.getIconHeight());
        jl = new JLabel(image);
        jp.add(jl);
        changeBut = new JButton("坐标转换");
        changeBut.setBounds(10,200,100,100);
        spurTra = new JButton("导线计算");
        spurTra.setBounds(210,200,100,100);

        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);
        layeredPane.add(changeBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spurTra,JLayeredPane.MODAL_LAYER);

        setLayeredPane(layeredPane);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setTitle("欢迎界面");
        //setLocation(500,200);
        setSize(640,360);
        setLocationRelativeTo(null);//居中显示




        setVisible(true);
    }
}

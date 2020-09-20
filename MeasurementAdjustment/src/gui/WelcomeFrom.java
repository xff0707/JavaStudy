package gui;

import javax.swing.*;
import java.awt.*;
/**
 *欢迎界面窗体类
 * @version V1.0
 * @author xff07
 */
public class WelcomeFrom extends JFrame {

    private JButton spurTra, changeBut, intersectionBut, spaceBut;//不同功能按钮


    /**
     * 返回坐标转换按钮，用于添加事件监听
     * @return 示例对象的坐标转换按钮
     */
    public JButton getChangeBut() {
        return changeBut;
    }

    /**
     *返回导线按钮，用于添加事件监听
     * @return 示例对象的导线按钮
     */
    public JButton getspurTra() {
        return spurTra;
    }

    /**
     *返回导线按钮，用于添加事件监听
     * @return 示例对象的交会定点按钮
     */
    public JButton getIntersectionBut() {
        return intersectionBut;
    }


    /**
     *返回空间后方交会按钮，用于添加事件监听
     * @return 示例对象的空间后方交会按钮
     */
    public JButton getSpaceBut() {
        return spaceBut;
    }

    /**
     *构造函数
     * @throws HeadlessException
     */
    public WelcomeFrom() throws HeadlessException {
        //窗体初始化
        //创建一个JLayeredPane用于分层的。
        JLayeredPane layeredPane = new JLayeredPane();
        ImageIcon image = new ImageIcon("image\\封面.png");
        JPanel jp = new JPanel();
        jp.setBounds(0,0, image.getIconWidth(), image.getIconHeight());//设置图片背景
        //创建一个Panel和一个Label用于存放图片，作为背景。
        JLabel jl = new JLabel(image);
        jp.add(jl);


        JLabel help = new JLabel();


        //按钮初始化并设置位置
        changeBut = new JButton("坐标转换");
        changeBut.setBounds(20,30,200,40);
        spurTra = new JButton("导线计算");
        spurTra.setBounds(20,100,200,40);
        intersectionBut = new JButton("交会定点");
        intersectionBut.setBounds(230,30,200,40);
        spaceBut = new JButton("空间后方交会");
        spaceBut.setBounds(230,100,200,40);


        /*
        changeBut = new JButton("坐标转换");
        changeBut.setBounds(10,10,90,30);
        spurTra = new JButton("导线计算");
        spurTra.setBounds(10,50,90,30);
        intersectionBut = new JButton("交会定点");
        intersectionBut.setBounds(10,90,90,30);
        spaceBut = new JButton("空间后方交会");
        spaceBut.setBounds(10,130,90,30);
        */


        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);//设置深度，深度大的，显示在顶部
        layeredPane.add(changeBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spurTra,JLayeredPane.MODAL_LAYER);
        layeredPane.add(intersectionBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spaceBut,JLayeredPane.MODAL_LAYER);

        setLayeredPane(layeredPane);//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮

        setTitle("测量工具箱V1.0");//设置标题
        setSize(480,210);//设置大小
        //setSize(640,360);//设置大小
        setLocationRelativeTo(null);//居中显示
        setResizable(false);

        setVisible(true);//窗体可见
    }
}

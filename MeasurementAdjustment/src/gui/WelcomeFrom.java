package gui;

import javax.swing.*;
import java.awt.*;
/**
 *��ӭ���洰����
 * @version V1.0
 * @author xff07
 */
public class WelcomeFrom extends JFrame {

    private JButton spurTra, changeBut, intersectionBut, spaceBut;//��ͬ���ܰ�ť


    /**
     * ��������ת����ť����������¼�����
     * @return ʾ�����������ת����ť
     */
    public JButton getChangeBut() {
        return changeBut;
    }

    /**
     *���ص��߰�ť����������¼�����
     * @return ʾ������ĵ��߰�ť
     */
    public JButton getspurTra() {
        return spurTra;
    }

    /**
     *���ص��߰�ť����������¼�����
     * @return ʾ������Ľ��ᶨ�㰴ť
     */
    public JButton getIntersectionBut() {
        return intersectionBut;
    }


    /**
     *���ؿռ�󷽽��ᰴť����������¼�����
     * @return ʾ������Ŀռ�󷽽��ᰴť
     */
    public JButton getSpaceBut() {
        return spaceBut;
    }

    /**
     *���캯��
     * @throws HeadlessException
     */
    public WelcomeFrom() throws HeadlessException {
        //�����ʼ��
        //����һ��JLayeredPane���ڷֲ�ġ�
        JLayeredPane layeredPane = new JLayeredPane();
        ImageIcon image = new ImageIcon("image\\����.png");
        JPanel jp = new JPanel();
        jp.setBounds(0,0, image.getIconWidth(), image.getIconHeight());//����ͼƬ����
        //����һ��Panel��һ��Label���ڴ��ͼƬ����Ϊ������
        JLabel jl = new JLabel(image);
        jp.add(jl);


        JLabel help = new JLabel();


        //��ť��ʼ��������λ��
        changeBut = new JButton("����ת��");
        changeBut.setBounds(20,30,200,40);
        spurTra = new JButton("���߼���");
        spurTra.setBounds(20,100,200,40);
        intersectionBut = new JButton("���ᶨ��");
        intersectionBut.setBounds(230,30,200,40);
        spaceBut = new JButton("�ռ�󷽽���");
        spaceBut.setBounds(230,100,200,40);


        /*
        changeBut = new JButton("����ת��");
        changeBut.setBounds(10,10,90,30);
        spurTra = new JButton("���߼���");
        spurTra.setBounds(10,50,90,30);
        intersectionBut = new JButton("���ᶨ��");
        intersectionBut.setBounds(10,90,90,30);
        spaceBut = new JButton("�ռ�󷽽���");
        spaceBut.setBounds(10,130,90,30);
        */


        layeredPane.add(jp,JLayeredPane.DEFAULT_LAYER);//������ȣ���ȴ�ģ���ʾ�ڶ���
        layeredPane.add(changeBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spurTra,JLayeredPane.MODAL_LAYER);
        layeredPane.add(intersectionBut,JLayeredPane.MODAL_LAYER);
        layeredPane.add(spaceBut,JLayeredPane.MODAL_LAYER);

        setLayeredPane(layeredPane);//
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//�رհ�ť

        setTitle("����������V1.0");//���ñ���
        setSize(480,210);//���ô�С
        //setSize(640,360);//���ô�С
        setLocationRelativeTo(null);//������ʾ
        setResizable(false);

        setVisible(true);//����ɼ�
    }
}

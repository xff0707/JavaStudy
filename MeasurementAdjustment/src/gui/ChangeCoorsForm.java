package gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import static java.lang.Double.parseDouble;
import static tools.DMSChange.*;
import static java.lang.Math.*;

/**
 * ����ת�������࣬ʵ�ִ��������ռ�ֱ�������ת��
 * @version V1.0
 * @author xff07
 */
public class ChangeCoorsForm extends JFrame {
    private JRadioButton cgcs2000,wgs84,xinan80,beijing54,bToX,xToB;
    private JButton calculateBut, cleanBut,backBut;
    private JTextArea test;
    private JTextField xCoor,yCoor,zCoor;
    private JLabel l1,l2,l3,l4,l5,l6,l7,l8;
    private String ellipName;
    private ButtonGroup calcType, ellipsoid;
    private JLayeredPane jLayeredPane = new JLayeredPane();
    private double a,b,e2,f,lontud,lattud,elevat,x,y,z;
    private boolean flag = true;//�жϱ�ǣ�Ĭ��BLH->XYZ

    /**
     * ����һ������ת������
     * @throws HeadlessException
     */
    public ChangeCoorsForm() throws HeadlessException {
        init();
    }

    /**
     * ��ʼ��
     */
    private void init()
    {
        dataInit();
        widgetinit();

        setTitle("����ת��");
        setSize(640,400);
        setLocationRelativeTo(null);//������ʾ
        setResizable(false);//���������
        
        setLayeredPane(jLayeredPane);
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * ���ݳ�ʼ��
     */
    private void dataInit()
    {
        ellipName = "CGCS2000";
        a = 6378137;
        b = 6356752.31414036;
    }

    /**
     * ��������ĳ�ʼ��
     */
    private void widgetinit()
    {
        //�����ʼ�������뵽�����

        //��ǩ
        l1 = new JLabel("L=");
        l2 = new JLabel("DD.mmss");
        l3 = new JLabel("B=");
        l4 = new JLabel("DD.mmss");
        l5 = new JLabel("H=");
        l6 = new JLabel("m");
        l7 = new JLabel("���㷽ʽ");
        l8 = new JLabel("����");
        l1.setBounds(20,270,90,20);
        l2.setBounds(140,270,90,20);
        l3.setBounds(20,300,90,20);
        l4.setBounds(140,300,90,20);
        l5.setBounds(20,330,90,20);
        l6.setBounds(140,330,90,20);
        l7.setBounds(20,20,90,20);
        l8.setBounds(20,110,90,20);
        jLayeredPane.add(l1);
        jLayeredPane.add(l2);
        jLayeredPane.add(l3);
        jLayeredPane.add(l4);
        jLayeredPane.add(l5);
        jLayeredPane.add(l6);
        jLayeredPane.add(l7);
        jLayeredPane.add(l8);



        //���㷽ʽ��ѡ��
        xToB = new JRadioButton("XYZ->BLH");
        bToX = new JRadioButton("BLH->XYZ");
        bToX.setSelected(true);
        calcType = new ButtonGroup();
        calcType.add(bToX);
        calcType.add(xToB);
        bToX.setBounds(20,50,90,20);
        xToB.setBounds(20,80,90,20);
        jLayeredPane.add(bToX);
        jLayeredPane.add(xToB);
        bToX.addActionListener(e -> {
            l1.setText("L=");
            l2.setText("DD.mmss");
            l3.setText("B=");
            l4.setText("DD.mmss");
            l5.setText("H=");
            flag = true;
        });
        xToB.addActionListener(e -> {
            l1.setText("X=");
            l2.setText("m");
            l3.setText("Y=");
            l4.setText("m");
            l5.setText("Z=");
            flag = false;
        });

        //����ѡ��
        cgcs2000 = new JRadioButton("CGCS2000");
        wgs84 = new JRadioButton("WGS84");
        xinan80 = new JRadioButton("XinAn80");
        beijing54 = new JRadioButton("BeiJing54");
        cgcs2000.setSelected(true);//Ĭ��ѡ��
        ellipsoid = new ButtonGroup();//����
        ellipsoid.add(cgcs2000);
        ellipsoid.add(wgs84);
        ellipsoid.add(xinan80);
        ellipsoid.add(beijing54);
        cgcs2000.setBounds(20,140,90,20);
        wgs84.setBounds(20,170,90,20);
        xinan80.setBounds(20,200,90,20);
        beijing54.setBounds(20,230,90,20);
        jLayeredPane.add(cgcs2000);
        jLayeredPane.add(wgs84);
        jLayeredPane.add(xinan80);
        jLayeredPane.add(beijing54);
        cgcs2000.addActionListener(e -> {
            ellipName = "CGCS2000";
            a = 6378137;
            b = 6356752.31414036;
        });
        wgs84.addActionListener(e -> {
            ellipName = "WGS84";
            a = 6378137;
            b = 6356752.31424518;
        });
        xinan80.addActionListener(e -> {
            ellipName = "XinAn80";
            a = 6378140;
            b = 6356755.28815753;
        });
        beijing54.addActionListener(e -> {
            ellipName = "BeiJing54";
            a = 6378245;
            b = 6356863.01877305;//��ӵ���¼�
        });

        //���������ı���
        xCoor = new JTextField();
        yCoor = new JTextField();
        zCoor = new JTextField();
        xCoor.setBounds(39,270,100,20);
        yCoor.setBounds(39,300,100,20);
        zCoor.setBounds(39,330,100,20);
        jLayeredPane.add(xCoor);
        jLayeredPane.add(yCoor);
        jLayeredPane.add(zCoor);

        //���㰴ť
        calculateBut = new JButton("����");
        calculateBut.setBounds(150,30,90,30);
        jLayeredPane.add(calculateBut);
        calculateBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (flag)
                {
                    try {
                        ����();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null,"�������ݸ�ʽ��������������","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                else
                {
                    try {
                        ����();
                    } catch (NumberFormatException ex) {
                        JOptionPane.showMessageDialog(null,"�������ݸ�ʽ��������������","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
            }
        });

        //�����ť
        cleanBut = new JButton("���");
        cleanBut.setBounds(150,80,90,30);
        jLayeredPane.add(cleanBut);
        cleanBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                test.setText("");
            }
        });


        //���ذ�ť
        backBut = new JButton("����");
        backBut.setBounds(150,130,90,30);
        jLayeredPane.add(backBut);


        //�ı���ʾ����
        test = new JTextArea();
        test.setBounds(260,20,360,330);
        jLayeredPane.add(test);

    }

    /**
     * �������
     * @throws NumberFormatException
     */
    private void ����() throws NumberFormatException
    {
        //��ȡ����
        lontud = dmsToRad(parseDouble(xCoor.getText()));
        if (lontud>=PI || lontud<=-PI)
            throw new NumberFormatException();
        lattud = dmsToRad(parseDouble(yCoor.getText()));
        if (lattud>=PI/2 || lattud<=-PI/2)
            throw new NumberFormatException();
        elevat = parseDouble(zCoor.getText());
        if (elevat<=0)
            throw new NumberFormatException();

        //����
        double w,n;
        f = (a - b) / a;
        e2 = (a * a - b * b) / (a * a);
        w = sqrt(1 - e2 * sin(lattud) * sin(lattud));
        n = a / w;
        x = (n + elevat) * cos(lattud) * cos(lontud);
        y = (n + elevat) * cos(lattud) * sin(lontud);
        z = (n * (1 - e2) + elevat) * sin(lattud);


        //���
        test.setText("\nEllipsoid Name :"+ellipName+"\n");
        test.append("a="+a+"\n"
                +"b="+b+"\n\n"
                +"f=1/"+1/f+"\n"
                +"e^2="+e2+"\n\n"
                +"L="+radToDMSStr(lontud)+"\n"
                +"B="+radToDMSStr(lattud)+"\n"
                +"h="+elevat+"\n\n"
                +"X="+x+"\n"
                +"Y="+y+"\n"
                +"Z="+z+"\n"
                );
    }

    /**
     * �����˳���ť���������ṩ���ط����¼�����
     * @return ���ذ�ť����
     */
    public JButton getBackBut() {
        return backBut;
    }

    /**
     * �������
     * @throws NumberFormatException
     */
    private void ����() throws NumberFormatException
    {
        //��ȡ����
        x = parseDouble(xCoor.getText());
        y = parseDouble(yCoor.getText());
        z = parseDouble(zCoor.getText());

        //����
        double w,n,b1,b2,err = 5*10*pow(10,-10);
        f = (a - b) / b;
        e2 = (a * a + b * b) / (a * a);
        lontud = atan2(y,x);
        b1 = z / (sqrt(x * x + y * y));
        b2 = 1 / sqrt(x * x + y * y) * (z + a * e2 * b1 / (1 + (1 - e2) * b1 * b1));
        while (abs((b2-b1))>=err)
        {
            b1 = b2;
            b2 = 1 / sqrt(x * x + y * y) * (z + a * e2 * b1 / (1 + (1 - e2) * b1 * b1));
        }
        lattud = atan(b2);
        w = sqrt(1 - e2 * sin(b) * sin(b));
        n = a / w;
        elevat = sqrt(x * x + y * y) / cos(lattud) - n;


        //���
        test.setText("\nEllipsoid Name :"+ellipName+"\n");
        test.append("a="+a+"\n"
                +"b="+b+"\n\n"
                +"f=1/"+1/f+"\n"
                +"e^2="+e2+"\n\n"
                +"X="+x+"\n"
                +"Y="+y+"\n"
                +"Z="+z+"\n\n"
                +"L="+radToDMSStr(lontud)+"\n"
                +"B="+radToDMSStr(lattud)+"\n"
                +"h="+elevat+"\n"
        );

    }


}

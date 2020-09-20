package gui;

import javax.swing.*;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.DecimalFormat;

import static java.lang.Double.parseDouble;
import static java.lang.Math.*;
import static tools.DMSChange.*;

/**
 * ���ᶨ������
 * @version V1.0
 * @author xff07
 */
public class IntersectionForm extends JFrame {
    private JButton backBut, calculateBut, cleanBut;
    private JLayeredPane jLayeredPane= new JLayeredPane();
    private JTextField text1, text2, text3;
    private JRadioButton forward, rear;
    private ButtonGroup type;
    private boolean flag = true;//Ĭ��ǰ������
    private JLabel l1, l2, l3, l4;
    private String[] helpText;
    private double x,y;
    private DecimalFormat df = new DecimalFormat();

    /**
     * ����һ�����ᶨ�㴰��
     * @throws HeadlessException
     */
    public IntersectionForm() throws HeadlessException {
        init();
    }

    /**
     * ��ʼ��
     */
    private void init()
    {
        wedgetInit();

        setTitle("���ᶨ��");
        setSize(640,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayeredPane(jLayeredPane);
    }

    /**
     * �����ʼ��
     */
    private void wedgetInit()
    {
        //�ı����ʼ��
        text1 = new JTextField();
        text1.setBounds(30,30,580,30);
        text2 = new JTextField();
        text2.setBounds(330,80,200,40);
        text3 = new JTextField();
        text3.setBounds(330,150,200,40);
        jLayeredPane.add(text1);
        jLayeredPane.add(text2);
        jLayeredPane.add(text3);

        //��ť��ʼ��
        calculateBut = new JButton("����");
        calculateBut.setBounds(200,70,90,30);
        cleanBut = new JButton("���");
        cleanBut.setBounds(200,110,90,30);
        backBut = new JButton("����");
        backBut.setBounds(200,150,90,30);
        jLayeredPane.add(calculateBut);
        jLayeredPane.add(cleanBut);
        jLayeredPane.add(backBut);
        calculateBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                calculate();
                df.setMaximumFractionDigits(2);
                df.setMinimumFractionDigits(2);
                text2.setText(df.format(x)+"");
                text3.setText(df.format(y)+"");
            }
        });
        cleanBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                text1.setText("");
            }
        });



        //��ѡ��
        forward = new JRadioButton("ǰ������");
        forward.setBounds(30,100,90,30);
        forward.setSelected(true);
        rear = new JRadioButton("�󷽽���");
        rear.setBounds(30,140,90,30);
        type = new ButtonGroup();
        type.add(forward);
        type.add(rear);
        jLayeredPane.add(forward);
        jLayeredPane.add(rear);
        forward.addActionListener(e -> {
            flag = true;
            l1.setText(helpText[0]);
        });
        rear.addActionListener(e -> {
            flag = false;
            l1.setText(helpText[1]);
        });

        //��ǩ
        helpText = new String[2];
        helpText[0] = "����������A���B���x���ꡢy���ꡢ�۲�ǣ���Ӣ�Ķ��Ÿ������Ƕȸ�ʽDD.mmss��(�磺x1,y1,a,x2,y2,b)";
        helpText[1] = "������������֪������͹۲��2���Ƕ�,��Ӣ�Ķ��Ÿ������Ƕȸ�ʽDD.mmss��(�磺xA,yA,xC,yC,xB,yB,A,B)";
        l1 = new JLabel(helpText[0]);
        l1.setBounds(20,10,580,20);
        l2 = new JLabel("��ѡ����㷽ʽ��");
        l2.setBounds(30,80,130,20);
        l3 = new JLabel("X=");
        l3.setBounds(310,86,90,30);
        l4 = new JLabel("Y=");
        l4.setBounds(310,156,90,30);
        jLayeredPane.add(l1);
        jLayeredPane.add(l2);
        jLayeredPane.add(l3);
        jLayeredPane.add(l4);

    }

    /**
     * �����˳���ť���������ṩ���ط����¼�����
     * @return ���ذ�ť����
     */
    public JButton getBackBut() {
        return backBut;
    }

    /**
     * ���ڼ��㽻��
     */
    private void calculate()
    {
        if (flag)
        {
            //ǰ������
            try {
                String s1 = text1.getText();
                String s2 = s1.strip();
                String s4 = s2.replaceAll("��",",");
                String[] s3 = s4.split(",");
                double x1 = parseDouble(s3[0]);
                double y1 = parseDouble(s3[1]);
                double a = dmsToRad(parseDouble(s3[2]));
                double x2 = parseDouble(s3[3]);
                double y2 = parseDouble(s3[4]);
                double b = dmsToRad(parseDouble(s3[5]));
                x = x1 / tan(b) + x2 / tan(a) + (y2 - y1);
                x = x / (1/tan(b)+1/tan(a));
                y = y1 / tan(b) + y2 / tan(a) - (x2 - x1);
                y = y / (1/tan(b)+1/tan(a));
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"��������ȷ�����ݣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        else
        {
            //�󷽽���
            try {
                String s1 = text1.getText();
                String s2 = s1.strip();
                String s4 = s2.replaceAll("��",",");
                String[] s3 = s4.split(",");
                double xa = parseDouble(s3[0]);
                double ya = parseDouble(s3[1]);
                double xc = parseDouble(s3[2]);
                double yc = parseDouble(s3[3]);
                double xb = parseDouble(s3[4]);
                double yb = parseDouble(s3[5]);
                double A = dmsToRad(parseDouble(s3[6]));
                double B = dmsToRad(parseDouble(s3[7]));
                double a = (ya - yc) / tan(A) + (xa - xc);
                double b = (xa - xc) / tan(A) - (ya - yc);
                double c = (xb - xc) / tan(B) - (yb - yc);
                double d = (yb - yc) / tan(B) - (xb - xc);
                double k = (a + d) / (b + c);
                double dx = (a - b * k) / (1 + k * k);
                double m = a - b * k;
                double n = c * k - d;
                x = xc + dx;
                y = yc + k * dx;

            } catch (Exception e) {
                JOptionPane.showMessageDialog(null,"��������ȷ�����ݣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
    }
}

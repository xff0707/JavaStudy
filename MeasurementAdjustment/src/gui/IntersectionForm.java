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
 * 交会定向窗体类
 * @version V1.0
 * @author xff07
 */
public class IntersectionForm extends JFrame {
    private JButton backBut, calculateBut, cleanBut;
    private JLayeredPane jLayeredPane= new JLayeredPane();
    private JTextField text1, text2, text3;
    private JRadioButton forward, rear;
    private ButtonGroup type;
    private boolean flag = true;//默认前方交会
    private JLabel l1, l2, l3, l4;
    private String[] helpText;
    private double x,y;
    private DecimalFormat df = new DecimalFormat();

    /**
     * 创建一个交会定点窗体
     * @throws HeadlessException
     */
    public IntersectionForm() throws HeadlessException {
        init();
    }

    /**
     * 初始化
     */
    private void init()
    {
        wedgetInit();

        setTitle("交会定向");
        setSize(640,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayeredPane(jLayeredPane);
    }

    /**
     * 组件初始化
     */
    private void wedgetInit()
    {
        //文本框初始化
        text1 = new JTextField();
        text1.setBounds(30,30,580,30);
        text2 = new JTextField();
        text2.setBounds(330,80,200,40);
        text3 = new JTextField();
        text3.setBounds(330,150,200,40);
        jLayeredPane.add(text1);
        jLayeredPane.add(text2);
        jLayeredPane.add(text3);

        //按钮初始化
        calculateBut = new JButton("计算");
        calculateBut.setBounds(200,70,90,30);
        cleanBut = new JButton("清除");
        cleanBut.setBounds(200,110,90,30);
        backBut = new JButton("返回");
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



        //单选框
        forward = new JRadioButton("前方交会");
        forward.setBounds(30,100,90,30);
        forward.setSelected(true);
        rear = new JRadioButton("后方交会");
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

        //标签
        helpText = new String[2];
        helpText[0] = "请依次输入A点和B点的x坐标、y坐标、观测角，用英文逗号隔开。角度格式DD.mmss。(如：x1,y1,a,x2,y2,b)";
        helpText[1] = "请依次输入已知点坐标和观测的2个角度,用英文逗号隔开。角度格式DD.mmss。(如：xA,yA,xC,yC,xB,yB,A,B)";
        l1 = new JLabel(helpText[0]);
        l1.setBounds(20,10,580,20);
        l2 = new JLabel("请选择计算方式：");
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
     * 返回退出按钮对象，用于提供返回方法事件监听
     * @return 返回按钮对象
     */
    public JButton getBackBut() {
        return backBut;
    }

    /**
     * 用于计算交会
     */
    private void calculate()
    {
        if (flag)
        {
            //前方交会
            try {
                String s1 = text1.getText();
                String s2 = s1.strip();
                String s4 = s2.replaceAll("，",",");
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
                JOptionPane.showMessageDialog(null,"请输入正确的数据！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
        else
        {
            //后方交会
            try {
                String s1 = text1.getText();
                String s2 = s1.strip();
                String s4 = s2.replaceAll("，",",");
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
                JOptionPane.showMessageDialog(null,"请输入正确的数据！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                return;
            }

        }
    }
}

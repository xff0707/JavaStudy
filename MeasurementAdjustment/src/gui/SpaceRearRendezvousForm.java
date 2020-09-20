package gui;

import line.Point;
import line.Point3d;
import line.SpaceRear;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.HashMap;

import static tools.FileTools.*;
import static tools.DMSChange.radToDMSStr;

/**
 * 空间后方交会窗体类
 * @version V1.0
 * @author xff07
 */
public class SpaceRearRendezvousForm extends JFrame {
    private JLayeredPane jLayeredPane = new JLayeredPane();
    private JLabel l0, l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11;
    private JTextField text1, text2, text3, text4, text5, text6, text7, text8, text9;
    private JTextArea text;
    private JScrollPane jScrollBar;
    private JButton openBut, calculateBut, saveBut, cleanBut, backBut;
    private StringBuilder sb;
    private SpaceRear spaceRear;
    private HashMap<String,Double> calu;
    private String helptext;
    DecimalFormat df = new DecimalFormat();

    public SpaceRearRendezvousForm() throws HeadlessException {
        init();
    }

    /**
     * 返回输出按钮对象，用于提供返回方法事件监听
     * @return 返回按钮对象
     */
    public JButton getBackBut() {
        return backBut;
    }

    /**
     * 初始化
     */
    private void init(){
        wedgetInit();


        setTitle("空间后方交会");
        setSize(640,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayeredPane(jLayeredPane);
    }


    /**
     * 控件初始化
     */
    private void wedgetInit(){
        //文本框初始化
        text1 = new JTextField();
        text1.setText("153.24");
        text2 = new JTextField();
        text2.setText("50000");
        text3 = new JTextField();
        text3.setText("0.000001");
        text4 = new JTextField();
        text5 = new JTextField();
        text6 = new JTextField();
        text7 = new JTextField();
        text8 = new JTextField();
        text9 = new JTextField();
        text1.setBounds(100,30,90,30);
        text2.setBounds(100,60,90,30);
        text3.setBounds(100,90,90,30);
        text4.setBounds(30,160,90,30);
        text5.setBounds(30,190,90,30);
        text6.setBounds(30,220,90,30);
        text7.setBounds(30,250,90,30);
        text8.setBounds(30,280,90,30);
        text9.setBounds(30,310,90,30);


        text = new JTextArea();
        helptext = "----------数据格式----------\n\n" +
                "x,y,X,Y,Z                  -已知像点坐标和地面点坐标\n\n" +
                "注意:坐标之间用逗号隔开\n" +
                "--------------------------------";
        text.setText(helptext);

        jLayeredPane.add(text1);
        jLayeredPane.add(text2);
        jLayeredPane.add(text3);
        jLayeredPane.add(text4);
        jLayeredPane.add(text5);
        jLayeredPane.add(text6);
        jLayeredPane.add(text7);
        jLayeredPane.add(text8);
        jLayeredPane.add(text9);
        jLayeredPane.add(text);

        //标签初始化
        l0 = new JLabel("参数：");
        l1 = new JLabel("摄影机主距(mm)");
        l2 = new JLabel("摄影比例尺分母");
        l3 = new JLabel("限差");
        l4 = new JLabel("计算结果：");
        l5 = new JLabel("Xs=");
        l6 = new JLabel("Ys=");
        l7 = new JLabel("Zs=");
        l8 = new JLabel("φ=");
        l9 = new JLabel("ω=");
        l10 = new JLabel("κ=");
        l0.setBounds(10,10,90,20);
        l1.setBounds(10,30,90,30);
        l2.setBounds(10,60,90,30);
        l3.setBounds(10,90,90,30);
        l4.setBounds(10,130,90,30);
        l5.setBounds(10,160,90,30);
        l6.setBounds(10,190,90,30);
        l7.setBounds(10,220,90,30);
        l8.setBounds(10,250,90,30);
        l9.setBounds(10,280,90,30);
        l10.setBounds(10,310,90,30);

        jLayeredPane.add(l0);
        jLayeredPane.add(l1);
        jLayeredPane.add(l2);
        jLayeredPane.add(l3);
        jLayeredPane.add(l4);
        jLayeredPane.add(l5);
        jLayeredPane.add(l6);
        jLayeredPane.add(l7);
        jLayeredPane.add(l8);
        jLayeredPane.add(l9);
        jLayeredPane.add(l10);

        //滚动条初始化
        jScrollBar = new JScrollPane(text);
        jScrollBar.setBounds(200,15,410,334);
        jLayeredPane.add(jScrollBar);


        //按钮初始化
        //打开文件
        openBut = new JButton("打开");
        openBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    String openFilePath = selectFile();
                    File f = new File(openFilePath);
                    sb = new StringBuilder();
                    text.setText("\n已选择文件："+openFilePath +"\n");
                    BufferedReader bufr = new BufferedReader(new FileReader(f));
                    String s = null;
                    while ((s=bufr.readLine())!=null)
                    {
                        sb.append(s+"\n");
                        text.append(s+"\n");
                    }
                    text.append("------------------------------------------------"+"\n");
                } catch (IOException ex) {
                    //JOptionPane.showMessageDialog(null,"文件打开失败！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                }

                try{
                    //读取数据进行处理
                    String s0 = sb.toString();
                    String s1 = s0.replaceAll("\n",",");
                    String s2 = s1.replaceAll(",+",",");
                    String s3 = s2.strip();
                    String[] s4 = s3.split(",");
                    Double[] data = new Double[s4.length];
                    for (int j=0;j<s4.length;j++)
                    {
                        data[j] = Double.valueOf(s4[j]);
                    }

                    spaceRear = new SpaceRear(new Point(data[0],data[1]),new Point3d(data[2],data[3],data[4]),Double.valueOf(text1.getText()),Double.valueOf(text2.getText()),Double.valueOf(text3.getText()));
                    for (int i = 0; i < (int)(s4.length/5)-1; i++) {
                        spaceRear.add(new Point(data[5+i*5],data[6+i*5]),new Point3d(data[7+i*5],data[8+i*5],data[9+i*5]));
                    }
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"数据格式错误！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                    return;
                }
                calculateBut.setEnabled(true);


            }
        });

        //计算
        calculateBut = new JButton("计算");
        calculateBut.setEnabled(false);
        calculateBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(calculateBut.isEnabled()))
                {
                    return;
                }


                try {
                    calu = spaceRear.calculate();
                }
                catch (Exception e1)
                {
                    JOptionPane.showMessageDialog(null,"计算错误！请输入正确的数据","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    e1.printStackTrace();
                    return;
                }
                df.setMaximumFractionDigits(2);
                text4.setText(df.format(calu.get("Xs")));
                text5.setText(df.format(calu.get("Ys")));
                text6.setText(df.format(calu.get("Zs")));
                text7.setText(radToDMSStr(calu.get("φ")));
                text8.setText(radToDMSStr(calu.get("ω")));
                text9.setText(radToDMSStr(calu.get("κ")));


                text.append("\n单位权中误差：±"+df.format(calu.get("m0")*1000)+"mm");
                text.append("\nXs的中误差：±"+df.format(calu.get("mXs")*1000)+"mm");
                text.append("\nYs的中误差：±"+df.format(calu.get("mYs")*1000)+"mm");
                text.append("\nZs的中误差：±"+df.format(calu.get("mZs")*1000)+"mm");
                df.setMaximumFractionDigits(5);
                text.append("\nφ的中误差：±"+df.format(calu.get("mφ"))+"″");
                text.append("\nω的中误差：±"+df.format(calu.get("mω"))+"″");
                text.append("\nκ的中误差：±"+df.format(calu.get("mκ"))+"″");
                //saveBut.setEnabled(true);
            }
        });


        /*
        //保存
        saveBut = new JButton("保存");
        saveBut.setEnabled(false);
        saveBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(saveBut.isEnabled()))
                {
                    return;
                }
                try {
                    String savePath = selectFile();
                } catch (FileNotFoundException ex) {
                    return;
                }
            }
        });

         */

        //清除
        cleanBut = new JButton("清除");
        cleanBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                text.setText(helptext);
            }
        });


        //返回按键
        backBut = new JButton("返回");



        openBut.setBounds(125,175,70,28);
        calculateBut.setBounds(125,215,70,28);
        //saveBut.setBounds(125,235,70,28);
        cleanBut.setBounds(125,255,70,28);
        backBut.setBounds(125,295,70,28);

        //添加按键到面板中
        jLayeredPane.add(openBut);
        jLayeredPane.add(calculateBut);
        //jLayeredPane.add(saveBut);
        jLayeredPane.add(cleanBut);
        jLayeredPane.add(backBut);

    }

}

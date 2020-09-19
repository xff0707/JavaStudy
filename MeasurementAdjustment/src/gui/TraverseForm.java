package gui;

import line.CloseConductor;
import line.CompositeConductor;
import line.Point;
import line.Traverse;

import javax.swing.*;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;

import static tools.FileTools.*;

public class TraverseForm extends JFrame {
    private JButton openFileBut, calculateBut, saveBut, backBut;
    private JLayeredPane jLayeredPane = new JLayeredPane();
    private JTextArea text;
    private String openFilePath, saveFilePath;
    private Traverse traverse;
    private CompositeConductor compositeConductor;
    private StringBuilder sb;
    private ArrayList<Point> ps;
    private BufferedWriter bufr;
    private JRadioButton spurTraverse, chimeTraverse, closeTraverse;
    private ButtonGroup traverseType;
    private int calcType = 0;
    private String[] helptext = new String[3];
    private JScrollPane jsp;
    private CloseConductor closeConductor;

    public JButton getBackBut() {
        return backBut;
    }

    public TraverseForm() throws HeadlessException {
        init();
    }

    private void init()
    {
        wedgetinit();

        setTitle("导线计算");
        setSize(640,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayeredPane(jLayeredPane);
    }

    //控件初始化
    private void wedgetinit()
    {
        //按钮初始化
        //打开文件按钮
        openFileBut = new JButton("打开文件");
        openFileBut.setBounds(30,30,90,40);
        jLayeredPane.add(openFileBut);
        openFileBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                try {
                    openFilePath = openFile();
                } catch (FileNotFoundException ex) {
                    return;
                }
                try{
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
                }
                catch (FileNotFoundException ex1) {
                    JOptionPane.showMessageDialog(null,"文件不存在！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                    } catch (IOException ex2) {
                    JOptionPane.showMessageDialog(null,"文件读取失败！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                try{
                    //读取数据进行处理
                    String s0 = sb.toString();
                    String s1 = s0.replaceAll("\n",",");
                    String s2 = s1.replaceAll(",+",",");
                    String s3 = s2.strip();
                    String[] s4 = s3.split(",");
                    int n = Integer.valueOf(s4[0]);
                    Double[] data = new Double[s4.length];
                    for (int j=0;j<s4.length;j++)
                    {
                        data[j] = Double.valueOf(s4[j]);
                    }
                    //支导线
                    if (calcType == 0){
                        traverse = new Traverse(new Point(data[1],data[2]),new Point(data[3],data[4]));
                        for (int i=0;i<n+1;i++)
                        {
                            traverse.add(data[5+i],data[5+n+i]);
                        }
                    }
                    //附和导线
                    else if (calcType == 1){
                        compositeConductor = new CompositeConductor(new Point(data[1],data[2]),new Point(data[3],data[4]), new Point(data[5],data[6]), new Point(data[7],data[8]));
                        for (int i = 0; i <= n; i++) {
                            compositeConductor.addAzi(data[9+i]);
                            compositeConductor.addLong(data[11+n+i]);
                        }
                        compositeConductor.addAzi(data[10+n]);



                    }
                    //闭合导线
                    else {
                        closeConductor = new CloseConductor(new Point(data[1],data[2]),data[3]);
                        for (int i = 0; i <= n; i++) {
                            closeConductor.addAzi(data[4+i]);
                            closeConductor.addLong(data[5+n+i]);
                        }

                    }

                }
                catch (Exception ex3)
                {
                    JOptionPane.showMessageDialog(null,"数据格式错误！请选择正确数据格式的文件","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                calculateBut.setEnabled(true);
            }
        });

        //计算按钮
        calculateBut = new JButton("计算");
        calculateBut.setBounds(30,90,90,40);
        calculateBut.setEnabled(false);
        jLayeredPane.add(calculateBut);
        calculateBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(calculateBut.isEnabled())) return;
                //支导线
                if (calcType==0) {
                    ps = traverse.getPoints();
                    text.append("以下为支导线计算坐标，前两行为起点坐标\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                }
                //附和导线
                else if (calcType==1){
                    ps = compositeConductor.adjustment();
                    //ps = traverse.getPoints();
                    text.append("以下为附和导线计算坐标，前两行为起点坐标\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    HashMap<String,Double> f = compositeConductor.getF();
                    text.append("fβ="+df.format(f.get("fβ")*206265)+"″\n");
                    text.append("fβ容=±"+df.format(f.get("fβ容"))+"″\n");
                    text.append("fx="+df.format(f.get("fx"))+"m\n");
                    text.append("fy="+df.format(f.get("fy"))+"m\n");
                    text.append("f=±"+df.format(f.get("f"))+"m\n");
                    text.append("K="+df.format(f.get("K"))+"=1/"+(int)(1/f.get("K"))+"\n");

                }
                //闭合导线
                else {

                    ps = closeConductor.adjustment();
                    text.append("以下为闭合导线计算坐标，前两行为起点坐标\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);

                    HashMap<String,Double> f = closeConductor.getF();
                    text.append("fβ="+df.format(f.get("fβ")*206265)+"″\n");
                    text.append("fβ容=±"+df.format(f.get("fβ容"))+"″\n");
                    text.append("fx="+df.format(f.get("fx"))+"m\n");
                    text.append("fy="+df.format(f.get("fy"))+"m\n");
                    text.append("f=±"+df.format(f.get("f"))+"m\n");
                    text.append("K="+df.format(f.get("K"))+"=1/"+(int)(1/f.get("K"))+"\n");



                }


                calculateBut.setEnabled(false);
                saveBut.setEnabled(true);


            }
        });

        //保存按钮
        saveBut = new JButton("保存");
        saveBut.setBounds(30,150,90,40);
        saveBut.setEnabled(false);
        jLayeredPane.add(saveBut);
        saveBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (saveBut.isEnabled()){
                    return;
                }
                try {
                    saveFilePath = saveFile();
                } catch (FileNotFoundException ex) {
                    return;
                }
                try{
                    ps.remove(0);
                    ps.remove(0);
                    bufr = new BufferedWriter(new FileWriter(saveFilePath));
                    for (Point p: ps
                         ) {
                        bufr.write(p.toString());
                    }
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(null,"文件写入失败！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                finally {
                    try{
                        if (bufr!=null)
                            bufr.close();
                    }
                    catch (IOException ex)
                    {
                        JOptionPane.showMessageDialog(null,"文件关闭失败！","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                text.append("---------------------------");
                text.append("\n计算结果已保存至"+saveFilePath+"\n");

            }
        });


        //返回按钮
        backBut = new JButton("返回");
        backBut.setBounds(30,210,90,40);
        jLayeredPane.add(backBut);


        //帮助文档初始化
        helptext[0] = "\n----------支导线计算---------\n"
                +"       请打开以下数据格式的文本文件\n"
                +"n                                               ---待定点数\n"
                +"X1,Y1,X2,Y2                              ---已知数据\n"
                +"β1,β2,β3...                                ---观测角值\n"
                +"S1,S2,S3...                               ---观测边长\n"
                +"     注意，角度一律使用DD.mmss格式\n"
                +"----------------------------------\n";

        helptext[1] = "\n--------附和导线计算---------\n"
                +"       请打开以下数据格式的文本文件\n"
                +"n                                               ---待定点数\n"
                +"X1,Y1,X2,Y2,X3,Y3,X4,Y4         ---已知数据\n"
                +"β1,β2,β3...                                ---观测角值\n"
                +"S1,S2,S3...                               ---观测边长\n"
                +"     注意，角度一律使用DD.mmss格式\n"
                +"----------------------------------\n";

        helptext[2] = "\n--------闭合导线计算---------\n"
                +"       请打开以下数据格式的文本文件\n"
                +"n                                               ---待定点数\n"
                +"X1,Y1,α0                                   ---已知数据\n"
                +"β1,β2,β3...                                ---观测角值\n"
                +"S1,S2,S3...                               ---观测边长\n"
                +"     注意，角度一律使用DD.mmss格式\n"
                +"----------------------------------\n";


        //文本框初始化
        text = new JTextArea();
        text.setBounds(140,15,470,334);
        text.setLineWrap(true);
        //jLayeredPane.add(text);
        text.setText(helptext[calcType]);


        //滚动条初始化
        jsp = new JScrollPane(text);
        jsp.setBounds(140,15,470,334);
        jLayeredPane.add(jsp);


        //单选框初始化
        traverseType = new ButtonGroup();
        spurTraverse = new JRadioButton("支导线");
        chimeTraverse = new JRadioButton("附和导线");
        closeTraverse = new JRadioButton("闭合导线");
        spurTraverse.setSelected(true);//默认支导线
        spurTraverse.setBounds(30,270,90,20);
        chimeTraverse.setBounds(30,300,90,20);
        closeTraverse.setBounds(30,330,90,20);
        traverseType.add(spurTraverse);
        traverseType.add(chimeTraverse);
        traverseType.add(closeTraverse);
        jLayeredPane.add(spurTraverse);//添加到面板中
        jLayeredPane.add(chimeTraverse);
        jLayeredPane.add(closeTraverse);
        spurTraverse.addActionListener(e -> {
            calcType = 0;
            text.setText(helptext[calcType]);
            calculateBut.setEnabled(false);
            saveBut.setEnabled(false);
        });
        chimeTraverse.addActionListener(e -> {
            calcType = 1;
            text.setText(helptext[calcType]);
            calculateBut.setEnabled(false);
            saveBut.setEnabled(false);
        });
        closeTraverse.addActionListener(e -> {
            calcType = 2;
            text.setText(helptext[calcType]);
            calculateBut.setEnabled(false);
            saveBut.setEnabled(false);
        });

    }

}
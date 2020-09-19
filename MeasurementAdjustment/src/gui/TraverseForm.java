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

        setTitle("���߼���");
        setSize(640,400);
        setLocationRelativeTo(null);
        setResizable(false);

        setLayeredPane(jLayeredPane);
    }

    //�ؼ���ʼ��
    private void wedgetinit()
    {
        //��ť��ʼ��
        //���ļ���ť
        openFileBut = new JButton("���ļ�");
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
                    text.setText("\n��ѡ���ļ���"+openFilePath +"\n");
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
                    JOptionPane.showMessageDialog(null,"�ļ������ڣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                    } catch (IOException ex2) {
                    JOptionPane.showMessageDialog(null,"�ļ���ȡʧ�ܣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                    }
                try{
                    //��ȡ���ݽ��д���
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
                    //֧����
                    if (calcType == 0){
                        traverse = new Traverse(new Point(data[1],data[2]),new Point(data[3],data[4]));
                        for (int i=0;i<n+1;i++)
                        {
                            traverse.add(data[5+i],data[5+n+i]);
                        }
                    }
                    //���͵���
                    else if (calcType == 1){
                        compositeConductor = new CompositeConductor(new Point(data[1],data[2]),new Point(data[3],data[4]), new Point(data[5],data[6]), new Point(data[7],data[8]));
                        for (int i = 0; i <= n; i++) {
                            compositeConductor.addAzi(data[9+i]);
                            compositeConductor.addLong(data[11+n+i]);
                        }
                        compositeConductor.addAzi(data[10+n]);



                    }
                    //�պϵ���
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
                    JOptionPane.showMessageDialog(null,"���ݸ�ʽ������ѡ����ȷ���ݸ�ʽ���ļ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                calculateBut.setEnabled(true);
            }
        });

        //���㰴ť
        calculateBut = new JButton("����");
        calculateBut.setBounds(30,90,90,40);
        calculateBut.setEnabled(false);
        jLayeredPane.add(calculateBut);
        calculateBut.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (!(calculateBut.isEnabled())) return;
                //֧����
                if (calcType==0) {
                    ps = traverse.getPoints();
                    text.append("����Ϊ֧���߼������꣬ǰ����Ϊ�������\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                }
                //���͵���
                else if (calcType==1){
                    ps = compositeConductor.adjustment();
                    //ps = traverse.getPoints();
                    text.append("����Ϊ���͵��߼������꣬ǰ����Ϊ�������\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);
                    HashMap<String,Double> f = compositeConductor.getF();
                    text.append("f��="+df.format(f.get("f��")*206265)+"��\n");
                    text.append("f����=��"+df.format(f.get("f����"))+"��\n");
                    text.append("fx="+df.format(f.get("fx"))+"m\n");
                    text.append("fy="+df.format(f.get("fy"))+"m\n");
                    text.append("f=��"+df.format(f.get("f"))+"m\n");
                    text.append("K="+df.format(f.get("K"))+"=1/"+(int)(1/f.get("K"))+"\n");

                }
                //�պϵ���
                else {

                    ps = closeConductor.adjustment();
                    text.append("����Ϊ�պϵ��߼������꣬ǰ����Ϊ�������\n");
                    for (Point p : ps) {
                        text.append(p.toString());
                    }
                    DecimalFormat df = new DecimalFormat();
                    df.setMaximumFractionDigits(2);

                    HashMap<String,Double> f = closeConductor.getF();
                    text.append("f��="+df.format(f.get("f��")*206265)+"��\n");
                    text.append("f����=��"+df.format(f.get("f����"))+"��\n");
                    text.append("fx="+df.format(f.get("fx"))+"m\n");
                    text.append("fy="+df.format(f.get("fy"))+"m\n");
                    text.append("f=��"+df.format(f.get("f"))+"m\n");
                    text.append("K="+df.format(f.get("K"))+"=1/"+(int)(1/f.get("K"))+"\n");



                }


                calculateBut.setEnabled(false);
                saveBut.setEnabled(true);


            }
        });

        //���水ť
        saveBut = new JButton("����");
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
                    JOptionPane.showMessageDialog(null,"�ļ�д��ʧ�ܣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                    return;
                }
                finally {
                    try{
                        if (bufr!=null)
                            bufr.close();
                    }
                    catch (IOException ex)
                    {
                        JOptionPane.showMessageDialog(null,"�ļ��ر�ʧ�ܣ�","ERROR_MESSAGE",JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                }
                text.append("---------------------------");
                text.append("\n�������ѱ�����"+saveFilePath+"\n");

            }
        });


        //���ذ�ť
        backBut = new JButton("����");
        backBut.setBounds(30,210,90,40);
        jLayeredPane.add(backBut);


        //�����ĵ���ʼ��
        helptext[0] = "\n----------֧���߼���---------\n"
                +"       ����������ݸ�ʽ���ı��ļ�\n"
                +"n                                               ---��������\n"
                +"X1,Y1,X2,Y2                              ---��֪����\n"
                +"��1,��2,��3...                                ---�۲��ֵ\n"
                +"S1,S2,S3...                               ---�۲�߳�\n"
                +"     ע�⣬�Ƕ�һ��ʹ��DD.mmss��ʽ\n"
                +"----------------------------------\n";

        helptext[1] = "\n--------���͵��߼���---------\n"
                +"       ����������ݸ�ʽ���ı��ļ�\n"
                +"n                                               ---��������\n"
                +"X1,Y1,X2,Y2,X3,Y3,X4,Y4         ---��֪����\n"
                +"��1,��2,��3...                                ---�۲��ֵ\n"
                +"S1,S2,S3...                               ---�۲�߳�\n"
                +"     ע�⣬�Ƕ�һ��ʹ��DD.mmss��ʽ\n"
                +"----------------------------------\n";

        helptext[2] = "\n--------�պϵ��߼���---------\n"
                +"       ����������ݸ�ʽ���ı��ļ�\n"
                +"n                                               ---��������\n"
                +"X1,Y1,��0                                   ---��֪����\n"
                +"��1,��2,��3...                                ---�۲��ֵ\n"
                +"S1,S2,S3...                               ---�۲�߳�\n"
                +"     ע�⣬�Ƕ�һ��ʹ��DD.mmss��ʽ\n"
                +"----------------------------------\n";


        //�ı����ʼ��
        text = new JTextArea();
        text.setBounds(140,15,470,334);
        text.setLineWrap(true);
        //jLayeredPane.add(text);
        text.setText(helptext[calcType]);


        //��������ʼ��
        jsp = new JScrollPane(text);
        jsp.setBounds(140,15,470,334);
        jLayeredPane.add(jsp);


        //��ѡ���ʼ��
        traverseType = new ButtonGroup();
        spurTraverse = new JRadioButton("֧����");
        chimeTraverse = new JRadioButton("���͵���");
        closeTraverse = new JRadioButton("�պϵ���");
        spurTraverse.setSelected(true);//Ĭ��֧����
        spurTraverse.setBounds(30,270,90,20);
        chimeTraverse.setBounds(30,300,90,20);
        closeTraverse.setBounds(30,330,90,20);
        traverseType.add(spurTraverse);
        traverseType.add(chimeTraverse);
        traverseType.add(closeTraverse);
        jLayeredPane.add(spurTraverse);//��ӵ������
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
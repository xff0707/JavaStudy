package gui;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.ArrayList;

import Line.Point;
import Line.Traverse;

public class FromTraverse {
    private JPanel panel1;
    private JTextArea textArea1;
    private JButton Button1;
    private JButton Button2;
    private JButton Button3;
    private JScrollBar scrollBar1;
    Traverse t;

    public JPanel getPanel1() {
        return panel1;
    }

    public JTextArea getTextArea1() {
        return textArea1;
    }

    public FromTraverse()
    {

        init();
        Button1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JFileChooser jfs = new JFileChooser();
                FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件/txt","txt");
                jfs.setFileFilter(filter);
                int returnVal = jfs.showOpenDialog(null);
                if (returnVal == JFileChooser.APPROVE_OPTION)
                {
                    File f = new File(jfs.getSelectedFile().getParent()+jfs.getSelectedFile().getName());
                    StringBuilder sb = new StringBuilder();
                    try {
                        textArea1.append("已打开文件："+jfs.getSelectedFile().getParent()+jfs.getSelectedFile().getName()+"\n");
                        BufferedReader bufr = new BufferedReader(new FileReader(f));
                        String s = null;
                        while ((s=bufr.readLine())!=null)
                        {
                            sb.append(s);
                            textArea1.append(s+"\n");
                        }
                        textArea1.append("------------------------------------------------"+"\n");
                    } catch (FileNotFoundException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                    String s1 = sb.toString();
                    String s2 = s1.replace("\r\n",",");
                    String s3 = s2.strip();
                    String[] s4 = s3.split(",");
                    int n = Integer.valueOf(s4[0]);
                    Double[] d = new Double[s4.length];
                    int j = 0;
                    for (;j<s4.length;j++)
                    {
                        d[j] = Double.valueOf(s4[j]);
                    }
                    /*
                    for (String s: s4)
                    {
                        d[j++]=Double.valueOf(s);
                    }

                     */
                    //Traverse t = new Traverse(new Point(Double.valueOf(s4[1]),Double.valueOf(s4[2])),new Point(Double.valueOf(s4[3]),Double.valueOf(s4[4])));
                    t = new Traverse(new Point(d[1],d[2]),new Point(d[3],d[4]));
                    for (int i=0;i<n;i++)
                    {
                        t.add(d[5+i],d[5+n+i]);
                    }
                }
            }
        });
        Button2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {

                ArrayList<Point> ps = t.getPoints();
                //System.out.println(p);
                for (Point p : ps)
                {
                    textArea1.append(p.toString());
                }

            }
        });
        Button3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //textArea1.setText("");
                init();
            }
        });
    }

    private void init()
    {

        textArea1.setText("------------------------------------------------"+"\n");
        textArea1.append("请打开按照以下格式保存的txt文本文件"+"\n");
        textArea1.append("第一行：未知点个数n"+"\n");
        textArea1.append("第二行：已知点坐标x1,y1,x2,y2"+"\n");
        textArea1.append("第三行：观测左角(右角加负号),用逗号隔开"+"\n");
        textArea1.append("第四行：观测的距离值,用逗号隔开"+"\n");
        textArea1.append("------------------------------------------------"+"\n");

    }
}

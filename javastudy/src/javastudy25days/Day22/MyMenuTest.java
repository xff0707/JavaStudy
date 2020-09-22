package javastudy25days.Day22;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.*;

public class MyMenuTest {
    private Frame f;
    private MenuBar bar;
    private Menu fileMenu;
    private MenuItem openItem,saveItem,closeItem;
    private FileDialog openDia,saveDia;
    private TextArea ta;
    private File file;

    public MyMenuTest() {
        init();
    }

    public void init() {
        f = new Frame("my window");
        f.setBounds(300, 100, 600, 700);
        //f.setLayout(new FlowLayout());

        bar = new MenuBar();

        ta = new TextArea();

        fileMenu = new Menu("文件");

        openItem = new MenuItem("打开");
        saveItem = new MenuItem("保存");
        closeItem = new MenuItem("退出");

        fileMenu.add(openItem);
        fileMenu.add(saveItem);
        fileMenu.add(closeItem);
        bar.add(fileMenu);

        f.setMenuBar(bar);

        openDia = new FileDialog(f,"我要打开",FileDialog.LOAD);
        saveDia = new FileDialog(f,"我要保存",FileDialog.SAVE);

        f.add(ta);
        myEvent();

        f.setVisible(true);
    }

    private void myEvent() {
        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        closeItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        openItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                openDia.setVisible(true);
                String dirpath = openDia.getDirectory();
                String fileName = openDia.getFile();
                //System.out.println(dirpath+"..."+filepath);
                if ((dirpath==null || fileName==null))
                    return;

                ta.setText("");
                File file = new File(dirpath,fileName);

                try
                {
                    BufferedReader bufr = new BufferedReader(new FileReader(file));

                    String line = null;

                    while ((line = bufr.readLine())!=null)
                    {
                        ta.append(line+"\n");
                    }
                    bufr.close();
                }
                catch (IOException e1)
                {
                    new RuntimeException("读取失败");
                }
            }
        });

        saveItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (file==null)
                {
                    saveDia.setVisible(true);

                    String dirpath = saveDia.getDirectory();
                    String fileName = saveDia.getFile();
                    if ((dirpath==null || fileName==null))
                        return;
                    file = new File(dirpath,fileName);
                }

                try
                {
                    BufferedWriter bufw = new BufferedWriter(new FileWriter(file));

                    String text = ta.getText();

                    bufw.write(text);
                    //bufw.flush();
                    bufw.close();
                }
                catch (IOException e1)
                {
                    new RuntimeException("读取失败");
                }

            }
        });
    }

    public static void main(String[] args) {
        new MyMenuTest();
    }
}

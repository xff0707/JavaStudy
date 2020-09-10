package playmyself;

import javax.swing.*;
import java.awt.event.*;

public class From1 {
    private JTextArea textArea1;
    private JButton button1;
    private JButton button2;
    private JTextArea textArea2;
    private JPanel jpanel;

    public From1() {
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run1();
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                run2();
            }
        });
        textArea1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                int code = e.getKeyCode();
                if (!(code>=KeyEvent.VK_0 && code<=KeyEvent.VK_9))
                {
                    //System.out.println("非法");
                    e.consume();//失效了，貌似是JTextArea的原因
                }
            }
        });

    }
    private void run1()
    {
        if ("".equals(textArea1.getText()))
           return;
        textArea2.setLineWrap(true);
        textArea2.setText("");
        String s = textArea1.getText();
        int i = Integer.parseInt(s);
        double si = Math.PI*i*i;
        textArea2.append("面积=Π×"+i+"^2="+Double.toString(si));
    }
    private void run2()
    {
        textArea1.setText("");
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("GUItext");
        frame.setContentPane(new From1().jpanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,500);
        frame.setLocation(200,200);
        frame.pack();
        frame.setVisible(true);
    }
}

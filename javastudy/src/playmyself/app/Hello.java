package playmyself.app;


import javax.swing.*;
import java.applet.Applet;

public class Hello extends Applet {

    @Override
    public void init() {
        JLabel label = new JLabel("别扰乱我思绪");
        add(label);
    }
}

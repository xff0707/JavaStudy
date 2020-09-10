package playmyself;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MyWin extends WindowAdapter
{
    public void windowClosing(WindowEvent e)
    {
        System.out.println("windows Closing");
        System.exit(0);
    }
}
package tools;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileTools {
    /*
    *����һ���Ի����ȡ�ļ��������ļ��ľ���·��
    *
    **/
    public static String openFile() throws FileNotFoundException {
        JFileChooser jfs = new JFileChooser();
        jfs.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("�ı��ļ�/txt","txt");
        jfs.setFileFilter(filter);
        int returnVal = jfs.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            return jfs.getSelectedFile().getParent()+jfs.getSelectedFile().getName();
        }
        else
            throw new FileNotFoundException();
    }

    public static String saveFile() throws FileNotFoundException {
        JFileChooser jfs = new JFileChooser();
        jfs.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("�ı��ļ�/txt","txt");
        jfs.setFileFilter(filter);
        int returnVal = jfs.showOpenDialog(null);
        if (returnVal == JFileChooser.APPROVE_OPTION)
        {
            return jfs.getSelectedFile().getParent()+jfs.getSelectedFile().getName();
        }
        else
            throw new FileNotFoundException();
    }


}

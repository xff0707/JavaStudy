package tools;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;

public class FileTools {
    /*
    *弹出一个对话框读取文件，返回文件的绝对路径
    *
    **/
    public static String openFile() throws FileNotFoundException {
        JFileChooser jfs = new JFileChooser();
        jfs.setFileSelectionMode(JFileChooser.FILES_ONLY);
        FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件/txt","txt");
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
        FileNameExtensionFilter filter = new FileNameExtensionFilter("文本文件/txt","txt");
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

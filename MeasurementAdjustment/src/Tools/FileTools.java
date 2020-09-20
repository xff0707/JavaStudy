package tools;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
/**
 *用于对文件进行操作的工具类
 * @version V1.0
 * @author xff07
 */
public class FileTools {
    /**
     * 弹出一个对话框读取文件，返回文件的绝对路径
     * @return 所选文件的绝对路径
     * @throws FileNotFoundException
     */
    public static String selectFile() throws FileNotFoundException {
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

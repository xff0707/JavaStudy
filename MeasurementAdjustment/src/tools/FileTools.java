package tools;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.io.*;
/**
 *���ڶ��ļ����в����Ĺ�����
 * @version V1.0
 * @author xff07
 */
public class FileTools {
    /**
     * ����һ���Ի����ȡ�ļ��������ļ��ľ���·��
     * @return ��ѡ�ļ��ľ���·��
     * @throws FileNotFoundException
     */
    public static String selectFile() throws FileNotFoundException {
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

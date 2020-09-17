package Day19;

import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class LineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("myfile.txt");

        LineNumberReader lnr = new LineNumberReader(fr);

        String line = null;
        lnr.setLineNumber(100);
        while ((line=lnr.readLine())!=null)
        {
            System.out.println(lnr.getLineNumber()+":"+line);
        }

        lnr.close();
    }
}

//练习：模拟一个带行号的缓冲区对象。
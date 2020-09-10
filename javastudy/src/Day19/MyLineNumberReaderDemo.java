package Day19;


import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

class MyLineNumberReader //extends MyBufferedReader
{
    private Reader r;
    private int lineNumber;

    MyLineNumberReader(Reader r)
    {
        //super(r);
        this.r = r;
    }

    public void setLineNumber(int lineNumber)
    {
        this.lineNumber = lineNumber;
    }

    public int getLineNumber()
    {
        return lineNumber;
    }

    public String myReadLine() throws IOException {
        lineNumber++;
        StringBuilder sb = new StringBuilder();

        int ch = 0;

        while ((ch=r.read())!=-1)
        {
            if (ch=='\r')
                continue;
            if (ch=='\n')
                return sb.toString();
            else
                sb.append((char)ch);
        }
        if ((sb.length())!=0)
            return sb.toString();
        return null;
        //myReadLine();
    }
    public void myclose() throws IOException
    {
        r.close();
    }
}

public class MyLineNumberReaderDemo {
    public static void main(String[] args) throws IOException {
        FileReader fr = new FileReader("demo.txt");

        MyLineNumberReader mylnr = new MyLineNumberReader(fr);

        String line = null;
        mylnr.setLineNumber(100);
        while ((line=mylnr.myReadLine())!=null)
        {
            System.out.println(mylnr.getLineNumber()+":"+line);
        }

        mylnr.myclose();
    }
}

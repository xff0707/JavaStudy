package Day18;

import java.io.FileWriter;
import java.io.IOException;

/*
IO异常的处理方式

 */
public class FileWriterDemo2 {
    public static void main(String[] args)/*throws IOException*/
    {
        FileWriter fw = null;
        try
        {
            fw = new FileWriter("k:\\demo.txt");

            fw.write("Happy Birthday!");

        }
        catch(IOException e)
        {
            System.out.println("catch"+e.toString());
        }
        finally
        {

            try
            {
                if(fw!=null)
                    fw.close();
            }
            catch (IOException e)
            {
                System.out.println(e.toString());
            }
        }
    }
}

package Day21;

import java.io.*;

public class ObjectStreamDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        //writeObj();
        readObj();
    }

    public static void readObj() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("myfile//day21//obj.txt"));//一般后缀.object

        Person p =(Person)ois.readObject();

        System.out.println(p);

        ois.close();
    }


    public static void writeObj() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("myfile//day21//obj.txt"));

        oos.writeObject(new Person("lisi1",369));

        oos.close();
    }
}
























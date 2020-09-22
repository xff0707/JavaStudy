package javastudy25days.Day17;
/*
StaticImport 静态导入。

当类名重名时，需要指定具体的包名。
当方法重名时，指定具体所属的对象或者类。
 */
//导入的是Arrays这个类中的所有静态成员。
import java.util.Arrays;

import static java.util.Arrays.*;

public class StaticImport {
    public static void main(String[] args) {
        int[] arr = {1,3,5};
        Arrays.sort(arr);
        int index = binarySearch(arr,1);
        System.out.println(Arrays.toString(arr));
        System.out.println("index:"+index);
        
    }
}

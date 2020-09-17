package Day17;

import java.util.Arrays;
import java.util.List;

/*
Arrays：用于操作数组的工具类。
里面都是静态方法。


asList：将数组变成list集合

 */
public class ArraysDemo {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();

        /*
        int[] arr = {2,4,5};

        System.out.println(Arrays.toString(arr));

         */

        String[] arr = {"add","sdaf","sadd"};

        //把数组变成list集合有什么好处？
        /*
        可以使用集合中的思想和方法来操作数组中的元素

        注意：将数组变成集合，不可以使用集合的增删方法
        因为数组的长度是固定的。
        contains
        get
        indexOf()
        subList()

        如果你增删了。那么会发生UnsupportedOperationException
        不支持操作异常

        */
        List<String> list = Arrays.asList(arr);
        System.out.println("contains:"+list.contains("cc"));
        //list.add("qq");//UnsupportedOperationException
        System.out.println(list);


        //int[] nums = {2,4,5};//打印的是哈希值
        Integer[] nums = {2,4,5};

        List li = Arrays.asList(nums);
        /*
        如果数组中的元素都是对象，那么变成集合时，数组中的元素就直接转成集合中的元素。
        如果数组中的元素都是基本数据类型，那么会将该数组作为集合中的元素存在。

         */

        System.out.println(li);



        Integer[][] c = {{1,2,3},{5,6,7},{10,11,12}};
        System.out.println(Arrays.asList(c));


        long end = System.currentTimeMillis();
        System.out.println(end-start);
    }


}

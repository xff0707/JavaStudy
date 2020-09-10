package supplementary.api;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        /*
        Optional容器类（JDK1.8）
        这是一个可以为null的容器对象。如果值存在则isPresent()方法会返回true，调用get()方法会返回该对象
        of:
        为非null的值创建一个Optional
        ofNullable:
        为指定的值创建一个为非null的值创建一个Optional，如果指定的值为null，则返回一个空的Optional
        isPresent:
        如果值存在返回true，否则返回false
        get:
        如果Optional有值则将其返回，否则抛出NoSuchElementException
        ifPresent:
        如果Optional实例有值则为其调用consumer，否则不做处理
        orElse:
        如果有值则将其返回，否则返回指定的其他值。	orElse(T other)如果存在值，则返回该值，否则返回 other。
        orElseGet(Supplier<? extends T> supplier)如果存在值，则返回该值，否则返回供应函数产生的结果。
        orElseThrow()如果存在值，则返回该值，否则抛出 NoSuchElementException。
        map(Function<? super T,? extends U> mapper)	如果存在值，则返回Optional描述（就像by一样 ofNullable(T)）将给定映射函数应用于该值的结果，否则返回empty Optional。
        flatMap(Function<? super T,? extends Optional<? extends U>> mapper)	如果存在Optional值，则返回将给定的 -bearing映射函数应用于该值的结果，否则返回empty Optional。
        filter(Predicate<? super T> predicate)如果存在一个值，并且该值与给定的谓词匹配，则返回一个Optional描述值的描述，否则返回一个empty Optional。

        */


        //创建一个空的
        //Optional op = Optional.empty();
        //创建一个非空的
        Optional<String> op = Optional.of("bin");
        //创建一个可以为空的
        Optional<String> op2 = Optional.ofNullable("bin");

        //判断值是否存在
        System.out.println("该值是否为空："+op.isPresent());

        //有值返回，无值异常
        System.out.println("获取该值："+op.get());

        System.out.print("有实例会输出：");
        op.ifPresent((value)-> System.out.println(value));

        System.out.print("如果有值返回本值，否则返回指定的值：");
        System.out.println(op.orElse("武职"));

        System.out.print("如果有值返回本值，否则返回指定结果：");
        System.out.println(op.orElseGet(()->"default"));

        /*
        try {
            System.out.print("如果有值则返回，否则抛出异常：");
            op.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Optional<String> op4 = op.map((value)->value.toUpperCase());
        System.out.println(op4.orElse("没有值"));

        Optional op5 = op.flatMap((value)->Optional.of(value.toUpperCase()+"-flatMap"));
        System.out.println(op5.orElse("没有值"));

        Optional op6 = op.filter((value)->value.length()>3);
        System.out.println(op6.orElse("长度小于4"));

        //op.ofNullable(null);



    }
}

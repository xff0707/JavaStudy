package supplementary.enu;

/*
使用enum关键字定义枚举类
说明：定义的枚举类默认继承于java.lang.Enum类

Enum类中地常用方法：
values()方法：返回枚举类型的对象数组。该方法可以很方便地遍历所有地枚举值
valueOf(String str)：可以把一个字符串转为对应地枚举类对象。要求字符串必须是枚举类对象地“名字”。如不是，会有运行时异常lllegalArgumentException
toString()：返回当前枚举类对象常量的名称

 */


public class SeasonTest1 {
    public static void main(String[] args) {
        Season1 summer = Season1.SUMMER;
        System.out.println(summer);

        System.out.println("*************");

        //valus():
        Season1[] values = Season1.values();
        for (Season1 s:values
             ) {
            System.out.println(s);
            s.show();
        }

        System.out.println("*************");

        Thread.State[] values1 = Thread.State.values();//线程状态，也是枚举类型
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);

        }

        System.out.println("*************");

        //valueOf(String objName):返回枚举类中对象名是objName的对象
        //如果没有objName的枚举类对象，则抛出异常
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

        winter.show();


    }
}


interface info {
    void show();
}


//使用enum关键字枚举类
enum Season1 implements info{

    //1.提供当前枚举类的对象，多个对象之间用“,”隔开，末尾对象“;”结束
    SPRING("春天","春暖花开"){
        @Override
        public void show() {
            System.out.println("春天在哪里");//分别实现各自的抽象方法
        }
    },//构造函数没参数可以不写括号
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void show() {
            System.out.println("宁夏");
        }
    },
    AUTUMN("秋天","秋高气爽"){
        @Override
        public void show() {
            System.out.println("秋天不回来");
        }
    },
    WINTER("冬天","冰天雪地"){
        @Override
        public void show() {
            System.out.println("大约在冬季");
        }
    };

    //2.声明Season对象的属性
    private final String seasonName;
    private final String seasonDesc;

    //1.私有化类的构造器,并给对象属性赋值
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.其他诉求1：获取枚举类对象的属性
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //实现抽象方法
    /*
    @Override
    public void show() {
        System.out.println("这是一个季节");
    }
     */
}
/*
Enum类的主要方法
public static <T extends Enum<T>> T valueOf(类<T> enumType,String name)返回具有指定名称的指定枚举类型的枚举常量。
public String toString()返回声明中包含的此枚举常量的名称。
public final boolean equals(Object other)如果指定的对象等于此枚举常量，则返回true。
public final int hashCode()返回此枚举常量的哈希码。
public final 类<E> getDeclaringClass()返回与此枚举常量的枚举类型相对应的Class对象。
public final String name() 返回此枚举常量的名称，与其枚举声明中声明的完全相同。
public final int ordinal()返回此枚举常数的序数（其枚举声明中的位置，其中初始常数的序数为零）。
public final int compareTo(E o)将此枚举与指定的对象进行比较以进行订购。
protected final Object clone()throws CloneNotSupportedException抛出CloneNotSupportedException。
                                这样可以确保枚举从未被克隆，这对保持“单身”状态是必要的。





 */

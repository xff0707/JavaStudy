package supplementary.enu;

/*
ʹ��enum�ؼ��ֶ���ö����
˵���������ö����Ĭ�ϼ̳���java.lang.Enum��

Enum���еس��÷�����
values()����������ö�����͵Ķ������顣�÷������Ժܷ���ر������е�ö��ֵ
valueOf(String str)�����԰�һ���ַ���תΪ��Ӧ��ö�������Ҫ���ַ���������ö�������ء����֡����粻�ǣ���������ʱ�쳣lllegalArgumentException
toString()�����ص�ǰö���������������

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

        Thread.State[] values1 = Thread.State.values();//�߳�״̬��Ҳ��ö������
        for (int i = 0; i < values1.length; i++) {
            System.out.println(values1[i]);

        }

        System.out.println("*************");

        //valueOf(String objName):����ö�����ж�������objName�Ķ���
        //���û��objName��ö����������׳��쳣
        Season1 winter = Season1.valueOf("WINTER");
        System.out.println(winter);

        winter.show();


    }
}


interface info {
    void show();
}


//ʹ��enum�ؼ���ö����
enum Season1 implements info{

    //1.�ṩ��ǰö����Ķ��󣬶������֮���á�,��������ĩβ����;������
    SPRING("����","��ů����"){
        @Override
        public void show() {
            System.out.println("����������");//�ֱ�ʵ�ָ��Եĳ��󷽷�
        }
    },//���캯��û�������Բ�д����
    SUMMER("����","��������"){
        @Override
        public void show() {
            System.out.println("����");
        }
    },
    AUTUMN("����","�����ˬ"){
        @Override
        public void show() {
            System.out.println("���첻����");
        }
    },
    WINTER("����","����ѩ��"){
        @Override
        public void show() {
            System.out.println("��Լ�ڶ���");
        }
    };

    //2.����Season���������
    private final String seasonName;
    private final String seasonDesc;

    //1.˽�л���Ĺ�����,�����������Ը�ֵ
    Season1(String seasonName, String seasonDesc) {
        this.seasonName = seasonName;
        this.seasonDesc = seasonDesc;
    }


    //4.��������1����ȡö������������
    public String getSeasonName() {
        return seasonName;
    }

    public String getSeasonDesc() {
        return seasonDesc;
    }

    //ʵ�ֳ��󷽷�
    /*
    @Override
    public void show() {
        System.out.println("����һ������");
    }
     */
}
/*
Enum�����Ҫ����
public static <T extends Enum<T>> T valueOf(��<T> enumType,String name)���ؾ���ָ�����Ƶ�ָ��ö�����͵�ö�ٳ�����
public String toString()���������а����Ĵ�ö�ٳ��������ơ�
public final boolean equals(Object other)���ָ���Ķ�����ڴ�ö�ٳ������򷵻�true��
public final int hashCode()���ش�ö�ٳ����Ĺ�ϣ�롣
public final ��<E> getDeclaringClass()�������ö�ٳ�����ö���������Ӧ��Class����
public final String name() ���ش�ö�ٳ��������ƣ�����ö����������������ȫ��ͬ��
public final int ordinal()���ش�ö�ٳ�������������ö�������е�λ�ã����г�ʼ����������Ϊ�㣩��
public final int compareTo(E o)����ö����ָ���Ķ�����бȽ��Խ��ж�����
protected final Object clone()throws CloneNotSupportedException�׳�CloneNotSupportedException��
                                ��������ȷ��ö�ٴ�δ����¡����Ա��֡�����״̬�Ǳ�Ҫ�ġ�





 */

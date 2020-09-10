package supplementary.api;

import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        /*
        Optional�����ࣨJDK1.8��
        ����һ������Ϊnull�������������ֵ������isPresent()�����᷵��true������get()�����᷵�ظö���
        of:
        Ϊ��null��ֵ����һ��Optional
        ofNullable:
        Ϊָ����ֵ����һ��Ϊ��null��ֵ����һ��Optional�����ָ����ֵΪnull���򷵻�һ���յ�Optional
        isPresent:
        ���ֵ���ڷ���true�����򷵻�false
        get:
        ���Optional��ֵ���䷵�أ������׳�NoSuchElementException
        ifPresent:
        ���Optionalʵ����ֵ��Ϊ�����consumer������������
        orElse:
        �����ֵ���䷵�أ����򷵻�ָ��������ֵ��	orElse(T other)�������ֵ���򷵻ظ�ֵ�����򷵻� other��
        orElseGet(Supplier<? extends T> supplier)�������ֵ���򷵻ظ�ֵ�����򷵻ع�Ӧ���������Ľ����
        orElseThrow()�������ֵ���򷵻ظ�ֵ�������׳� NoSuchElementException��
        map(Function<? super T,? extends U> mapper)	�������ֵ���򷵻�Optional����������byһ�� ofNullable(T)��������ӳ�亯��Ӧ���ڸ�ֵ�Ľ�������򷵻�empty Optional��
        flatMap(Function<? super T,? extends Optional<? extends U>> mapper)	�������Optionalֵ���򷵻ؽ������� -bearingӳ�亯��Ӧ���ڸ�ֵ�Ľ�������򷵻�empty Optional��
        filter(Predicate<? super T> predicate)�������һ��ֵ�����Ҹ�ֵ�������ν��ƥ�䣬�򷵻�һ��Optional����ֵ�����������򷵻�һ��empty Optional��

        */


        //����һ���յ�
        //Optional op = Optional.empty();
        //����һ���ǿյ�
        Optional<String> op = Optional.of("bin");
        //����һ������Ϊ�յ�
        Optional<String> op2 = Optional.ofNullable("bin");

        //�ж�ֵ�Ƿ����
        System.out.println("��ֵ�Ƿ�Ϊ�գ�"+op.isPresent());

        //��ֵ���أ���ֵ�쳣
        System.out.println("��ȡ��ֵ��"+op.get());

        System.out.print("��ʵ���������");
        op.ifPresent((value)-> System.out.println(value));

        System.out.print("�����ֵ���ر�ֵ�����򷵻�ָ����ֵ��");
        System.out.println(op.orElse("��ְ"));

        System.out.print("�����ֵ���ر�ֵ�����򷵻�ָ�������");
        System.out.println(op.orElseGet(()->"default"));

        /*
        try {
            System.out.print("�����ֵ�򷵻أ������׳��쳣��");
            op.orElseThrow(Exception::new);
        } catch (Exception e) {
            e.printStackTrace();
        }
        */

        Optional<String> op4 = op.map((value)->value.toUpperCase());
        System.out.println(op4.orElse("û��ֵ"));

        Optional op5 = op.flatMap((value)->Optional.of(value.toUpperCase()+"-flatMap"));
        System.out.println(op5.orElse("û��ֵ"));

        Optional op6 = op.filter((value)->value.length()>3);
        System.out.println(op6.orElse("����С��4"));

        //op.ofNullable(null);



    }
}

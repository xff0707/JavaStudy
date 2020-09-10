package supplementary.api;

public class TestMethodRef {
    public static void main(String[] args) {
        byte b = -2;
        System.out.println(b);
        int c = b;
        System.out.println(c);
        System.out.println(Integer.toBinaryString(c));
        int d = c&0xff;
        System.out.println(d);
    }
}

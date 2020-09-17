package Day13;

public class Chuanjisuan {
    public static void main(String[] args) {
        String s = "ABCDEFG";
        String d = "PQRST";
        System.out.println(con(s,d));
        System.out.println(subs(s,2,3));
        System.out.println(len(s));
        String s1 = "ABCDEFG";
        String s2 = "PQRST";
        System.out.println(con(subs(s1, 2, len(s2)), subs(s1, len(s2), 2)));

        int i = Integer.parseInt("3c",16);
        System.out.println(i);
    }

    public static String con(String a, String b) {
        return a+b;
    }

    public static String subs(String s, int i,int j) {
        return s.substring(i-1,j+i-1);
    }

    public static int len(String s) {
        return s.length();
    }
}

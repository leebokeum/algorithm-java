package bit;

public class BitUtils {
    public static String toFullBinaryString(int a) {
        String s = "";
        for (int i = 0; i < 32; i++) {
            int lsb = a & 1;
            s = Integer.toString(lsb) + s;
            a = a >> 1;
        }
        return s;
    }

    public static void binPrint(int i) {
        System.out.println(i + ": " + Integer.toBinaryString(i));
    }
}

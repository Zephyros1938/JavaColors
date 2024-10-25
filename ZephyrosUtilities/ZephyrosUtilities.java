package ZephyrosUtilities;

import java.nio.charset.Charset;

public class ZephyrosUtilities {
    private static Charset UTF8_CHARSET = Charset.forName("UTF-8");
    public static char encodeUTF8Byte(byte x){
        return (char)x;
    }

    public static String encodeUTF8(byte[] x){
        return new String(x, UTF8_CHARSET);
    }

    public static byte[] decodeUTF8(String x){
        byte[] b = x.getBytes();
        return b;
    }
}
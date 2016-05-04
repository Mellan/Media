import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * Created by leidian on 2016/3/23.
 */
public class MD5Encoder {
    private static final char[] HEX_DIGITS= new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'a', 'b',
                'c', 'd', 'e', 'f'};

    public static String encode32(String s) {
        String v0 = s != null ? MD5Encoder.getFormattedText(MD5Encoder.encode32(s.getBytes())) : null;
        return v0;
    }
    public static byte[] encode32(byte[] bytes) {
        byte[] v3=new byte[100000];
        String v1 = "MD5";
        try {
            MessageDigest v2 = MessageDigest.getInstance(v1);
            v2.update(bytes);
            v3 = v2.digest();
        }
        catch(Exception v0) {
            v0.printStackTrace();
        }
        return v3;
    }
    private static String getFormattedText(byte[] abyte) {
        String v6;
        if(abyte == null) {
            v6 = null;
        }
        else {
            int v4 = abyte.length;
            StringBuilder v5 = new StringBuilder(v4 * 2);
            int v2;
            for(v2 = 0; v2 < v4; ++v2) {
                v5.append(MD5Encoder.HEX_DIGITS[abyte[v2] >> 4 & 15]);
                v5.append(MD5Encoder.HEX_DIGITS[abyte[v2] & 15]);
            }

            v6 = v5.toString();
        }

        return v6;
    }

}

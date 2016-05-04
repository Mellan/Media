import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by leidian on 2016/3/23.
 */
public class AES128Coder {

    static final String CIPHER_CBC_PKCS5 = "AES/CBC/PKCS5Padding";
    static final String CIPHER_CBC_PKCS7 = "AES/CBC/PKCS7Padding";
    static final String CIPHER_ECB_PKCS5 = "AES/ECB/PKCS5Padding";
    static final String CIPHER_ECB_PKCS7 = "AES/ECB/PKCS7Padding";
    static final String KEY_ALGORITHM = "AES";

    public static String decode(String encrypted, String seed) {
        String v3;
        try {
            v3 = new String(AES128Coder.decode(hexStringToBytes(encrypted), seed.getBytes()));
        }
        catch(Exception v0) {
            v0.printStackTrace();
            v3 = null;
        }

        return v3;
    }
    public static byte[] hexStringToBytes(String hexString) {
        int v2 = hexString.length() / 2;
        byte[] v0 = new byte[v2];
        int v1 = 0;

        while(v1 < v2) {
            v0[v1] = Integer.valueOf(hexString.substring(v1 * 2, v1 * 2 + 2), 16).byteValue();
            ++v1;

        }

        return v0;
    }
    public static byte[] decode(byte[] encrypted, byte[] raw) {
        byte[] v1;
        try {
            SecretKeySpec v3 = new SecretKeySpec(raw, "AES");
            Cipher v0 = Cipher.getInstance("AES/ECB/PKCS5Padding");
            v0.init(2, ((Key)v3));
            v1 = v0.doFinal(encrypted);
        }
        catch(Exception v2) {
            v2.printStackTrace();
            v1 = null;
        }

        return v1;
    }
}

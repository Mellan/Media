import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

/**
 * Created by leidian on 2016/3/22.
 */
public class EncodeAES128 {

    public String encodeAES128(String cleartext,String mDataKey) {
        String v1;
        try {
            v1 = encode(cleartext, mDataKey);
        } catch (Exception v0) {
            v0.printStackTrace();
            v1 = null;
        }

        return v1;
    }

    public static byte[] encode(byte[] clear, byte[] raw) {
        byte[] v2;
        try {
            SecretKeySpec v3 = new SecretKeySpec(raw, "AES");
            Cipher v0 = Cipher.getInstance("AES/ECB/PKCS5Padding");
            v0.init(1, ((Key) v3));
            v2 = v0.doFinal(clear);
        } catch (Exception v1) {
            v1.printStackTrace();
            v2 = null;
        }

        return v2;
    }
    public static String encode(String cleartext, String seed) {
        String v2;
        try {
            v2 = bytesToUcHexString(encode(cleartext.getBytes("utf-8"), seed.getBytes()));
        }
        catch(Exception v0) {
            v0.printStackTrace();
            v2 = null;
        }

        return v2;
    }

    public static String bytesToUcHexString(byte[] src) {
        String v2;
        if(src == null) {
            v2 = null;
        }
        else {
            StringBuffer v1 = new StringBuffer(src.length * 2);
            int v0;
            for(v0 = 0; v0 < src.length; ++v0) {
                v1.append(byteToUcHexString(src[v0]));
            }

            v2 = v1.toString();
        }

        return v2;
    }
    public static String byteToUcHexString(byte src) {
        return new StringBuffer().append("0123456789ABCDEF".charAt(src >> 4 & 15)).append("0123456789ABCDEF"
                .charAt(src & 15)).toString();
    }
}

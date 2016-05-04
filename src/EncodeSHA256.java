import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

/**
 * Created by leidian on 2016/3/21.
 */
public class EncodeSHA256 {
    public static String encode(String src) {
        try {
            MessageDigest v1 = MessageDigest.getInstance("SHA-256");
            v1.update(src.getBytes("UTF8"));
            String v2 =bytesToLcHexString(v1.digest());
            return v2;
        }
        catch(UnsupportedEncodingException v0) {
            v0.printStackTrace();
        }
        catch(NoSuchAlgorithmException v0_1) {
            v0_1.printStackTrace();
        }

        return null;
    }
    public static String bytesToLcHexString(byte[] src) {
        String v2;
        if(src == null) {
            v2 = null;
        }
        else {
            StringBuffer v1 = new StringBuffer(src.length * 2);
            int v0;
            for(v0 = 0; v0 < src.length; ++v0) {
                v1.append(byteToLcHexString(src[v0]));
            }

            v2 = v1.toString();
        }

        return v2;
    }
    public static String byteToLcHexString(byte src) {
        return new StringBuffer().append("0123456789abcdef".charAt(src >> 4 & 15)).append("0123456789abcdef"
                .charAt(src & 15)).toString();
    }
    public String sortParams(String param) {
        StringBuffer v1 = new StringBuffer();
        //System.out.print("param:"+param);
        String[] v0 = param.split("&");
        Arrays.sort(v0);
        int v2 = 0;
        while(v2 < v0.length) {
            v1.append(v0[v2] + "&");
            ++v2;
        }
        String v3 = v1.toString();
        return v3.substring(0, v3.length() - 1);
    }
}

import java.util.Locale;

/**
 * Created by leidian on 2016/3/21.
 */
public class MainTest {


    public static void main(String[] args){
        EncodeSHA256 encodeSHA256=new EncodeSHA256();
        EncodeAES128 encodeAES128=new EncodeAES128();
        MD5Encoder md5Encoder=new MD5Encoder();
        AES128Coder aes128Coder=new AES128Coder();
         DataHttp dataHttp=new DataHttp();
         String mCommand="homegroup/list/get";
        String entity=dataHttp.getEntity();
        System.out.println("entity"+entity);
        String accessToken="b45b8945cff8ea9f98b8b1da950dacfd73e9040221dc53e61704362c9fd5c910";
        //String entity="format=" + mFormat + "&stamp=" + mStamp + "&language=" + mLanguage
        String v2 = encodeSHA256.sortParams(entity);
        //String v2="format=2&language=zh_CN&loginAccount=18810689364&sessionId=2da97e1a-18e5-4fdb-837e-98cb162ca8a3&src=0&stamp=20160322084924";
        System.out.println("v2:"+v2);
        String v0 = "/v1/" + mCommand + v2 + "2f39d871a38a4841aab3be3837e39cf4";
        System.out.println("v0:"+v0);
        String mSign = encodeSHA256.encode(v0);
        String DYNAMIC_KEY=md5Encoder.encode32("2f39d871a38a4841aab3be3837e39cf4").toLowerCase(Locale.getDefault()).substring(0, 16);
        String mDatakey=aes128Coder.decode(accessToken,DYNAMIC_KEY);
        System.out.print("datakey:"+mDatakey+"\n");
        String order=encodeAES128.encodeAES128("card_open",mDatakey);
        System.out.println("mSign:"+mSign);
        System.out.print("order:"+order);
    }


}

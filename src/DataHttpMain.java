/**
 * Created by leidian on 2016/3/21.
 */
public class DataHttpMain {
     String mFormat="2";

     String mLanguage="zh_CN";

    public  String getEntity(String mStamp) {

        String httpmain= "format=" + mFormat + "&stamp=" + mStamp;
        //System.out.println(httpmain);
        return httpmain;
    }
}

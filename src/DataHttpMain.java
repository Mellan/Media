/**
 * Created by leidian on 2016/3/21.
 */
public class DataHttpMain {
     String mFormat="";
     String mStamp="";
     String mLanguage="zh_CN";
    public  String getEntity() {

        String httpmain= "format=" + mFormat + "&stamp=" + mStamp ;
        //System.out.println(httpmain);
        return httpmain;
    }
}

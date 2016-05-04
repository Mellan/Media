import java.io.*;
import java.net.URL;
import java.net.URLConnection;

/**
 * Created by Mellan on 2016/5/3.
 */
public class Post {
    public static void post(String sign,String mobile,String mStamp)throws IOException{
        URL url=new URL("http://iot4.midea.com.cn:10050/v1/user/mobile/verify/get");
        URLConnection urlConnection=url.openConnection();
        urlConnection.setDoOutput(true);
        OutputStreamWriter writer=new OutputStreamWriter(urlConnection.getOutputStream());
        String req_body="appId=1000&"+"sign="+sign+"&mobile="+mobile+"&format=2"+"&stamp="+mStamp+"&type=1";
        System.out.println("req_body="+req_body+"\n");
        writer.write(req_body);
        writer.flush();
        writer.close();
        String line="";
        String response="";
        InputStream inputStream=urlConnection.getInputStream();
        BufferedReader reader=new BufferedReader(new InputStreamReader(inputStream));
        while((line=reader.readLine())!=null){
            response+=line+"\n";
        }
        System.out.println("response="+response+"\n");
    }
}

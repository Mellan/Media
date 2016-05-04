/**
 * Created by leidian on 2016/3/21.
 */
public class DataHttpIn extends DataHttpMain {
    String mSrc="1";
    String sSessionId="42f7a14d-62d8-42ee-92e6-44aef8b55eb8";
    public String getEntity() {
        String httpin=super.getEntity() + "&" + "src" + "=" + this.mSrc + "&" + "sessionId" + "=" + this.sSessionId;
        //System.out.println(httpin);
        return httpin;
    }
}

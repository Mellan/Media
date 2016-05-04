/**
 * Created by leidian on 2016/3/21.
 */
public class DataHttp extends DataHttpIn {
    String mType="1";
    String mappId="1000";
    String mHomeId="387687";
    String mLoginAcount="13051881212";
    String mDeviceID="17592187105452";
    String mFunId="0000";
    String mOrder="D77F517AFCA7F669B394B4EF13FC6B3D25BA4BD5AF432849A7552019F78D8E2C013611F11F37739099990E48193500DDFD944D1E2FA652569ABEB3B5C3D97BEE655D98655068B7D63CA05CE1C989150AC95D2160C1AD45D0B3584648EC29673CD9C4F10FA8FB57F34EE53998AABE71ABC885557B563D1CE6B4281C62FC78A85FCD97DB9C7A359D54830B1C98B7A69B53560EA6BAFC3EB38A0C4E43CA0917FF6DC6374458A695F53AB0B11D64BBEF6FB1";
    public String getEntity(String mPhoneNumber,String mStamp) {
        String http=super.getEntity(mStamp) + "&" + "appId" + "=" + this.mappId+"&" + "type" + "=" + this.mType + "&"+ "mobile" + "=" +mPhoneNumber;
        //String http=super.getEntity();
        //String http=super.getEntity() + "&" + "homegroupId" + "=" + this.mHomeId + "&"+ "loginAccount" + "=" + this.mLoginAcount;
        //System.out.println(http);
        //String http=super.getEntity() + "&" + "applianceId" + "=" + this.mDeviceID + "&" + "funId" + "=" + this.mFunId + "&" + "order" + "=" + this.mOrder;
        return http;
    }
}

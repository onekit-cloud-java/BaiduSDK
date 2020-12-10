package demo;

import cn.onekit.thekit.JSON;
import com.baidu.openapi.entity.*;
import com.baidu.openapi.sdk.BaiduOpenSDK;
import com.baidu.spapi.entity.oauth_jscode2sessionkey_body;
import com.baidu.spapi.sdk.BaiduSpSDK;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/")
public class Demo {

    private BaiduSpSDK baiduSpSDK = new BaiduSpSDK("https://spapi.baidu.com");
    private BaiduOpenSDK baiduOpenSDK = new BaiduOpenSDK("https://openapi.baidu.com");

    @RequestMapping("/sessionkey")
    public String sessionkey(){
        oauth_jscode2sessionkey_body body = new oauth_jscode2sessionkey_body();
        body.setCode("33ef0ed6e82d7c4f0a3e1ffaeec24c30NW");
        body.setClient_id(BaiduAccount.appkey);
        body.setSk(BaiduAccount.secret);
        return JSON.object2string(baiduSpSDK.oauth_jscode2sessionkey(body));

    }



    /*@RequestMapping("/getunionid")
    public String getunionid(){
        smartapp_getunionid_body body = new smartapp_getunionid_body();
        body.setOpenid("lgV45Q-Oy7PCs7s8Nq31JxLBQ6");
        String access_token = "24.e61a2bd3fc82178d49bcd9a680ef7688.2592000.1610163878.282335-17211727";
        return JSON.object2string(baiduOpenSDK.smartapp_getunionid(access_token,body));

    }*/

    @RequestMapping("/token")
    public token_response token(){
        String grant_type = "client_credentials";
        String client_id = BaiduAccount.appkey;
        String client_secret =BaiduAccount.secret ;
        String scope = "smartapp_snsapi_base";

        return baiduOpenSDK.token(grant_type,client_id,client_secret,scope);

    }

    @RequestMapping("/get")
    public byte[] get() throws BaiduError {
        String access_token = "24.e61a2bd3fc82178d49bcd9a680ef7688.2592000.1610163878.282335-17211727";
        smartapp_qrcode_get_body body = new smartapp_qrcode_get_body();
        body.setWidth(500);
        body.setPath("pages/index/index");
        body.setMf(1);
        return baiduOpenSDK.smartapp_qrcode_get(access_token,body);

    }

    @RequestMapping("/getunlimited")
    public byte[] getunlimited() throws BaiduError {
        String access_token = "24.e61a2bd3fc82178d49bcd9a680ef7688.2592000.1610163878.282335-17211727";
        smartapp_qrcode_getunlimited_body body = new smartapp_qrcode_getunlimited_body();
        body.setWidth(500);
        body.setPath("pages/index/index");
        body.setMf(1);
        return baiduOpenSDK.smartapp_qrcode_getunlimited(access_token,body);

    }

    @RequestMapping("/send")
    public String send(){
        String access_token = "24.e61a2bd3fc82178d49bcd9a680ef7688.2592000.1610163878.282335-17211727";
        smartapp_message_custom_send_body body = new smartapp_message_custom_send_body();
        body.setMsg_type("text");
        body.setContent("hello");
        body.setOpen_id("lgV45Q-Oy7PCs7s8Nq31JxLBQ6");
        body.setUser_type(2);
        body.setPic_url("");
        return JSON.object2string(baiduOpenSDK.smartapp_message_custom_send(access_token,body));

    }
}

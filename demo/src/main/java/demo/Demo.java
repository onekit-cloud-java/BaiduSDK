package demo;

import com.baidu.openapi.BaiduOpenAPI;
import com.baidu.openapi.sdk.BaiduOpenSDK;
import com.baidu.spapi.BaiduSpAPI;
import com.baidu.spapi.sdk.BaiduSpSDK;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/baidu_demo")

public class Demo {

    @RequestMapping("/getunionid")
    public BaiduOpenAPI.smartapp$getunionid_response getunionid() throws Exception {
        return null;//new BaiduOpenSDK().smartapp$getunionid(BaiduAccount.appid, BaiduAccount.secret, "client_credential");
    }

    @RequestMapping("/SessionKey")
    public BaiduSpAPI.oauth$jscode2sessionkey_response SessionKey(
            @RequestParam String code) throws Exception {
        BaiduSpAPI.oauth$jscode2sessionkey_body body = new BaiduSpAPI.oauth$jscode2sessionkey_body();
        body.setClient_id(BaiduAccount.appkey);
        body.setCode(code);
        body.setSk(BaiduAccount.secret);
        return new BaiduSpSDK().oauth$jscode2sessionkey(null, body);
    }
}

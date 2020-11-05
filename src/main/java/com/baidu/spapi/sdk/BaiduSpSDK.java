package com.baidu.spapi.sdk;

import cn.onekit.thekit.AJAX;
import cn.onekit.thekit.JSON;
import cn.onekit.thekit.MAP;
import com.baidu.spapi.BaiduSpAPI;
import com.google.gson.JsonObject;

import java.util.Map;

public class BaiduSpSDK extends BaiduSpAPI {

    @Override
    public oauth$jscode2sessionkey_response oauth$jscode2sessionkey( oauth$jscode2sessionkey_body body) throws Error {
        final JsonObject result;
        try {
            Map<String, String> map = MAP.object2map(body);
            String response = AJAX.request("https://spapi.baidu.com/oauth/jscode2sessionkey", "post", map);
            result = (JsonObject) JSON.parse(response);
        } catch (Exception e) {
            Error error = new Error();
            throw error;
        }
        if (result.has("error")) {
            throw JSON.json2object(result, Error.class);
        }
        return JSON.json2object(result, oauth$jscode2sessionkey_response.class);
    }
}

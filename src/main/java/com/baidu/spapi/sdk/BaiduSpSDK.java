package com.baidu.spapi.sdk;

import cn.onekit.thekit.AJAX;
import cn.onekit.thekit.JSON;
import com.baidu.spapi.BaiduSpAPI;
import com.baidu.spapi.entity.oauth_jscode2sessionkey_body;
import com.baidu.spapi.entity.oauth_jscode2sessionkey_response;
import com.google.gson.JsonObject;


public class BaiduSpSDK extends BaiduSpAPI {

    private final String host;

    public BaiduSpSDK(String host) {
        this.host=host;
    }

    public oauth_jscode2sessionkey_response oauth_jscode2sessionkey(oauth_jscode2sessionkey_body body) throws Error {
        final JsonObject result;
        try {
            String url = String.format("%s/oauth/jscode2sessionkey",host);
            JsonObject post_body = (JsonObject) JSON.object2json(body);

            result = (JsonObject) JSON.parse(AJAX.request(url, "post", post_body.toString()));

        } catch (Exception e) {
            throw new Error();
        }
        if (result.has("error")) {
            throw JSON.json2object(result, Error.class);
        }
        return JSON.json2object(result, oauth_jscode2sessionkey_response.class);
    }
}

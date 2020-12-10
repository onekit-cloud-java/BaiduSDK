package com.baidu.openapi.sdk;

import cn.onekit.thekit.AJAX;
import cn.onekit.thekit.JSON;
import com.baidu.openapi.BaiduOpenAPI;
import com.baidu.openapi.entity.*;
import com.google.gson.JsonObject;

import java.util.HashMap;

public class BaiduOpenSDK extends BaiduOpenAPI {
    private final String host;

    public BaiduOpenSDK(String host) {
        this.host = host;
    }

   /* public smartapp_getunionid_response smartapp_getunionid(String access_token, smartapp_getunionid_body body) {
        JsonObject result;
        try {
            String url = String.format("%s/rest/2.0/smartapp/getunionid?access_token=%s",host,access_token);
            JsonObject post_body = (JsonObject) JSON.object2json(body);
            result = (JsonObject) JSON.parse(AJAX.request(url, "post", post_body.toString()));
        } catch (Exception e) {
            smartapp_getunionid_response error = new smartapp_getunionid_response();
            error.setErrno(9527);
            error.setErrmsg(e.getMessage());
            return error;
        }
        return JSON.json2object(result,smartapp_getunionid_response.class);
    }
*/
    public token_response token(String grant_type, String client_id, String client_secret, String scope) {
        JsonObject result;
        try {
            String url = String.format("%s/oauth/2.0/token",host);
            HashMap<String,String> map = new HashMap<String, String>();
            map.put("grant_type",grant_type);
            map.put("client_id",client_id);
            map.put("client_secret",client_secret);
            map.put("scope",scope);
            result = (JsonObject) JSON.parse(AJAX.request(url, "get",map));
        } catch (Exception e) {
            token_response error = new token_response();
            error.setError("9527");
            error.setError_description(e.getMessage());
            return error;
        }
        return JSON.json2object(result,token_response.class);
    }

    public byte[] smartapp_qrcode_get(String access_token, smartapp_qrcode_get_body body) throws BaiduError {

        try {
            String url = String.format("%s/rest/2.0/smartapp/qrcode/get?access_token=%s",host,access_token);
            JsonObject post_body = (JsonObject) JSON.object2json(body);
            return AJAX.download(url, "post", post_body.toString());
        } catch (Exception e) {
            BaiduError error = new BaiduError();
            error.setErrno(9527);
            error.setErrmsg(e.getMessage());
            throw  error;
        }


    }

    public byte[] smartapp_qrcode_getunlimited(String access_token, smartapp_qrcode_getunlimited_body body) throws BaiduError {

        try {
            String url = String.format("%s/rest/2.0/smartapp/qrcode/getunlimited?access_token=%s",host,access_token);
            JsonObject post_body = (JsonObject) JSON.object2json(body);
            return AJAX.download(url, "post", post_body.toString());
        } catch (Exception e) {
            BaiduError error = new BaiduError();
            error.setErrno(9527);
            error.setErrmsg(e.getMessage());
            throw  error;
        }
    }

    public smartapp_message_custom_send_response smartapp_message_custom_send(String access_token, smartapp_message_custom_send_body body) {
        final JsonObject result;
        try {
            String url = String.format("%s/rest/2.0/smartapp/message/custom/send?access_token=%s",host,access_token);
            JsonObject post_body = (JsonObject) JSON.object2json(body);
            result = (JsonObject) JSON.parse(AJAX.request(url, "post", post_body.toString()));
        } catch (Exception e) {
            smartapp_message_custom_send_response error = new smartapp_message_custom_send_response();
            error.setErrno(9527);
            error.setMsg(e.getMessage());
            return error;
        }
        return JSON.json2object(result,smartapp_message_custom_send_response.class);
    }
}

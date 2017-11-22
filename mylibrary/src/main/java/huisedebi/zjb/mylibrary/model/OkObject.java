package huisedebi.zjb.mylibrary.model;

import com.lzy.okgo.model.HttpHeaders;

import org.json.JSONObject;

import java.util.HashMap;

/**
 * Created by Administrator on 2017/6/16 0016.
 */
public class OkObject {
    private HashMap<String, String> params;
    private String url;
    private HttpHeaders headers;

    public OkObject(HashMap<String, String> params, String url) {
        this.params = params;
        this.url = url;
    }

    public HttpHeaders getHeaders() {
        return headers;
    }

    public void setHeaders(HttpHeaders headers) {
        this.headers = headers;
    }

    public String getJson() {
        JSONObject jsonObject = new JSONObject(params);
        return jsonObject.toString();
    }


    public OkObject(HttpHeaders headers, HashMap<String, String> params, String url) {
        this.headers=headers;
        this.params = params;
        this.url = url;
    }

    public HashMap<String, String> getParams() {
        return params;
    }

    public void setParams(HashMap<String, String> params) {
        this.params = params;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}

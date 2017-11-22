package huisedebi.zjb.mylibrary.util;

import android.content.Context;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.model.Progress;

import java.io.File;
import java.util.List;

import huisedebi.zjb.mylibrary.model.OkObject;

/**
 * Created by Administrator on 2017/8/27.
 */
public class ApiClient {

    public interface CallBack {
        void onSuccess(String s);

        void onError();
    }

    public interface UpLoadCallBack {
        void onSuccess(String s);

        void onError();

        void uploadProgress(float progress);
    }

    public static void post(Context context, OkObject okObject, final CallBack callBack) {
        LogUtil.LogShitou("ApiClient--发送", "" + okObject.getJson());

        OkGo.<String>post(okObject.getUrl())
                .tag(context)
                .upJson(okObject.getJson())
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        callBack.onSuccess(response.body());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        callBack.onError();
                        LogUtil.LogShitou("ApiClient--onErrorcode", "" + response.code());
                        LogUtil.LogShitou("ApiClient--onErrormessage", "" + response.message());
                        LogUtil.LogShitou("ApiClient--onErrorgetException", "" + response.getException().toString());
                    }
                });
    }

    public static void get(Context context, OkObject okObject, final CallBack callBack) {
        OkGo.<String>get(okObject.getUrl())
                .tag(context)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        callBack.onSuccess(response.body());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        callBack.onError();
                    }
                });

    }

    public static void postJson(Context context, String url, String json, final CallBack callBack) {
        LogUtil.LogShitou("ApiClient--发送", "" + json);
        OkGo.<String>post(url)
                .tag(context)
                .upJson(json)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        callBack.onSuccess(response.body());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        callBack.onError();
                    }
                });
    }

    /**
     * des： 上传文件
     * author： ZhangJieBo
     * date： 2017/11/8 0008 上午 11:40
     */
    public static void upFiles(Context context, OkObject okObject, List<File> files, final UpLoadCallBack callBack) {
        LogUtil.LogShitou("ApiClient--发送", "" + okObject.getJson());
        OkGo.<String>post(okObject.getUrl())
                .tag(context)
                .addFileParams("upload", files)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        callBack.onSuccess(response.body());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        callBack.onError();
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                        callBack.uploadProgress(progress.fraction * 100);
                    }
                });
    }

    /**
     * des： 上传文件
     * author： ZhangJieBo
     * date： 2017/11/8 0008 上午 11:40
     */
    public static void upFile(Context context, OkObject okObject, File files, final UpLoadCallBack callBack) {
        LogUtil.LogShitou("ApiClient--发送", "" + okObject.getJson());
        LogUtil.LogShitou("ApiClient--upFile", "" + files.getPath());
        OkGo.<String>post(okObject.getUrl())
                .tag(context)
                .params("upload", files)
                .execute(new StringCallback() {
                    @Override
                    public void onSuccess(com.lzy.okgo.model.Response<String> response) {
                        callBack.onSuccess(response.body());
                    }

                    @Override
                    public void onError(com.lzy.okgo.model.Response<String> response) {
                        super.onError(response);
                        callBack.onError();
                        LogUtil.LogShitou("ApiClient--onErrorbody", "" + response.body());
                        LogUtil.LogShitou("ApiClient--onErrorcode", "" + response.code());
                        LogUtil.LogShitou("ApiClient--onErrormessage", "" + response.message());
                        LogUtil.LogShitou("ApiClient--onErrorgetException", "" + response.getException().toString());
                    }

                    @Override
                    public void uploadProgress(Progress progress) {
                        super.uploadProgress(progress);
                        callBack.uploadProgress(progress.fraction * 100);
                    }
                });
    }
}

package huisedebi.zjb.mylibrary.application;

import android.app.Activity;
import android.content.Context;
import android.support.multidex.MultiDexApplication;

import java.util.LinkedList;
import java.util.List;


/**
 * 初始化
 *
 * @author Administrator
 * @date 2015/12/31
 */
public class MyApplication extends MultiDexApplication {
    private static Context context;
    private List<Activity> activityList = new LinkedList<Activity>();
    private static MyApplication instance;

    @Override
    public void onCreate() {
        context = this.getApplicationContext();
        super.onCreate();
    }


    public static Context getContext() {
        return context;
    }

    /**
     * 单例模式中获取唯一的MyApplication实例
     */
    public static MyApplication getInstance() {
        if (null == instance) {
            instance = new MyApplication();
        }
        return instance;
    }

    /**
     * 添加Activity到容器中
     */
    public void addActivity(Activity activity) {
        activityList.add(activity);
    }

    /**
     * 遍历所有Activity并finish
     */
    public void exit() {
        for (Activity activity : activityList) {
            activity.finish();
        }
        System.exit(0);
    }

}

package chris.li.selfstudy1;

import android.app.Activity;

import java.util.ArrayList;
import java.util.List;

public class ActivityCollector {     //活动管理器
    public static List<Activity> activities = new ArrayList<>();

    public static void addActivity(Activity activity){
        activities.add(activity);
    }  //当活动被创建时  将活动加入到List中

    public static void removeActivity(Activity activity){
        activities.remove(activity);
    }  //当活动被销毁时，从List中去除活动

    public static void finishAll(){   //提供给活动直接推出程序的方法，一次性将所有活动销毁。
        for(Activity activity : activities){
            if(!activity.isFinishing()){
                activity.finish();
            }
        }
    }
}

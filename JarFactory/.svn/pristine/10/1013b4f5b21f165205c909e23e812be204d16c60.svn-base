package com;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;

/**
 * Activity管理类
 * 
 * @author Administrator
 *
 */
public class ActivityManager {
	private static List<Activity> activities = new ArrayList<Activity>();

	// 向栈中添加Activity
	public static void addActivity(Activity act) {
		if (act != null) {
			activities.add(act);
		}
	}

	// 删除栈中Activity
	public static void deleteActivity(Activity act) {
		try {
			if (act != null) {
				activities.remove(act);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 清空栈中数据，这里需要关闭所有Activity，并清空栈数据
	 */
	public static void removeAllActivity() {
		try {
			if (activities != null && activities.size() > 0) {
				for (Activity act : activities) {
					if (act != null) {
						act.finish();
					}
				}
				activities.clear();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

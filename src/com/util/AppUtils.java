package com.util;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;

/**
 * 应用 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class AppUtils {

	/**
	 * 获取程序名称
	 * 
	 * @param context
	 * @return
	 */
	public static String getAppName(Context context) {
		String appName = "";
		// system
		ApplicationInfo applicationInfo = null;
		PackageManager packageManager = null;
		try {
			packageManager = context.getPackageManager();
			applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
			appName = (String) packageManager.getApplicationLabel(applicationInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appName;
	}

	/**
	 * 获取程序图标
	 * 
	 * @param context
	 * @return
	 */
	public static Drawable getAppIcon(Context context) {
		Drawable appIcon = null;
		// system
		ApplicationInfo applicationInfo = null;
		PackageManager packageManager = null;
		try {
			packageManager = context.getPackageManager();
			applicationInfo = packageManager.getApplicationInfo(context.getPackageName(), 0);
			appIcon = packageManager.getApplicationIcon(applicationInfo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return appIcon;
	}

	/**
	 * 获取程序的版本 versionCode
	 * 
	 * @param context
	 * @return
	 */
	public static String getAppVersion(Context context) {
		String versionName = "";
		try {
			PackageManager pm = context.getPackageManager();
			PackageInfo pi = pm.getPackageInfo(context.getPackageName(), 0);
			versionName = pi.versionName;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return versionName;
	}
}

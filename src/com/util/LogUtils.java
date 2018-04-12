package com.util;

import com.App;

import android.util.Log;

/**
 * 日志 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class LogUtils {
	// 输入日志
	public static void logE(String msg) {
		if (App.config.isDebug()) {
			try {
				Log.i("LogUtils", DateUtils.getCurrentDateString() + "->" + msg);
			} catch (Exception e) {
			}
		}
	}

	// 输入日志
	public static void logE(String flagString, String msg) {
		if (App.config.isDebug()) {
			try {
				Log.i(flagString, DateUtils.getCurrentDateString() + "->" + msg);
			} catch (Exception e) {
			}
		}
	}

	// 输入日志
	public static void log(String msg) {
		if (App.config.isDebug()) {
			try {
				Log.i("LogUtils", DateUtils.getCurrentDateString() + "->" + msg);
			} catch (Exception e) {
			}
		}
	}

	// 输入日志
	public static void log(String flagString, String msg) {
		if (App.config.isDebug()) {
			try {
				Log.i(flagString, DateUtils.getCurrentDateString() + "->" + msg);
			} catch (Exception e) {
			}
		}
	}

	// 输出系统日志
	public static void logSystem(String msg) {
		log("SystemLog", msg);
	}
}

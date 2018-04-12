package com;

import com.db.DBHelp;

import android.graphics.Color;

/**
 * 工具配置类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class Utils {
	// 状态栏颜色
	private static int barDefaultColor = Color.TRANSPARENT;

	/**
	 * 设置默认状态栏颜色，默认透明
	 * 
	 * @param systemBarColor
	 */
	public static void initDefaultBarColor(int systemBarColor) {
		barDefaultColor = systemBarColor;
	}

	/**
	 * 获取状态栏颜色
	 * 
	 * @return Context
	 */
	public static int getDefaultBarColor() {
		return barDefaultColor;
	}

	/**
	 * 初始化DB
	 * 
	 * @param dbName
	 */
	public static void initDb(String dbName) {
		// 初始化数据库
		if (App.context != null) {
			DBHelp.createDb(App.context, dbName + ".db");
		}
	}
}

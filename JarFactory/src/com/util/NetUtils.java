package com.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo.State;

/**
 * 网络 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class NetUtils {
	public static final int NETWORN_NONE = 0; // 无网络
	public static final int NETWORN_WIFI = 1; // WIFI
	public static final int NETWORN_MOBILE = 2; // 数据

	/**
	 * 获得网络状态
	 * 
	 * @param context
	 * @return
	 */
	public static int getNetworkState(Context context) {
		if (context != null) {
			try {
				ConnectivityManager connManager = (ConnectivityManager) context
						.getSystemService(Context.CONNECTIVITY_SERVICE);
				// Wifi
				State state = connManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState();
				if (state == State.CONNECTED || state == State.CONNECTING) {
					return NETWORN_WIFI;
				}
				// 数据
				state = connManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState();
				if (state == State.CONNECTED || state == State.CONNECTING) {
					return NETWORN_MOBILE;
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return NETWORN_NONE;
	}
}

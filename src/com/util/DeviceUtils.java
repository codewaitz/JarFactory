package com.util;

import java.util.ArrayList;

import com.App;

import android.content.Context;
import android.media.AudioManager;
import android.telephony.SmsManager;
import android.telephony.TelephonyManager;
import android.view.WindowManager;

/**
 * 设备 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class DeviceUtils {
	/**
	 * 获取设备号
	 * 
	 * @return
	 */
	public static String getDeviceNo() {
		String result = "";
		try {
			TelephonyManager mTelephonyMgr = (TelephonyManager) App.context
					.getSystemService(Context.TELEPHONY_SERVICE);
			result = mTelephonyMgr.getDeviceId();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	/**
	 * 获取屏幕的尺寸
	 * 
	 * @param context
	 * @return
	 */
	@SuppressWarnings("deprecation")
	public static double[] getSystmSize(Context context) {
		if (context != null) {
			WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
			int width = wm.getDefaultDisplay().getWidth();
			int height = wm.getDefaultDisplay().getHeight();
			return new double[] { width, height };
		}
		return null;
	}

	/**
	 * 获取当前设备手机号
	 * 
	 * @return
	 */
	public static String getPhoneNumber(Context context) {
		String tempNum = "";
		try {
			TelephonyManager mTelephonyMgr = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
			tempNum = mTelephonyMgr.getLine1Number();
			String reg = "+86";// 干掉+86
			if (tempNum.startsWith(reg)) {
				tempNum = tempNum.substring(reg.length(), tempNum.length());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return tempNum;
	}

	/**
	 * 直接调用短信接口发短信
	 * 
	 * @param phoneNumber
	 * @param message
	 */
	public static void sendSMS(String phoneNumber, String message) {
		try {
			SmsManager manager = SmsManager.getDefault();
			ArrayList<String> list = manager.divideMessage(message);
			// 因为一条短信有字数限制，因此要将长短信拆分
			for (String text : list) {
				try {
					manager.sendTextMessage(phoneNumber, null, text, null, null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 设置设备声音模式||是否扩音
	 * 
	 * @param on
	 */
	@SuppressWarnings("deprecation")
	public static void setSpeakerphoneOn(boolean on) {
		try {
			AudioManager audioManager = (AudioManager) App.context.getSystemService(Context.AUDIO_SERVICE);
			if (on) {
				audioManager.setSpeakerphoneOn(true);
			} else {
				audioManager.setSpeakerphoneOn(false);// 关闭扬声器
				audioManager.setRouting(AudioManager.MODE_NORMAL, AudioManager.ROUTE_EARPIECE, AudioManager.ROUTE_ALL);
				// 把声音设定成Earpiece（听筒）出来，设定为正在通话中
				audioManager.setMode(AudioManager.MODE_IN_CALL);
			}
		} catch (Exception e) {
			e.fillInStackTrace();
		}
	}
}

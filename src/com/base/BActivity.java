package com.base;

import com.ActivityManager;
import com.Utils;
import com.lidroid.xutils.ViewUtils;
import com.readystatesoftware.systembartint.SystemBarTintManager;
import com.util.LogUtils;
import com.util.ToastUtils;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

/**
 * 应用Activity基类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public abstract class BActivity extends Activity {
	protected Activity activity;
	public Bundle savedInstanceState;
	// 返回退出处理
	private long exitTime = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// 获取当前实例
		activity = getInstance();
		if (activity != null) {
			LogUtils.logSystem("进入：" + activity.getClass().getName());
			LogUtils.logSystem(activity.getClass().getSimpleName() + " onCreate() execute.....");
		}
		this.savedInstanceState = savedInstanceState;
		// 设置布局
		setContentView(getXML());
		// 设置状态栏
		if (isNeedSetBar()) {
			setSystemBar();
		}
		// 添加管理器
		ActivityManager.addActivity(activity);
		ViewUtils.inject(activity);
		onCreate();
	}

	@Override
	protected void onResume() {
		if (activity != null) {
			LogUtils.logSystem(activity.getClass().getSimpleName() + " onResume() execute.....");
		}
		super.onResume();
	}

	@Override
	protected void onPause() {
		if (activity != null) {
			LogUtils.logSystem(activity.getClass().getSimpleName() + " onPause() execute.....");
		}
		super.onPause();
	}

	@Override
	protected void onStop() {
		if (activity != null) {
			LogUtils.logSystem(activity.getClass().getSimpleName() + " onStop() execute.....");
		}
		super.onStop();
	}

	@Override
	protected void onDestroy() {
		if (activity != null) {
			LogUtils.logSystem(activity.getClass().getSimpleName() + " onDestroy() execute.....");
		}
		ActivityManager.deleteActivity(activity);
		super.onDestroy();
	}

	/**
	 * 设置系统状态栏
	 */
	private void setSystemBar() {
		// 1、4.4及以上版本开启
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			setTranslucentStatus(true);
		}
		SystemBarTintManager tintManager = new SystemBarTintManager(this);
		tintManager.setStatusBarTintEnabled(true);
		tintManager.setNavigationBarTintEnabled(true);
		// 自定义颜色
		tintManager.setTintColor(getBarColor());
	}

	// 获取状态栏颜色
	public int getBarColor() {
		return Utils.getDefaultBarColor();
	}

	// 是否需要设置状态栏
	public boolean isNeedSetBar() {
		return true;
	}

	/**
	 * 获得当前实例对象 便于使用的时候统一管理对象
	 * 
	 * @return
	 */
	public abstract Activity getInstance();

	/**
	 * getXML 获取View
	 */
	public abstract int getXML();

	/**
	 * 初始化方法重写
	 */
	public abstract void onCreate();

	/**
	 * 两次返回退出
	 */
	public void exitByDoubelClick() {
		if ((System.currentTimeMillis() - exitTime) > 2000) {
			ToastUtils.show(activity, "再按一次退出");
			exitTime = System.currentTimeMillis();
		} else {
			super.onBackPressed();
		}
	}

	@TargetApi(19)
	private void setTranslucentStatus(boolean on) {
		Window win = getWindow();
		WindowManager.LayoutParams winParams = win.getAttributes();
		final int bits = WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS;
		if (on) {
			winParams.flags |= bits;
		} else {
			winParams.flags &= ~bits;
		}
		win.setAttributes(winParams);
	}
}

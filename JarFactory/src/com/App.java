package com;

import java.io.File;

import com.config.Config;
import com.util.FileUtils;
import com.util.LogUtils;
import com.util.StringUtils;

import android.app.Application;
import android.content.Context;

public class App extends Application {
	// 工具类的全局配置
	public static Context context;
	public static Config config;// 配置对象

	@Override
	public void onCreate() {
		super.onCreate();
		// 初始化文件目录
		if (config == null) {
			config = new Config();
			onConfig();
			context = this;
		}
		LogUtils.logSystem("App启动......");
		try {
			String rootDir = FileUtils.GetStorageDir(this);
			if (!StringUtils.isEmptyString(rootDir)) {
				config.setBaseDir(rootDir);
				LogUtils.logSystem("App系统储存根目录：" + rootDir);
				String tempDir = rootDir + "temp" + File.separator;
				FileUtils.createFileDir(tempDir);
				config.setTempDir(tempDir);
				LogUtils.logSystem("App创建储存临时目录：" + rootDir);
				String tempPic = rootDir + "picture" + File.separator;
				FileUtils.createFileDir(tempPic);
				config.setTempPictureDir(tempPic);
				LogUtils.logSystem("App创建储存临时媒体目录：" + rootDir);
			}
			Utils.initDb(config.getSoftNo());
			LogUtils.logSystem("App初始化本地数据库助手完成");
		} catch (Exception e) {
			LogUtils.logSystem("App初始化失败，错误提示：" + e.getMessage());
		} finally {
			LogUtils.logSystem("App启动完成");
		}
	}

	/**
	 * 设置配置
	 */
	protected void onConfig() {
	}
}

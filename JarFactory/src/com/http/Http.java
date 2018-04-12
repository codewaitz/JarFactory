package com.http;

import org.apache.http.Header;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.util.LogUtils;

/**
 * HTTP 请求
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class Http {
	// 初始化AsyncHttpClient对象
	private static AsyncHttpClient asyncHttpClient = new AsyncHttpClient();
	private static int TIME_OUT = 30 * 1000;// 设置超时时间

	/**
	 * 设置超时时间
	 * 
	 * @param timeout
	 */
	public static void setHttpTimeout(int timeout) {
		TIME_OUT = timeout;
	}

	/**
	 * POST 请求处理
	 * 
	 * @param httpRequest
	 */
	public static void doPost(final HttpRequest httpRequest) {
		if (asyncHttpClient != null && httpRequest != null) {
			asyncHttpClient.setTimeout(TIME_OUT);
			// 返回监听创建
			AsyncHttpResponseHandler asyncHttpResponseHandler = new AsyncHttpResponseHandler() {
				@Override
				public void onStart() {
					super.onStart();
					if (httpRequest.httpListener != null) {
						httpRequest.httpListener.start();
					}
				}

				@Override
				public void onSuccess(int status, Header[] arg1, byte[] responseBody) {
					if (status == 200) {
						try {
							String result = new String(responseBody, "UTF-8");
							if (httpRequest.httpListener != null) {
								httpRequest.httpListener.success(result);
							}
						} catch (Exception e) {
							e.printStackTrace();
							if (httpRequest.httpListener != null) {
								httpRequest.httpListener.failed("请求数据解析失败");
							}
						}
					} else {
						if (httpRequest.httpListener != null) {
							httpRequest.httpListener.failed("请求数据响应失败");
						}
					}
				}

				@Override
				public void onFailure(int arg0, Header[] arg1, byte[] arg2, Throwable arg3) {
					if (httpRequest.httpListener != null) {
						httpRequest.httpListener.failed("请求网络故障，无法响应数据");
					}
				}
			};
			// 请求，无参和有参处理
			String log = httpRequest.url;
			if (httpRequest.httpParams == null) {
				asyncHttpClient.post(httpRequest.url, asyncHttpResponseHandler);
			} else {
				log += "?" + httpRequest.httpParams.toString();
				asyncHttpClient.post(httpRequest.url, httpRequest.httpParams, asyncHttpResponseHandler);
			}
			LogUtils.logSystem(log);
		}
	}
}
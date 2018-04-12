package com.http;

/**
 * HTTP 请求监听
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public abstract class HttpListener {
	// start request
	public void start() {
	}

	// request success
	public abstract void success(String result);

	// request failed
	public abstract void failed(String error);
}
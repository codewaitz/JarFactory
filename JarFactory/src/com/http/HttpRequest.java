package com.http;

/**
 * 请求结果
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class HttpRequest {
	public String url; // 请求MyUrl
	public HttpParams httpParams; // 请求参数
	public HttpListener httpListener; // 请求监听

	public HttpRequest(String url, HttpParams httpParams, HttpListener httpListener) {
		super();
		this.url = url;
		this.httpParams = httpParams;
		this.httpListener = httpListener;
	}

	public HttpRequest(String url, HttpListener httpListener) {
		super();
		this.url = url;
		this.httpListener = httpListener;
	}
}

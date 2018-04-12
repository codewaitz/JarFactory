package com.config;

public class Config {
	// 文件位置
	private String baseDir;
	private String tempDir;
	private String tempPictureDir;
	// isdebug
	private boolean isDebug = true;// 是否debug模式
	// company no
	private String appCpmp = "SHOUGANG"; // 企业简称
	// software number
	private String softNo = "SHOUGANG"; // 软件编号
	// timeout times
	private int timeout = 30 * 1000;
	// max_page
	private int maxPageCount = 8;
	// request failed
	private String error = "请求处理失败";
	// http code
	private int httpSuccessCode = 1;

	public String getBaseDir() {
		return baseDir;
	}

	public void setBaseDir(String baseDir) {
		this.baseDir = baseDir;
	}

	public String getTempDir() {
		return tempDir;
	}

	public void setTempDir(String tempDir) {
		this.tempDir = tempDir;
	}

	public String getTempPictureDir() {
		return tempPictureDir;
	}

	public void setTempPictureDir(String tempPictureDir) {
		this.tempPictureDir = tempPictureDir;
	}

	public boolean isDebug() {
		return isDebug;
	}

	public void setDebug(boolean isDebug) {
		this.isDebug = isDebug;
	}

	public String getAppCpmp() {
		return appCpmp;
	}

	public void setAppCpmp(String appCpmp) {
		this.appCpmp = appCpmp;
	}

	public String getSoftNo() {
		return softNo;
	}

	public void setSoftNo(String softNo) {
		this.softNo = softNo;
	}

	public int getTimeout() {
		return timeout;
	}

	public void setTimeout(int timeout) {
		this.timeout = timeout;
	}

	public int getMaxPageCount() {
		return maxPageCount;
	}

	public void setMaxPageCount(int maxPageCount) {
		this.maxPageCount = maxPageCount;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getHttpSuccessCode() {
		return httpSuccessCode;
	}

	public void setHttpSuccessCode(int httpSuccessCode) {
		this.httpSuccessCode = httpSuccessCode;
	}

	public void setConfig(boolean isDebug, String appCpmp, String softNo) {
		this.isDebug = isDebug;
		this.appCpmp = appCpmp;
		this.softNo = softNo;
	}

}

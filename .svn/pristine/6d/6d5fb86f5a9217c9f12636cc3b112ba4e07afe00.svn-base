package com.util;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * 资源加载 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class InflaterUtils {
	/**
	 * LayoutInflater XML
	 * 
	 * @param VId
	 * @return
	 */
	public static View findView(LayoutInflater layoutInflater, int VId) {
		return layoutInflater == null ? null : layoutInflater.inflate(VId, null);
	}

	/**
	 * LayoutInflater XML
	 * 
	 * @param layoutInflater
	 * @param root
	 * @param VId
	 * @return
	 */
	public static View findView(LayoutInflater layoutInflater, ViewGroup root, int VId) {
		return layoutInflater == null ? null : layoutInflater.inflate(VId, root, false);
	}
}

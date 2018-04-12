package com.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BFragment extends Fragment {
	// 标志位，标志已经初始化完成。
	private boolean isLoad;
	protected View view;
	protected Bundle savedInstanceState;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		view = getView(inflater, container);
		loadView();
		return view;
	}

	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		this.savedInstanceState = savedInstanceState;
		onActivityCreated();
	}

	/**
	 * 在这里实现Fragment数据的缓加载.
	 * 
	 * @param isVisibleToUser
	 */
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
		if (isVisibleToUser && !isLoad) {
			isLoad = true;
			lazyLoad();
		}
	}

	/**
	 * 第一次懒加载调用
	 */
	protected void lazyLoad() {
	}

	/**
	 * 获取View
	 */
	protected abstract View getView(LayoutInflater inflater, ViewGroup container);

	/**
	 * loadView View view
	 * 
	 * @param view
	 */
	protected abstract void loadView();

	/**
	 * onCreate
	 */
	protected abstract void onActivityCreated();

	/**
	 * findViewById
	 * 
	 * @param resId
	 * @return
	 */
	public View findViewById(int resId) {
		return view != null ? view.findViewById(resId) : null;
	}
}

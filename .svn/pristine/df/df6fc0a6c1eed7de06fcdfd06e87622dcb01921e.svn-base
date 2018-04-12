package com.base;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

/**
 * 适配器类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public abstract class BAdapter<T> extends BaseAdapter{
	public Context context;
	public List<T> matters;
	protected LayoutInflater layoutInflater;
	public BAdapter(Context context,List<T> matters){
		this.context = context;
		this.layoutInflater = LayoutInflater.from(context);
		refresh(matters);
	}
	//刷新Adapter
	public void refresh(List<T> matters){
		this.matters = matters;
		notifyDataSetChanged();
	}
	/* (non-Javadoc)
	 * @see android.widget.Adapter#getCount()
	 */
	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return matters!=null?matters.size():0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItem(int)
	 */
	@Override
	public Object getItem(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getItemId(int)
	 */
	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return arg0;
	}

	/* (non-Javadoc)
	 * @see android.widget.Adapter#getView(int, android.view.View, android.view.ViewGroup)
	 */
	@Override
	public View getView(int position, View view, ViewGroup arg2) {
		return getView(position, this.matters.get(position), view);
	}

	// 获取View
	public View getView(int position, T t, View view) {
		return getView(t, view);
	}
	//获取View
	public abstract View getView(T t, View view);
}
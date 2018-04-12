package com.util;

import java.io.File;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.net.Uri;
import android.widget.ImageView;

public class PicassoUtils {
	// LoadURL
	public static void loadUrlPic(Context context, ImageView iv, String url) {
		if (context != null && iv != null && !StringUtils.isEmptyString(url)) {
			Picasso.with(context).load(url).into(iv);
		}
	}

	// LoadURL
	public static void loadUrlPic(Context context, ImageView iv, String url, int loadingResId, int loadErrorResId) {
		if (context != null && iv != null) {
			if (StringUtils.isEmptyString(url)) {
				iv.setImageResource(loadErrorResId);
			} else {
				Picasso.with(context).load(url).placeholder(loadingResId).error(loadErrorResId).into(iv);
			}
		}
	}

	// LoadRes
	public static void loadResPic(Context context, ImageView iv, int resId) {
		if (context != null && iv != null) {
			Picasso.with(context).load(resId).into(iv);
		}
	}

	// LoadFile
	public static void loadFilePic(Context context, ImageView iv, File file) {
		if (context != null && iv != null && file.exists()) {
			Picasso.with(context).load(file).into(iv);
		}
	}

	// LoadURI
	public static void loadUriPic(Context context, ImageView iv, Uri uri) {
		if (context != null && iv != null && uri != null) {
			Picasso.with(context).load(uri).into(iv);
		}
	}
}

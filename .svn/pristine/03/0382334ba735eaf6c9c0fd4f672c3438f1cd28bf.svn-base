package com.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.os.Environment;

/**
 * 文件处理 工具类
 * 
 * @version 1.0
 * @date 2017
 * @author kuiYang
 */
public class FileUtils {
	/**
	 * String 获取可用的本地存储空间
	 * 
	 * @return "目录路径"
	 */
	public static String GetStorageDir(Context context) {
		String cachePath = context.getCacheDir().getPath();
		if (Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
				|| !Environment.isExternalStorageRemovable()) {
			cachePath = context.getExternalCacheDir().getPath();
		} else {
			cachePath = context.getCacheDir().getPath();
		}
		return cachePath;
	}

	/**
	 * 字节转兆
	 * 
	 * @param bytes
	 * @return
	 */
	public static float byte2M(long bytes) {
		BigDecimal byteValue = new BigDecimal(bytes);
		BigDecimal unitValue = new BigDecimal(1024 * 1024);
		float formatValue = byteValue.divide(unitValue, 2, BigDecimal.ROUND_UP).floatValue();
		return formatValue;
	}

	/**
	 * 获取文件夹大小
	 *
	 * @param file
	 *            File实例
	 * @return long 单位为M
	 * @throws Exception
	 */
	public static long getFolderSize(File file) throws Exception {
		long size = 0;
		File[] fileList = file.listFiles();
		for (int i = 0; i < fileList.length; i++) {
			if (fileList[i].isDirectory()) {
				size = size + getFolderSize(fileList[i]);
			} else {
				size = size + fileList[i].length();
			}
		}
		return size / 1048576;
	}

	/**
	 * 删除路径下一个文件
	 * 
	 * @param path
	 */
	public static void deleteFile(String path) {
		if (!StringUtils.isEmptyString(path)) {
			File file = new File(path);
			deleteFile(file);
		}
	}

	/**
	 * 删除一个文件
	 * 
	 * @param path
	 */
	public static void deleteFile(File file) {
		if (file != null && file.exists() && file.isFile()) {
			file.delete();
		}
	}

	/**
	 * 删除路径下所有文件或目录
	 * 
	 * @param path
	 */
	public static void deleteAllFile(String path) {
		if (!StringUtils.isEmptyString(path)) {
			File file = new File(path);
			deleteAllFile(file);
		}
	}

	/**
	 * 删除所有文件或目录
	 * 
	 * @param path
	 */
	public static void deleteAllFile(File file) {
		if (file != null && file.exists()) {
			try {
				if (file.isFile()) {
					file.delete();
				} else if (file.isDirectory()) {
					File[] files = file.listFiles();
					// 删除FIle
					for (int i = 0; i < files.length; i++) {
						try {
							File f = files[i];
							deleteAllFile(f);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * 判断路径下文件是否存在
	 * 
	 * @param path
	 * @return
	 */
	public static boolean isExists(String path) {
		return new File(path).exists();
	}

	/**
	 * 创建文件,如果deleteExists为true,表示路径下文件存在，将删除文件，重新创建新文件；为false，表示路径文件下文件存在，不删除已存在文件
	 * 
	 * @param path
	 */
	public static boolean createFile(String path, boolean deleteExists) {
		if (!StringUtils.isEmptyString(path)) {
			try {
				File file = new File(path);
				if (file.exists()) {
					if (deleteExists) {
						return createFile(path);
					}
				} else {
					return createFile(path);
				}
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
		return true;
	}

	/**
	 * 创建文件，无论路径下文件是否存在，将删除文件，并创建新文件
	 * 
	 * @param path
	 */
	public static boolean createFile(String path) {
		if (!StringUtils.isEmptyString(path)) {
			try {
				File file = new File(path);
				// 删除已有的文件
				deleteFile(file);
				// 获取父目录是否存在，否则创建
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 创建文件，无论路径下文件是否存在，将删除文件，并创建新文件
	 * 
	 * @param path
	 */
	public static boolean createFile(File file) {
		if (file != null) {
			try {
				// 删除已有的文件
				deleteFile(file);
				// 获取父目录是否存在，否则创建
				if (!file.getParentFile().exists()) {
					file.getParentFile().mkdirs();
				}
				return file.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return false;
	}

	/**
	 * 创建指定路径的目录
	 * 
	 * @param path
	 * @return
	 */
	public static boolean createFileDir(String path) {
		try {
			File file = new File(path);
			if (file.exists()) {
				return false;
			} else {
				// 如果要创建的多级目录不存在才需要创建。
				return file.mkdirs();
			}
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf/ff
	 * @return boolean
	 */
	public static boolean copyFolder(String oldPath, String newPath) {
		try {
			(new File(newPath)).mkdirs(); // 如果文件夹不存在 则建立新文件夹
			File a = new File(oldPath);
			String[] file = a.list();
			File temp = null;
			for (int i = 0; i < file.length; i++) {
				if (oldPath.endsWith(File.separator)) {
					temp = new File(oldPath + file[i]);
				} else {
					temp = new File(oldPath + File.separator + file[i]);
				}

				if (temp.isFile()) {
					FileInputStream input = new FileInputStream(temp);
					FileOutputStream output = new FileOutputStream(newPath + "/" + (temp.getName()).toString());
					byte[] b = new byte[1024 * 5];
					int len;
					while ((len = input.read(b)) != -1) {
						output.write(b, 0, len);
					}
					output.flush();
					output.close();
					input.close();
				}
				if (temp.isDirectory()) {// 如果是子文件夹
					copyFolder(oldPath + "/" + file[i], newPath + "/" + file[i]);
				}
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @param oldPath
	 *            String 原文件路径 如：c:/fqf.txt
	 *            注意路径不能是远程路径如http://img.mokacn.com/static
	 *            /44/1/20110426175644706.gif
	 * @param newPath
	 *            String 复制后路径 如：f:/fqf.txt
	 * @return boolean
	 */
	@SuppressWarnings("resource")
	public static boolean copyFile(String oldPath, String newPath) {
		try {
			int byteread = 0;
			File oldfile = new File(oldPath);
			if (oldfile.exists()) { // 文件存在时
				InputStream inStream = new FileInputStream(oldPath); // 读入原文件
				FileOutputStream fs = new FileOutputStream(newPath);
				byte[] buffer = new byte[1444];
				while ((byteread = inStream.read(buffer)) != -1) {
					fs.write(buffer, 0, byteread);
				}
				inStream.close();
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	/**
	 * 从文件中读取字节数组
	 * 
	 * @param filePath
	 * @return
	 * @throws Exception
	 */
	@SuppressWarnings({ "unused", "resource" })
	public static byte[] readByteFromFile(String filePath) throws Exception {
		File file = new File(filePath);
		FileInputStream fis = new FileInputStream(file);
		if (fis != null) {
			int len = fis.available();
			byte[] bs = new byte[len];
			fis.read(bs);
			return bs;
		}
		return null;
	}

	/**
	 * 把字节写入到文件
	 * 
	 * @param file
	 * @param bs
	 * @throws Exception
	 */
	public static void writeByteToFile(File file, byte[] bs) throws Exception {
		createFile(file);
		FileOutputStream out = null;
		try {
			out = new FileOutputStream(file);
			out.write(bs);
			out.flush();

		} catch (UnsupportedEncodingException e) {
			e.fillInStackTrace();
		} catch (FileNotFoundException e) {
			e.fillInStackTrace();
		} catch (IOException e) {
			e.fillInStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.fillInStackTrace();
			}
		}

	}

	/**
	 * 内容写文件
	 * 
	 * @param file
	 * @param content
	 * @param encoding
	 * @throws Exception
	 */
	public static void writeFile(File file, String content, String encoding) throws Exception {
		createFile(file);
		BufferedWriter out = null;
		try {
			out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(file), encoding));
			out.write(content);
			out.flush();
		} catch (UnsupportedEncodingException e) {
			e.fillInStackTrace();
		} catch (FileNotFoundException e) {
			e.fillInStackTrace();
		} catch (IOException e) {
			e.fillInStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.fillInStackTrace();
			}
		}

	}

	/**
	 * 读取文件到List<String>
	 * 
	 * @param filePath
	 * @param encode
	 * @return
	 */
	public static List<String> readLine(String filePath, String encode) {
		List<String> s = new ArrayList<String>();
		File file = new File(filePath);
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), encode));
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				s.add(tempString);
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (IOException e1) {
				}
			}
		}
		return s;
	}

	/**
	 * 流转字符串
	 *
	 * @param is
	 * @return
	 */
	public static String inputStream2String(InputStream is) {
		BufferedReader in = new BufferedReader(new InputStreamReader(is));
		StringBuffer buffer = new StringBuffer();
		String line = "";
		try {
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return buffer.toString();
	}

	/**
	 * 字符串转流
	 *
	 * @param str
	 * @return
	 */
	public static InputStream String2InputStream(String str) {
		ByteArrayInputStream stream = new ByteArrayInputStream(str.getBytes());
		return stream;
	}
}

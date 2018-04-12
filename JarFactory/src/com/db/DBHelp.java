package com.db;

import java.util.List;

import com.App;
import com.litesuits.orm.LiteOrm;
import com.litesuits.orm.db.assit.QueryBuilder;
import com.litesuits.orm.db.assit.WhereBuilder;
import com.litesuits.orm.db.model.ConflictAlgorithm;

import android.content.Context;

/**
 * @author 作者 E-mail:
 * @date 创建时间：2015年9月14日 下午4:01:07
 * @version 1.0
 * @parameter
 */
public class DBHelp {
	private static LiteOrm liteOrm;

	public static boolean createDb(Context context, String dbName) {
		try {
			liteOrm = LiteOrm.newSingleInstance(context, dbName);
			liteOrm.setDebugged(App.config.isDebug());
			if (liteOrm == null) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			System.out.println("数据库创建失败");
			return true;
		}
	}

	public static LiteOrm getLiteOrm() {
		return liteOrm;
	}

	/**
	 * 插入一条记录
	 * 
	 * @param t
	 */
	public static <T> void insert(T t) {
		liteOrm.save(t);
	}

	/**
	 * 插入所有记录
	 * 
	 * @param list
	 */
	public static <T> void insertAll(List<T> list) {
		liteOrm.save(list);
	}

	/**
	 * 查询所有
	 * 
	 * @param cla
	 * @return
	 */
	public static <T> List<T> getQueryAll(Class<T> cla) {
		return liteOrm.query(cla);
	}

	/**
	 * 查询 某字段 等于 Value的值
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @return
	 */
	public static <T> List<T> getQueryByWhere(Class<T> cla, String field, String[] value) {
		return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value));
	}

	/**
	 * 查询 多个字段字段 等于 Value的值
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @return
	 */
	public static <T> List<T> getQueryByWhere(Class<T> cla, WhereBuilder whereBuilder) {
		return liteOrm.<T>query(new QueryBuilder(cla).where(whereBuilder));
	}

	/**
	 * getQueryByLongId
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @return
	 * @return
	 */
	public static <T> T getQueryById(long id, Class<T> cla) {
		return liteOrm.queryById(id, cla);
	}

	/**
	 * getQueryByStringId
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @return
	 * @return
	 */
	public static <T> T getQueryById(String id, Class<T> cla) {
		return liteOrm.queryById(id, cla);
	}

	/**
	 * 查询 某字段 等于 Value的值 可以指定从1-20，就是分页
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 * @param start
	 * @param length
	 * @return
	 */
	public static <T> List<T> getQueryByWhereLength(Class<T> cla, String field, String[] value, int start, int length) {
		return liteOrm.<T>query(new QueryBuilder(cla).where(field + "=?", value).limit(start, length));
	}

	/**
	 * 删除所有 某字段等于 Vlaue的值
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 */
	public static <T> void deleteWhere(Class<T> cla, String field, String[] value) {
		liteOrm.delete(cla, WhereBuilder.create(cla).where(field + "=?", value));
	}

	/**
	 * 删除所有 某字段等于 Vlaue的值
	 * 
	 * @param cla
	 * @param field
	 * @param value
	 */
	public static <T> void deleteWhere(Class<T> cla, WhereBuilder whereBuilder) {
		liteOrm.delete(cla, whereBuilder);
	}

	/**
	 * 删除所有
	 * 
	 * @param cla
	 */
	public static <T> void deleteAll(Class<T> cla) {
		liteOrm.deleteAll(cla);
	}

	/**
	 * 仅在以存在时更新
	 * 
	 * @param t
	 */
	public static <T> void update(T t) {
		liteOrm.update(t, ConflictAlgorithm.Replace);
	}

	public static <T> void updateALL(List<T> list) {
		liteOrm.update(list);
	}
}
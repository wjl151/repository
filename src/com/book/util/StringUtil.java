package com.book.util;
/**
 * 字符串工具
 * @author 武金龙
 *
 */
public class StringUtil {
	/**
	 * 判断字符串是否为空是则返回false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return false;
		}else return true;
	}
}

package com.book.util;
/**
 * �ַ�������
 * @author �����
 *
 */
public class StringUtil {
	/**
	 * �ж��ַ����Ƿ�Ϊ�����򷵻�false
	 * @param str
	 * @return
	 */
	public static boolean isEmpty(String str) {
		if(str==null || "".equals(str.trim())) {
			return false;
		}else return true;
	}
}

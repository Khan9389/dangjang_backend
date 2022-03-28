package com.semi.dangjang.common;

public class StringUtil {
	public static String nullToValue(Object ob, String value) {
		if(ob==null)
			return value;
		else
			return ob.toString();
	}
}

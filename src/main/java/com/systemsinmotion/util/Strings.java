package com.systemsinmotion.util;

public class Strings extends org.springframework.util.StringUtils {

	public static String concat(Object... objects) {
		StringBuilder sb = new StringBuilder();
		for (Object obj : objects) {
			if (obj != null) {
				sb.append(String.valueOf(obj));
			}
		}
		return sb.toString();
	}
}

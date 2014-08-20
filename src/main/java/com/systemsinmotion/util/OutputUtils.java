package com.systemsinmotion.util;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

//import org.apache.log4j.Logger;

public class OutputUtils {
//	private static Logger LOG = Logger.getLogger(OutputUtils.class);

	private static final String GET = "get";
	private static final String IS = "is";

	public static String toString(String string) {
		return string;
	}

	public static String toString(Collection<?> collection) {
		StringBuilder sb = new StringBuilder();
		if (collection == null) {
			sb.append("Collection<?> is null");
		} else {
			sb.append(collection.getClass().getCanonicalName()).append(" [ ");

			for (Object obj : collection) {
				sb.append(obj.toString()).append(", ");
			}
			if (sb.indexOf(",") >= 0) {
				sb.setLength(sb.length() - 2);
			}
			sb.append("]");
		}
		return sb.toString();
	}

	/**
	 * Iterates over members of a Map and add their String values to the
	 * returned String
	 * 
	 * @param map
	 *            to be converted to a String
	 * @return a string representation of this Map
	 */
	public static String toString(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();
		if (map == null) {
			sb.append("Map<?, ?> is null");
		} else {
			sb.append(map.getClass().getCanonicalName()).append(" [ ");

			Set<?> keySet = map.keySet();
			for (Object key : keySet) {
				sb.append(key.toString()).append("=").append(map.get(key).toString()).append(", ");
			}
			if (sb.indexOf(",") >= 0) {
				sb.setLength(sb.length() - 2);
			}
			sb.append("]");
		}
		return sb.toString();
	}

	public static String toString(Object obj) {
		Class<?> c = obj.getClass();
		String className = c.getCanonicalName();

		StringBuilder sb = new StringBuilder(className).append(" [");

		Field[] fields = c.getDeclaredFields();
		for (Field field : fields) {
			String fieldName = field.getName();
			if (!fieldName.equals("this$0")) {
				// sb.append("\n\t").append(fieldName).append(": ");
				Object fieldValue = fieldValue(obj, field);
				if (fieldValue != null) {
					String result = null;
					if (fieldValue instanceof Collection<?>) {
						result = toString((Collection<?>) fieldValue);
					} else if (fieldValue instanceof Map<?, ?>) {
						result = toString((Map<?, ?>) fieldValue);
					} else {
						result = String.valueOf(fieldValue);
					}
					if (result != null) {
						sb.append("\n\t").append(fieldName).append(": ").append(result)
								.append(", ");
					}
				}
				// sb.append(result).append(", ");
			}
		}

		sb.setLength(sb.length() - 2);
		sb.append("\n]");

		System.out.println(sb.toString());

		return sb.toString();
	}

	private static Object fieldValue(Object obj, Field field) {
		String fieldName = field.getName();
		Object result = null;
		if (Modifier.isPublic(field.getModifiers())) {
			try {
				result = field.get(obj);
			} catch (Exception e) {
//				LOG.error("error while getting value of public field: " + fieldName);
			}
		} else {
			try {
				result = getterMethod(obj, fieldName).invoke(obj, new Object[0]);
			} catch (Exception e) {
//				LOG.error("no public getter for " + fieldName);
			}
		}
		return result;
	}

	private static Method getterMethod(Object obj, String fieldName) throws SecurityException,
			NoSuchMethodException {
		Class<?>[] types = new Class[] {};
		Method method = null;
		String getterName;
		try {
			getterName = getterMethodName(fieldName, GET);
			method = obj.getClass().getMethod(getterName, types);
		} catch (Exception e) {
			getterName = getterMethodName(fieldName, IS);
			method = obj.getClass().getMethod(getterName, types);
		}
		return method;
	}

	static String getterMethodName(String fieldName, String prefix) {
		if (fieldName.startsWith("_")) {
			fieldName = fieldName.substring(1);
		}
		return new StringBuilder(prefix).append(Character.toUpperCase(fieldName.charAt(0)))
				.append(fieldName.substring(1)).toString();
	}

}
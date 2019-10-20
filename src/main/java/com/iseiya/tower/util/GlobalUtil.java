package com.iseiya.tower.util;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author ying.wang2
 */
public class GlobalUtil {

	public static String getRequestURI(String requestUrl, Map<String, String> paramMap)
			throws UnsupportedEncodingException, NoSuchAlgorithmException {
		if (paramMap == null) {
			paramMap = new LinkedHashMap<>();
		}

		StringBuilder builder = new StringBuilder(requestUrl);
		
		Iterator<Map.Entry<String, String>> it=paramMap.entrySet().iterator();
		while(it.hasNext()) {
			Map.Entry<String,String> entry=it.next();
			String entryKey = entry.getKey();
			String entryValue = entry.getValue();
			builder.append("&");
			builder.append(entryKey);
			builder.append("=");
			builder.append(URLEncoder.encode(entryValue, GlobalConstants.DEFAULT_ENCODING));
		}
		requestUrl = builder.toString();
		return requestUrl.replaceFirst("&", "?");
	}



}

package com.iseiya.tower.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;


/*
 * author: ying.wang2
 * http client 工具类
 * */
@Slf4j
public class HttpClientUtil {

	// get方法 （目前需求只用到了get方法）
	public static String get(String requestUrl, Map<String, String> paramMap, Map<String, String> headerMaps) {
		String responseContent = "";
		String originalResponse = "";
		CloseableHttpClient httpClient = null;
		CloseableHttpResponse httpResponse = null;
		try {
			httpClient = HttpClients.createDefault();

			if (paramMap != null && !paramMap.isEmpty()) {
				requestUrl = GlobalUtil.getRequestURI(requestUrl, paramMap);
			}

			HttpGet httpGet = new HttpGet(requestUrl);
			httpGet.setHeader("Accept", "application/json;charset=UTF-8");
			httpGet.setHeader("Content-Type", "application/json;charset=UTF-8");

			if (headerMaps != null && !headerMaps.isEmpty()) {
				
				Iterator<Map.Entry<String, String>> it=headerMaps.entrySet().iterator();
				while(it.hasNext()) {
					Map.Entry<String,String> entry=it.next();
					String entryKey = entry.getKey();
					String entryValue = entry.getValue();
					httpGet.addHeader(entryKey, entryValue);
					log.info("key : " + entryKey);
					log.info("value : " + entryValue);
				}
			}

			httpResponse = httpClient.execute(httpGet);

			HttpEntity entity = httpResponse.getEntity();

			int statusCode = httpResponse.getStatusLine().getStatusCode();
			if (statusCode == HttpStatus.SC_OK && entity != null) {
				originalResponse = EntityUtils.toString(entity, GlobalConstants.DEFAULT_ENCODING);
				responseContent = originalResponse;
			} else {
				System.err.println("http request failed ! ");
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (httpResponse != null) {
					httpResponse.close();
				}
				if (httpClient != null) {
					httpClient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return responseContent;
	}


	/**
	 * 这个方法是从老代码搬运过来的。但是写的比较简陋
	 * @Title: httpGet
	 */
	public static String httpGet(String url) throws ClientProtocolException, IOException {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		CloseableHttpResponse response = httpclient.execute(httpGet);
		try {
			HttpEntity entity = response.getEntity();
			String strResult = EntityUtils.toString(entity);
			return strResult;
		} finally {
			try {
				if (response != null) {
					response.close();
				}
				if (httpclient != null) {
					httpclient.close();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}

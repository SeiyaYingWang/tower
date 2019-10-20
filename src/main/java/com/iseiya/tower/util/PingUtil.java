package com.iseiya.tower.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


import lombok.extern.slf4j.Slf4j;
import org.springframework.util.StringUtils;

/**
 * 测试IP是否能拼通的工具类
 */
@Slf4j
public class PingUtil {



	/**
	 * 测试IP是否可以ping通
	 * 
	 * @param ip
	 * @throws Exception
	 */
	public static boolean ping(String ip) throws Exception {
		// 非法IP,返回false
		if (!isValidIPV4(ip)) {
			return false;
		}

		// 默认的超时时间, 超时应该在3钞以上        
		int timeOut = 3000;

		// 当返回值是true时，说明host是可用的，false则不可。
		boolean usable = InetAddress.getByName(ip).isReachable(timeOut);

		// 返回是否可用的状态
		return usable;
	}



	/**
	 * 测试IP是否可以ping通(如：指定ping 5次,如果5次都成功才返回 true)
	 *
	 * @param ip
	 * @param expectPingTimes
	 * @param timeOut
	 * @return
	 */
	public static boolean ping(String ip, int expectPingTimes, int timeOut) {
		// 非法IP,返回false
		if (!isValidIPV4(ip)) {
			return false;
		}

		BufferedReader in = null;
		Runtime run = Runtime.getRuntime();

		// 将要执行的ping命令,此命令是windows格式的命令
		String command = "ping " + ip + " -n " + expectPingTimes + " -w " + timeOut;
		log.info(command);

		try {
			Process p = run.exec(command);
			if (p == null) {
				return false;
			}

			// 逐行检查输出,计算类似出现=23ms TTL=62字样的次数
			in = new BufferedReader(new InputStreamReader(p.getInputStream()));
			int connectedTimes = 0;
			String line = null;
			while ((line = in.readLine()) != null) {
				// 如果出现类似=23ms TTL=62这样的字样,出现的次数=测试次数则返回真
				connectedTimes += getCheckResult(line);
			}

			return connectedTimes == expectPingTimes;
		} catch (Exception e) {
			log.error(e.getMessage(), e);

			return false;
		} finally {
			try {
				in.close();
			} catch (IOException e) {
				// e.printStackTrace();
			}
		}
	}

	// 若line含有=18ms TTL=16字样,说明已经ping通,返回1,否則返回0.
	private static int getCheckResult(String line) {
		Pattern pattern = Pattern.compile("(\\d+ms)(\\s+)(TTL=\\d+)", Pattern.CASE_INSENSITIVE);
		Matcher matcher = pattern.matcher(line);
		while (matcher.find()) {
			return 1;
		}
		return 0;
	}

	/**
	 * 校验IP格式是否合法,合法返回true,不合法返回false
	 */
	public static boolean isValidIPV4(String ip) {
		// 空IP,返回false
		if (StringUtils.isEmpty(ip) || !ip.matches("^\\d+\\.\\d+\\.\\d+\\.\\d+$")) {
			return false;
		}

		// 1-255, 0-255, 0-255, 0-255
		String[] arr = ip.split("\\.");
		if (isBetween(arr[0], 1, 255) && isBetween(arr[1], 0, 255) && isBetween(arr[2], 0, 255)
				&& isBetween(arr[3], 0, 255)) {
			return true;
		}

		return false;
	}

	// value的数字是否在某两个值之间
	private static boolean isBetween(String val, int start, int end) {
		int value = Integer.parseInt(val);
		if (value >= start && value <= end) {
			return true;
		}
		return false;
	}


}

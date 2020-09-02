package com.thhy.zhgd.util;

import cn.hutool.core.util.HexUtil;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

import java.util.ArrayList;
import java.util.List;

public class MessageParseUtil {
	public static String getKindStrByMessage(String s) {
		ByteBuf buf = Unpooled.copiedBuffer(s.getBytes());

		byte[] bytes = new byte[2];
		buf.getBytes(4, bytes);
		ReferenceCountUtil.release(buf);

		return new String(bytes, CharsetUtil.UTF_8);
	}

	public static String str2HexStr(String str) {
		char[] chars = "0123456789ABCDEF".toCharArray();
		StringBuilder sb = new StringBuilder("");
		byte[] bs = str.getBytes();
		int bit;
		for (int i = 0; i < bs.length; i++) {
			bit = (bs[i] & 0x0f0) >> 4;
			sb.append(chars[bit]);
			bit = bs[i] & 0x0f;
			sb.append(chars[bit]);
			// sb.append(' ');
		}
		return sb.toString().trim();
	}

	public static Integer[] str2HexArr(String hexStr) {
		List<Integer> result = new ArrayList<>();

		char[] chars = hexStr.toCharArray();

		for (int i = 0; i < chars.length; ) {
			char[] cs = new char[2];
			cs[0] = chars[i++];
			if (i < chars.length) {
				cs[1] = chars[i++];
			}
			String s = new String(cs);
			int i1 = Integer.parseInt(s, 16);
			result.add(i1);
		}

		Integer[] res = new Integer[result.size()];
		result.toArray(res);
		return res;
	}

	public static boolean checkIsTrue(Integer[] arr) {
		if (arr.length < 6) {
			return false;
		}
		if (arr[0] == 0xA5 && arr[1] == 0x5A && arr[arr.length - 1] == 0x3c && arr[arr.length - 2] == 0xC3 && arr[arr.length - 3] == 0x33 && arr[arr.length - 4] == 0xCC && checkSum(arr)) {
			return true;
		}
		return false;
	}

	private static boolean checkSum(Integer[] arr) {
		//TODO 和校验
		return false;
	}
}
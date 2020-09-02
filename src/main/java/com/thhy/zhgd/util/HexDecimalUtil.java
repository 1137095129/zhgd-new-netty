package com.thhy.zhgd.util;

public class HexDecimalUtil {

	public static String getHexStrByDecimal(Integer i) {
		return Integer.toHexString(i);
	}

	public static Integer getDecimalByHexadecimal(String s) {
		char[] chars = s.toCharArray();
		int i = 1;
		int result = 0;
		for (int i1 = chars.length - 1; i1 >= 0; i1--) {
			result += i * getDecimalByChar(chars[i1]);
			i = i * 16;
		}
		return result;
	}

	private static Integer getDecimalByChar(char c) {
		if (c == 'A')
			return 10;
		if (c == 'B')
			return 11;
		if (c == 'C')
			return 12;
		if (c == 'D')
			return 13;
		if (c == 'E')
			return 14;
		if (c == 'F')
			return 15;
		if (c == '1')
			return 1;
		if (c == '2')
			return 2;
		if (c == '3')
			return 3;
		if (c == '4')
			return 4;
		if (c == '5')
			return 5;
		if (c == '6')
			return 6;
		if (c == '7')
			return 7;
		if (c == '8')
			return 8;
		if (c == '9')
			return 9;
		throw new RuntimeException("非法的16进制值！");
	}
}

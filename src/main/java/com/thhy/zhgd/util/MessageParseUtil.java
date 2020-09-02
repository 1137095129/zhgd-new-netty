package com.thhy.zhgd.util;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.util.CharsetUtil;
import io.netty.util.ReferenceCountUtil;

public class MessageParseUtil {
	public static String getKindStrByMessage(String s) {
		ByteBuf buf = Unpooled.copiedBuffer(s.getBytes());

		byte[] bytes = new byte[2];
		buf.getBytes(4, bytes);
		ReferenceCountUtil.release(buf);

		return new String(bytes, CharsetUtil.UTF_8);
	}
}
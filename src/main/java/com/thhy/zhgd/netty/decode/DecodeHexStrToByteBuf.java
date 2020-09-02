package com.thhy.zhgd.netty.decode;

import cn.hutool.core.util.HexUtil;
import com.thhy.zhgd.entity.*;
import com.thhy.zhgd.netty.decode.load.AbstractLoadObject;
import com.thhy.zhgd.util.DataMessageKind;
import com.thhy.zhgd.util.IlegalKindException;
import com.thhy.zhgd.util.MessageParseUtil;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 在使用单例模式进行handler共享时，需要在类上标注注解{@link ChannelHandler.Sharable}，
 * 但是由于decoder不能再多线程中安全地共享，所以不能标注注解{@link ChannelHandler.Sharable}
 */
public class DecodeHexStrToByteBuf extends ByteToMessageDecoder {

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		int i = byteBuf.readableBytes();
		byteBuf.readBytes(i);
		byte[] TMP = new byte[i];
		byteBuf.getBytes(byteBuf.readerIndex(), TMP);
		String s = new String(TMP);
		String s1 = MessageParseUtil.str2HexStr(s);

		Integer[] arr = MessageParseUtil.str2HexArr(s1);

		if(!MessageParseUtil.checkIsTrue(arr)){
			return;
		}

		//向右便宜4个字节，获取帧类型
		byte[] bytes = new byte[2];
		byteBuf.getBytes(4, bytes);

		//通过帧类型获取信息种类，并判断当前可读字节是否已大于或等于该帧类型的长度，是则进行数据解析，否则不进行数据解析
		DataMessageKind kind = DataMessageKind.getDataMessageKindByKindName(new String(bytes, CharsetUtil.UTF_8));

		list.add(getMessage(kind, arr));
	}

	private DataMessage getMessage(DataMessageKind kind, Integer[] arr) {
		return kind.getLoadObject().loadDataMessage(kind, arr);
	}


}

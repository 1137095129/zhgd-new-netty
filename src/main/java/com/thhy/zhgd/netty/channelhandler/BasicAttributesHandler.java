package com.thhy.zhgd.netty.channelhandler;

import com.thhy.zhgd.entity.DataMessage;
import com.thhy.zhgd.util.DataMessageKind;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 基础信息设置
 */
@ChannelHandler.Sharable
@Component("BasicAttributesHandler")
public class BasicAttributesHandler extends AbstractHandlerCustomized {

	@Override
	protected boolean checkMessageKind(Object msg) {
		DataMessage message = (DataMessage) msg;
		return message.getKind() == DataMessageKind.BASIC_ATTRIBUTES;
	}

	@Override
	public void execute(ChannelHandlerContext ctx, Object msg) throws Exception {

	}
}

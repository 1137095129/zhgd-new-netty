package com.thhy.zhgd.netty.channelhandler;

import com.thhy.zhgd.entity.DataMessage;
import com.thhy.zhgd.util.DataMessageKind;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 心跳信息处理
 */
@ChannelHandler.Sharable
@Component("KeepAliveHandler")
public class KeepAliveHandler extends AbstractHandlerCustomized {

	@Override
	protected boolean checkMessageKind(Object msg) {
		DataMessage message = (DataMessage) msg;
		return message.getKind() == DataMessageKind.KEEP_ALVIE_FROM_CLIENT;
	}

	@Override
	public void execute(ChannelHandlerContext ctx, Object msg) throws Exception {

	}
}

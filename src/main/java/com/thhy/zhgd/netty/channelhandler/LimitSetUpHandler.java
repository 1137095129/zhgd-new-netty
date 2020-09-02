package com.thhy.zhgd.netty.channelhandler;

import com.thhy.zhgd.entity.DataMessage;
import com.thhy.zhgd.util.DataMessageKind;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 限位信息设置处理
 */
@ChannelHandler.Sharable
@Component("LimitSetUpHandler")
public class LimitSetUpHandler extends AbstractHandlerCustomized {

	@Override
	protected boolean checkMessageKind(Object msg) {
		DataMessage message = (DataMessage) msg;
		return message.getKind() == DataMessageKind.LIMIT_SET_UP;
	}

	@Override
	public void execute(ChannelHandlerContext ctx, Object msg) throws Exception {

	}
}

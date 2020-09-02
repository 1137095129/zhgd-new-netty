package com.thhy.zhgd.netty.channelhandler;

import com.thhy.zhgd.entity.DataMessage;
import com.thhy.zhgd.util.DataMessageKind;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import org.springframework.stereotype.Component;

/**
 * 工作循环数据处理
 */
@ChannelHandler.Sharable
@Component("WorkCycleInformationHandler")
public class WorkCycleInformationHandler extends AbstractHandlerCustomized {

	@Override
	protected boolean checkMessageKind(Object msg) {
		DataMessage message = (DataMessage) msg;
		return message.getKind() == DataMessageKind.WORK_CYCLE_INFORMATION;
	}

	@Override
	public void execute(ChannelHandlerContext ctx, Object msg) throws Exception {

	}
}

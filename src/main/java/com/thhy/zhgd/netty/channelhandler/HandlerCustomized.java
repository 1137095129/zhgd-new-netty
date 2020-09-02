package com.thhy.zhgd.netty.channelhandler;

import io.netty.channel.ChannelHandlerContext;

/**
 * 业务定制操作
 */
public interface HandlerCustomized {

	void execute(ChannelHandlerContext ctx, Object msg) throws Exception;

}

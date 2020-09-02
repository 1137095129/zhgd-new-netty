package com.thhy.zhgd.netty.channelhandler;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.ChannelInboundHandlerAdapter;
import io.netty.util.ReferenceCountUtil;

public abstract class AbstractHandlerCustomized extends ChannelInboundHandlerAdapter implements HandlerCustomized {

	/**
	 * 为所有子类提供的公共方法，获取信息并判断该信息是否为该类所处理的信息，
	 * 是则执行{@link #execute(ChannelHandlerContext, Object)}方法，
	 * 不是则交由下一个handler执行处理
	 *
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	public void channelRead(ChannelHandlerContext ctx, Object msg) throws Exception {
		if (!checkMessageKind(msg)) {
			ctx.fireChannelRead(msg);
			return;
		}
		try {
			execute(ctx, msg);
		} finally {
			ReferenceCountUtil.release(msg);
		}
	}

	/**
	 * 检查是否是本类处理的种类，
	 * 由子类实现，父类只负责调用
	 * @param msg
	 * @return
	 */
	protected abstract boolean checkMessageKind(Object msg);

	/**
	 * 对消息进行处理，该父类只提供默认实现，具体实现交由各自子类实现
	 *
	 * @param ctx
	 * @param msg
	 * @throws Exception
	 */
	@Override
	public void execute(ChannelHandlerContext ctx, Object msg) throws Exception {
		throw new RuntimeException("该类未实现该方法！");
	}
}

package com.thhy.zhgd.netty;

import com.thhy.zhgd.config.NettyServerConfigProperties;
import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelHandler;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Component("NettyServer")
public class NettyServer {

	private final static Logger log = LoggerFactory.getLogger(NettyServer.class);

	@Autowired
	private NettyServerConfigProperties properties;

	@Autowired
	@Qualifier("NettyServerChannelInitializer")
	private ChannelHandler channelHandler;

	private EventLoopGroup boss;
	private EventLoopGroup work;
	private Channel channel;

	/**
	 * 初始化netty服务器信息
	 */
	@PostConstruct
	public void initEventLoopGroup() {
		log.info("Initializing netty-server's event loop group.");
		boss = new NioEventLoopGroup(properties.getBossThreadCount());
		work = new NioEventLoopGroup(properties.getWorkThreadCount());
		log.info("Initialized netty-server's event loop group");
	}

	/**
	 * 启动netty服务器
	 * @throws InterruptedException
	 */
	public void start() throws InterruptedException {
		log.info("Starting netty-server.");
		ServerBootstrap bootstrap = new ServerBootstrap();
		ChannelFuture future = bootstrap.group(boss, work)
				.channel(NioServerSocketChannel.class)
				.childHandler(channelHandler)
				.bind(properties.getPort())
				.sync();
		if (future.isSuccess())
			channel = future.channel();
		log.info("Started netty-server successfully!");
	}

	/**
	 * 关闭netty服务器
	 * @throws InterruptedException
	 */
	@PreDestroy
	public void stopNettyServer() throws InterruptedException {

		log.info("Closing netty-server.");

		if (channel != null) {
			if (channel.parent() != null) {
				channel.parent().close();
			}
			channel.close();
		}

		if (boss != null)
			boss.shutdownGracefully().sync();
		if (work != null)
			work.shutdownGracefully().sync();

		log.info("Closed netty-server successfully!");
	}
}

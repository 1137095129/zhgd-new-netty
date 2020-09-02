package com.thhy.zhgd.netty;

import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("NettyServerChannelInitializer")
public class NettyServerChannelInitializer extends ChannelInitializer<SocketChannel> {

	@Autowired
	@Qualifier("AlarmInformationHandler")
	private ChannelHandler alarmInformationHandler;

	@Autowired
	@Qualifier("AlarmSetUpHandler")
	private ChannelHandler alarmSetUpHandler;

	@Autowired
	@Qualifier("BasicAttributesHandler")
	private ChannelHandler basicAttributesHandler;

	@Autowired
	@Qualifier("KeepAliveHandler")
	private ChannelHandler keepAliveHandler;

	@Autowired
	@Qualifier("LimitSetUpHandler")
	private ChannelHandler limitSetUpHandler;

	@Autowired
	@Qualifier("ObstacleInformationHandler")
	private ChannelHandler obstacleInformationHandler;

	@Autowired
	@Qualifier("RealTimeHandler")
	private ChannelHandler realTimeHandler;

	@Autowired
	@Qualifier("RegisterHandler")
	private ChannelHandler registerHandler;

	@Autowired
	@Qualifier("SensorCalibrationHandler")
	private ChannelHandler sensorCalibrationHandler;

	@Autowired
	@Qualifier("WorkCycleInformationHandler")
	private ChannelHandler workCycleInformationHandler;

	@Autowired
	@Qualifier("DecodeHexStrToByteBuf")
	private ChannelHandler decodeHexStrToByteBuf;

	@Override
	protected void initChannel(SocketChannel channel) throws Exception {
		channel.pipeline()
				.addLast(decodeHexStrToByteBuf)
				.addLast(alarmInformationHandler)
				.addLast(alarmSetUpHandler)
				.addLast(basicAttributesHandler)
				.addLast(keepAliveHandler)
				.addLast(limitSetUpHandler)
				.addLast(obstacleInformationHandler)
				.addLast(realTimeHandler)
				.addLast(registerHandler)
				.addLast(sensorCalibrationHandler)
				.addLast(workCycleInformationHandler);
	}
}

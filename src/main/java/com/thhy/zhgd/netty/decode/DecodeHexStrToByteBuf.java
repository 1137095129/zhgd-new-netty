package com.thhy.zhgd.netty.decode;

import com.thhy.zhgd.entity.*;
import com.thhy.zhgd.netty.decode.load.AbstractLoadObject;
import com.thhy.zhgd.util.DataMessageKind;
import com.thhy.zhgd.util.IlegalKindException;
import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.ByteToMessageDecoder;
import io.netty.util.CharsetUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.List;

@ChannelHandler.Sharable
@Component("DecodeHexStrToByteBuf")
public class DecodeHexStrToByteBuf extends ByteToMessageDecoder {

	@Autowired
	@Qualifier("LoadAlarmInformation")
	private AbstractLoadObject<AlarmInformation> loadAlarmInformation;
	@Autowired
	@Qualifier("LoadAlarmSetUpInformation")
	private AbstractLoadObject<AlarmSetUpInformation> loadAlarmSetUpInformation;
	@Autowired
	@Qualifier("LoadBasicAttributesInformation")
	private AbstractLoadObject<BasicAttributesInformation> loadBasicAttributesInformation;
	@Autowired
	@Qualifier("LoadKeepAliveFromClientInformation")
	private AbstractLoadObject<KeepAliveFromClientInformation> loadKeepAliveFormClientInformation;
	@Autowired
	@Qualifier("LoadLimitSetUpInformation")
	private AbstractLoadObject<LimitSetUpInformation> loadLimitSetUpInformation;
	@Autowired
	@Qualifier("LoadObstacleInformation")
	private AbstractLoadObject<ObstacleInformation> loadObstacleInformation;
	@Autowired
	@Qualifier("LoadRealTimeInformation")
	private AbstractLoadObject<RealTimeInformation> loadRealTimeInformation;
	@Autowired
	@Qualifier("LoadRegisterInformation")
	private AbstractLoadObject<RegisterInformation> loadRegisterInformation;
	@Autowired
	@Qualifier("LoadSensorCalibrationInformation")
	private AbstractLoadObject<SensorCalibrationInformation> loadSensorCalibrationInformation;
	@Autowired
	@Qualifier("LoadWorkCycleInformation")
	private AbstractLoadObject<WorkCycleInformation> loadWorkCycleInformation;

	@Override
	protected void decode(ChannelHandlerContext channelHandlerContext, ByteBuf byteBuf, List<Object> list) throws Exception {
		//先判断可读字节是否有6个字节，没有则不进行解码并直接退出
		int i = byteBuf.readableBytes();
		if (i < 6)
			return;

		//向右便宜4个字节，获取帧类型
		byte[] bytes = new byte[2];
		byteBuf.getBytes(4, bytes);

		//通过帧类型获取信息种类，并判断当前可读字节是否已大于或等于该帧类型的长度，是则进行数据解析，否则不进行数据解析
		DataMessageKind kind = DataMessageKind.getDataMessageKindByKindName(new String(bytes, CharsetUtil.UTF_8));
		if (i < kind.getLength())
			return;

		//获取当前帧类型数据的所有数据，注意在获取了多少长度的数据就要读取相应长度的数据
		byte[] data = new byte[kind.getLength()];
		byteBuf.getBytes(byteBuf.readerIndex(), data);
		byteBuf.readBytes(kind.getLength());

		list.add(getMessage(kind, new String(data, CharsetUtil.UTF_8)));
	}

	private DataMessage getMessage(DataMessageKind kind, String hexString) {
		switch (kind){
			case WORK_CYCLE_INFORMATION:
				return loadWorkCycleInformation.loadDataMessage(kind, hexString);
			case SENSOR_CALIBRATION:
				return loadSensorCalibrationInformation.loadDataMessage(kind, hexString);
			case REGISTER:
				return loadRegisterInformation.loadDataMessage(kind, hexString);
			case REAL_TIME:
				return loadRealTimeInformation.loadDataMessage(kind, hexString);
			case OBSTACLE_INFORMATION:
				return loadObstacleInformation.loadDataMessage(kind, hexString);
			case LIMIT_SET_UP:
				return loadLimitSetUpInformation.loadDataMessage(kind, hexString);
			case KEEP_ALVIE_FROM_CLIENT:
				return loadKeepAliveFormClientInformation.loadDataMessage(kind, hexString);
			case BASIC_ATTRIBUTES:
				return loadBasicAttributesInformation.loadDataMessage(kind, hexString);
			case ALARM_INFORMATION:
				return loadAlarmInformation.loadDataMessage(kind, hexString);
			case ALARM_SET_UP:
				return loadAlarmSetUpInformation.loadDataMessage(kind, hexString);
			case KEEP_ALIVE_FROM_SERVER:
			default:
				throw new IlegalKindException();
		}
	}

}

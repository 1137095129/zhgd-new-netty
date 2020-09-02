package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.*;
import com.thhy.zhgd.util.DataMessageKind;
import com.thhy.zhgd.util.IlegalKindException;
import com.thhy.zhgd.util.LoadObject;

public abstract class AbstractLoadObject<T> implements LoadObject<T> {

	public DataMessage loadDataMessage(DataMessageKind kind, String hexString) {
		DataMessage message = new DataMessage();
		message.setKind(kind);

		//TODO 设备编号解析

		setDataMessage(message, hexString);
		return message;
	}

	final void setDataMessage(DataMessage message, String hexString) {
		DataMessageKind kind = message.getKind();
		switch (kind) {
			case WORK_CYCLE_INFORMATION:
				message.setWorkCycleInformation((WorkCycleInformation) loadByHexString(hexString));
				break;
			case SENSOR_CALIBRATION:
				message.setSensorCalibrationInformation((SensorCalibrationInformation) loadByHexString(hexString));
				break;
			case REGISTER:
				message.setRegisterInformation((RegisterInformation) loadByHexString(hexString));
				break;
			case REAL_TIME:
				message.setRealTimeInformation((RealTimeInformation) loadByHexString(hexString));
				break;
			case OBSTACLE_INFORMATION:
				message.setObstacleInformation((ObstacleInformation) loadByHexString(hexString));
				break;
			case LIMIT_SET_UP:
				message.setLimitSetUpInformation((LimitSetUpInformation) loadByHexString(hexString));
				break;
			case KEEP_ALVIE_FROM_CLIENT:
				message.setKeepAliveFromClientInformation((KeepAliveFromClientInformation) loadByHexString(hexString));
				break;
			case BASIC_ATTRIBUTES:
				message.setBasicAttributesInformation((BasicAttributesInformation) loadByHexString(hexString));
				break;
			case ALARM_INFORMATION:
				message.setAlarmInformation((AlarmInformation) loadByHexString(hexString));
				break;
			case ALARM_SET_UP:
				message.setAlarmSetUpInformation((AlarmSetUpInformation) loadByHexString(hexString));
				break;
			case KEEP_ALIVE_FROM_SERVER:
			default:
				throw new IlegalKindException();
		}
	}

	protected abstract T loadByHexString(String hexStr);

}

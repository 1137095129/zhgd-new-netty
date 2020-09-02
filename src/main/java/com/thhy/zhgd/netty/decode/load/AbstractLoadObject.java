package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.*;
import com.thhy.zhgd.util.DataMessageKind;
import com.thhy.zhgd.util.IlegalKindException;
import com.thhy.zhgd.util.LoadObject;

public abstract class AbstractLoadObject<T> implements LoadObject<T> {

	public DataMessage loadDataMessage(DataMessageKind kind, Integer[] arr) {
		DataMessage message = new DataMessage();
		message.setKind(kind);

		//TODO 设备编号解析

		setDataMessage(message, arr);
		return message;
	}

	final void setDataMessage(DataMessage message, Integer[] arr) {
		DataMessageKind kind = message.getKind();
		switch (kind) {
			case WORK_CYCLE_INFORMATION:
				message.setWorkCycleInformation((WorkCycleInformation) loadByHexString(arr));
				break;
			case SENSOR_CALIBRATION:
				message.setSensorCalibrationInformation((SensorCalibrationInformation) loadByHexString(arr));
				break;
			case REGISTER:
				message.setRegisterInformation((RegisterInformation) loadByHexString(arr));
				break;
			case REAL_TIME:
				message.setRealTimeInformation((RealTimeInformation) loadByHexString(arr));
				break;
			case OBSTACLE_INFORMATION:
				message.setObstacleInformation((ObstacleInformation) loadByHexString(arr));
				break;
			case LIMIT_SET_UP:
				message.setLimitSetUpInformation((LimitSetUpInformation) loadByHexString(arr));
				break;
			case KEEP_ALVIE_FROM_CLIENT:
				message.setKeepAliveFromClientInformation((KeepAliveFromClientInformation) loadByHexString(arr));
				break;
			case BASIC_ATTRIBUTES:
				message.setBasicAttributesInformation((BasicAttributesInformation) loadByHexString(arr));
				break;
			case ALARM_INFORMATION:
				message.setAlarmInformation((AlarmInformation) loadByHexString(arr));
				break;
			case ALARM_SET_UP:
				message.setAlarmSetUpInformation((AlarmSetUpInformation) loadByHexString(arr));
				break;
			case KEEP_ALIVE_FROM_SERVER:
			default:
				throw new IlegalKindException();
		}
	}

	protected abstract T loadByHexString(Integer[] arr);

}

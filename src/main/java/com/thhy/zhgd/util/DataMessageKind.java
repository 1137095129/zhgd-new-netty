package com.thhy.zhgd.util;

import com.thhy.zhgd.netty.channelhandler.BasicAttributesHandler;
import com.thhy.zhgd.netty.decode.load.*;

public enum DataMessageKind {
	//注册
	REGISTER("60", 0, new LoadRegisterInformation()),
	//基本属性信息
	BASIC_ATTRIBUTES("31", 0, new LoadBasicAttributesInformation()),
	//传感器标定信息
	SENSOR_CALIBRATION("33", 0, new LoadSensorCalibrationInformation()),
	//报警设置信息
	ALARM_SET_UP("35", 0, new LoadAlarmSetUpInformation()),
	//限位设置信息
	LIMIT_SET_UP("37", 0, new LoadLimitSetUpInformation()),
	//实时数据信息
	REAL_TIME("0C", 0, new LoadRealTimeInformation()),
	//报警数据信息
	ALARM_INFORMATION("20", 0,new LoadAlarmInformation()),
	//设备上行心跳信息
	KEEP_ALVIE_FROM_CLIENT("80", 0,new LoadKeepAliveFromClientInformation()),
	//服务器下行心跳信息
	KEEP_ALIVE_FROM_SERVER("8E", 0,null),
	//工作循环数据
	WORK_CYCLE_INFORMATION("3D", 0,new LoadWorkCycleInformation()),
	//障碍物信息
	OBSTACLE_INFORMATION("2F", 0,new LoadObstacleInformation());

	private final String kindStr;
	private final Integer length;
	private final AbstractLoadObject loadObject;

	DataMessageKind(String kindStr, Integer length, AbstractLoadObject loadObject) {
		this.kindStr = kindStr;
		this.length = length;
		this.loadObject = loadObject;
	}

	public String getKindStr() {
		return kindStr;
	}

	public Integer getLength() {
		return length;
	}

	public AbstractLoadObject getLoadObject() {
		return loadObject;
	}

	private final static DataMessageKind[] kinds = new DataMessageKind[]{
			REGISTER, BASIC_ATTRIBUTES, SENSOR_CALIBRATION, ALARM_SET_UP, LIMIT_SET_UP, REAL_TIME, ALARM_INFORMATION,
			KEEP_ALVIE_FROM_CLIENT, KEEP_ALIVE_FROM_SERVER, WORK_CYCLE_INFORMATION, OBSTACLE_INFORMATION
	};

	public static DataMessageKind getDataMessageKindByKindName(String kindStr) {
		for (DataMessageKind kind : kinds) {
			if (kind.getKindStr().equals(kindStr))
				return kind;
		}
		throw new KindNotFoundException();
	}
}

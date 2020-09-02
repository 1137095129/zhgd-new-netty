package com.thhy.zhgd.entity;

import com.thhy.zhgd.util.DataMessageKind;

import java.io.Serializable;

/**
 * 设备上行数据载体
 */
public class DataMessage implements Serializable {
	private static final long serialVersionUID = -6333463659577941389L;
	private DataMessageKind kind;                                               //信息种类
	private Integer towerCraneNum;                                              //塔机编号
	private Integer equipmentNum;                                               //设备编号
	private AlarmInformation alarmInformation;                                  //报警数据
	private AlarmSetUpInformation alarmSetUpInformation;                        //报警设置数据
	private BasicAttributesInformation basicAttributesInformation;              //基础数据
	private KeepAliveFromClientInformation keepAliveFromClientInformation;      //心跳数据
	private LimitSetUpInformation limitSetUpInformation;                        //限位设置数据
	private ObstacleInformation obstacleInformation;                            //障碍物数据
	private RealTimeInformation realTimeInformation;                            //实时数据
	private RegisterInformation registerInformation;                            //注册数据
	private SensorCalibrationInformation sensorCalibrationInformation;          //传感器标定数据
	private WorkCycleInformation workCycleInformation;                          //工作循环数据


	public DataMessageKind getKind() {
		return kind;
	}

	public void setKind(DataMessageKind kind) {
		this.kind = kind;
	}

	public Integer getTowerCraneNum() {
		return towerCraneNum;
	}

	public void setTowerCraneNum(Integer towerCraneNum) {
		this.towerCraneNum = towerCraneNum;
	}

	public Integer getEquipmentNum() {
		return equipmentNum;
	}

	public void setEquipmentNum(Integer equipmentNum) {
		this.equipmentNum = equipmentNum;
	}

	public AlarmInformation getAlarmInformation() {
		return alarmInformation;
	}

	public void setAlarmInformation(AlarmInformation alarmInformation) {
		this.alarmInformation = alarmInformation;
	}

	public AlarmSetUpInformation getAlarmSetUpInformation() {
		return alarmSetUpInformation;
	}

	public void setAlarmSetUpInformation(AlarmSetUpInformation alarmSetUpInformation) {
		this.alarmSetUpInformation = alarmSetUpInformation;
	}

	public BasicAttributesInformation getBasicAttributesInformation() {
		return basicAttributesInformation;
	}

	public void setBasicAttributesInformation(BasicAttributesInformation basicAttributesInformation) {
		this.basicAttributesInformation = basicAttributesInformation;
	}

	public KeepAliveFromClientInformation getKeepAliveFromClientInformation() {
		return keepAliveFromClientInformation;
	}

	public void setKeepAliveFromClientInformation(KeepAliveFromClientInformation keepAliveFromClientInformation) {
		this.keepAliveFromClientInformation = keepAliveFromClientInformation;
	}

	public LimitSetUpInformation getLimitSetUpInformation() {
		return limitSetUpInformation;
	}

	public void setLimitSetUpInformation(LimitSetUpInformation limitSetUpInformation) {
		this.limitSetUpInformation = limitSetUpInformation;
	}

	public ObstacleInformation getObstacleInformation() {
		return obstacleInformation;
	}

	public void setObstacleInformation(ObstacleInformation obstacleInformation) {
		this.obstacleInformation = obstacleInformation;
	}

	public RealTimeInformation getRealTimeInformation() {
		return realTimeInformation;
	}

	public void setRealTimeInformation(RealTimeInformation realTimeInformation) {
		this.realTimeInformation = realTimeInformation;
	}

	public RegisterInformation getRegisterInformation() {
		return registerInformation;
	}

	public void setRegisterInformation(RegisterInformation registerInformation) {
		this.registerInformation = registerInformation;
	}

	public SensorCalibrationInformation getSensorCalibrationInformation() {
		return sensorCalibrationInformation;
	}

	public void setSensorCalibrationInformation(SensorCalibrationInformation sensorCalibrationInformation) {
		this.sensorCalibrationInformation = sensorCalibrationInformation;
	}

	public WorkCycleInformation getWorkCycleInformation() {
		return workCycleInformation;
	}

	public void setWorkCycleInformation(WorkCycleInformation workCycleInformation) {
		this.workCycleInformation = workCycleInformation;
	}
}

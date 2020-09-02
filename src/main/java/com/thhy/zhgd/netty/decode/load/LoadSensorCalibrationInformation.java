package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.SensorCalibrationInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载传感器标定信息
 */
@Component("LoadSensorCalibrationInformation")
public class LoadSensorCalibrationInformation extends AbstractLoadObject<SensorCalibrationInformation> {
	@Override
	public SensorCalibrationInformation loadByHexString(String hexStr) {
		return null;
	}
}

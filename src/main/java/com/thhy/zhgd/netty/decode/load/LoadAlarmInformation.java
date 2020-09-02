package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.AlarmInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载报警信息
 */
@Component("LoadAlarmInformation")
public class LoadAlarmInformation extends AbstractLoadObject<AlarmInformation> {

	@Override
	public AlarmInformation loadByHexString(String hexStr) {
		return null;
	}
}

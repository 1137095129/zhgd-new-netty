package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.AlarmSetUpInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载报警设置信息
 */
@Component("LoadAlarmSetUpInformation")
public class LoadAlarmSetUpInformation extends AbstractLoadObject<AlarmSetUpInformation> {
	@Override
	public AlarmSetUpInformation loadByHexString(Integer[] arr) {
		return null;
	}
}

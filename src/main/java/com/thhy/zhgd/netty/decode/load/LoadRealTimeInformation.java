package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.RealTimeInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载实时数据信息
 */
@Component("LoadRealTimeInformation")
public class LoadRealTimeInformation extends AbstractLoadObject<RealTimeInformation> {
	@Override
	public RealTimeInformation loadByHexString(String hexStr) {
		return null;
	}
}

package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.LimitSetUpInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载限位设置信息
 */
@Component("LoadLimitSetUpInformation")
public class LoadLimitSetUpInformation extends AbstractLoadObject<LimitSetUpInformation> {
	@Override
	public LimitSetUpInformation loadByHexString(String hexStr) {
		return null;
	}
}

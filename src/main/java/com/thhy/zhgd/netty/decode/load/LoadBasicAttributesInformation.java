package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.BasicAttributesInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载基础属性信息
 */
@Component("LoadBasicAttributesInformation")
public class LoadBasicAttributesInformation extends AbstractLoadObject<BasicAttributesInformation> {
	@Override
	public BasicAttributesInformation loadByHexString(String hexStr) {
		return null;
	}
}

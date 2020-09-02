package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.RegisterInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载注册信息
 */
@Component("LoadRegisterInformation")
public class LoadRegisterInformation extends AbstractLoadObject<RegisterInformation> {
	@Override
	public RegisterInformation loadByHexString(String hexStr) {
		return null;
	}
}

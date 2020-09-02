package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.KeepAliveFromClientInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载心跳数据
 */
@Component("LoadKeepAliveFromClientInformation")
public class LoadKeepAliveFromClientInformation extends AbstractLoadObject<KeepAliveFromClientInformation> {
	@Override
	public KeepAliveFromClientInformation loadByHexString(Integer[] arr) {
		return null;
	}
}

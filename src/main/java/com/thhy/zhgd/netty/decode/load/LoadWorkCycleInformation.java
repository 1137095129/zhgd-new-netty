package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.WorkCycleInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载工作循环信息
 */
@Component("LoadWorkCycleInformation")
public class LoadWorkCycleInformation extends AbstractLoadObject<WorkCycleInformation> {
	@Override
	public WorkCycleInformation loadByHexString(String hexStr) {
		return null;
	}
}

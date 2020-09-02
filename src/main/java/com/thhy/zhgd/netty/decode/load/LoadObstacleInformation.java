package com.thhy.zhgd.netty.decode.load;

import com.thhy.zhgd.entity.ObstacleInformation;
import org.springframework.stereotype.Component;

/**
 * 解析16进制字符串，装载障碍物信息
 */
@Component("LoadObstacleInformation")
public class LoadObstacleInformation extends AbstractLoadObject<ObstacleInformation> {
	@Override
	public ObstacleInformation loadByHexString(String hexStr) {
		return null;
	}
}

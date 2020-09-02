package com.thhy.zhgd.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
@ConfigurationProperties(prefix = "netty-server-config")
public class NettyServerConfigProperties {
	private Integer port;
	private Integer bossThreadCount;
	private Integer workThreadCount;
	private Long allIdleTime;
	private Long writeIdleTime;
	private Long readIdleTime;
	private TimeUnit idleTimeUnit;

	public Integer getPort() {
		return port;
	}

	public void setPort(Integer port) {
		this.port = port;
	}

	public Integer getBossThreadCount() {
		return bossThreadCount;
	}

	public void setBossThreadCount(Integer bossThreadCount) {
		this.bossThreadCount = bossThreadCount;
	}

	public Integer getWorkThreadCount() {
		return workThreadCount;
	}

	public void setWorkThreadCount(Integer workThreadCount) {
		this.workThreadCount = workThreadCount;
	}

	public Long getAllIdleTime() {
		return allIdleTime;
	}

	public void setAllIdleTime(Long allIdleTime) {
		this.allIdleTime = allIdleTime;
	}

	public Long getWriteIdleTime() {
		return writeIdleTime;
	}

	public void setWriteIdleTime(Long writeIdleTime) {
		this.writeIdleTime = writeIdleTime;
	}

	public Long getReadIdleTime() {
		return readIdleTime;
	}

	public void setReadIdleTime(Long readIdleTime) {
		this.readIdleTime = readIdleTime;
	}

	public TimeUnit getIdleTimeUnit() {
		return idleTimeUnit;
	}

	public void setIdleTimeUnit(TimeUnit idleTimeUnit) {
		this.idleTimeUnit = idleTimeUnit;
	}
}

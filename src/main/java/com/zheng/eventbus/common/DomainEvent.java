package com.zheng.eventbus.common;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 所有事件都必须继承DomainEvent
 *
 * @author zhenglian
 * @data 2017年1月20日 下午3:58:14
 */
public abstract class DomainEvent {
	/**
	 * 事件触发时间 
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午3:58:01
	 * @return
	 */
	public String emitTime() {
		SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		long time = System.currentTimeMillis();
		Date date = new Date(time);
		return sf.format(date);
	}
	
	public abstract String eventName();
}

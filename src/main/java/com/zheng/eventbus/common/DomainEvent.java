package com.zheng.eventbus.common;

/**
 * 所有事件都必须继承DomainEvent
 *
 * @author zhenglian
 * @data 2017年1月20日 下午3:58:14
 */
public interface DomainEvent {
	/**
	 * 事件触发时间 
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午3:58:01
	 * @return
	 */
	long emitTime();
	
	String eventName();
}

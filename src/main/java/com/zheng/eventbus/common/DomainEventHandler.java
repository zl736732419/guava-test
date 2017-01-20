package com.zheng.eventbus.common;

/**
 * 通用事件处理器，也就是事件订阅者
 * 用于处理具体的某种事件
 *
 * @author zhenglian
 * @data 2017年1月20日 下午4:01:05
 * @param <T>
 */
public interface DomainEventHandler<T extends DomainEvent> {
	
	/**
	 * 将自身通过DomainEventRegisterCenter注册到事件总线上
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午4:47:44
	 */
	void registerToBus();
	
	/**
	 * 事件处理
	 *
	 * @author zhenglian
	 * @data 2017年1月20日 下午4:06:53
	 * @param t
	 */
	void handleEvent(T event);
}

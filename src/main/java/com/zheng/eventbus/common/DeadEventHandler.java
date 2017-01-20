package com.zheng.eventbus.common;

import com.google.common.eventbus.DeadEvent;
import com.google.common.eventbus.Subscribe;

/**
 * 处理未被处理的事件
 *
 * @author zhenglian
 * @data 2017年1月20日 下午5:06:49
 */
public class DeadEventHandler {

	public void registerToBus() {
		DomainEventRegisterCenter.getInstance().getEventBus().register(this);
	}

	@Subscribe
	public void handle(DeadEvent event) {
		System.out.println("处理事件异常，进入DeadEventHandler...");
		System.out.println("event: " + event.getEvent());
		System.out.println("source: " + event.getSource());
	}
}

package com.zheng.eventbus;

import java.util.List;

import com.zheng.eventbus.common.DomainEvent;

/**
 * 订阅事件
 *
 * @author zhenglian
 * @data 2017年1月20日 下午4:50:02
 */
public class OrderEvent implements DomainEvent {
	/**
	 * 这里需要根据具体业务逻辑进行调整 这里只是测试
	 */
	private List<String> details; // 订单明细

	public OrderEvent(List<String> details) {
		this.details = details;
	}

	public List<String> getDetails() {
		return details;
	}

	public void setDetails(List<String> details) {
		this.details = details;
	}

	@Override
	public long emitTime() {
		return System.currentTimeMillis();
	}

	@Override
	public String eventName() {
		return "完成订单事件";
	}
}

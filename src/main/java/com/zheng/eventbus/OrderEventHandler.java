package com.zheng.eventbus;

import java.util.List;

import com.zheng.eventbus.common.DomainEventHandler;
import com.zheng.eventbus.common.DomainEventRegisterCenter;

public class OrderEventHandler extends DomainEventHandler<OrderEvent> {
	
	@Override
	public void registerToBus() {
		DomainEventRegisterCenter.getInstance().getEventBus().register(this);
	}

	@Override
	public void handleEvent(OrderEvent event) {
		List<String> details = event.getDetails();
		System.out.println("--------订单明细---------");
		for (String detail : details) {
			System.out.println(detail);
		}
	}
}

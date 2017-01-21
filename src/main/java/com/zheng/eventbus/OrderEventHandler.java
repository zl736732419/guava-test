package com.zheng.eventbus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.google.common.eventbus.Subscribe;
import com.zheng.eventbus.common.DomainEventHandler;
import com.zheng.eventbus.common.DomainEventRegisterCenter;

public class OrderEventHandler extends DomainEventHandler<OrderEvent> {
	
	@Override
	public void registerToBus() {
		DomainEventRegisterCenter.getInstance().getEventBus().register(this);
	}

	@Override
	@Subscribe
	public void handle(OrderEvent event) {
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(event.emitTime()));
		System.out.println(String.format("处理：%s, 触发时间：%s", event.eventName(), time));
		List<String> details = event.getDetails();
		for (String detail : details) {
			System.out.println(detail);
		}
	}

}

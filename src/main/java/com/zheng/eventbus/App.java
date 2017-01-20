package com.zheng.eventbus;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.zheng.eventbus.common.DomainEventRegisterCenter;

public class App {

	@Test
	public void testEvent() {
		new OrderEventHandler();
		List<String> details = Lists.newArrayList("白菜", "廋肉", "作料", "饮料");
		OrderEvent event = new OrderEvent(details);
		
		DomainEventRegisterCenter.getInstance().publish(event);
	}
	
}

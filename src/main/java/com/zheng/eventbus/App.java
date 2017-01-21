package com.zheng.eventbus;

import java.util.List;

import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.eventbus.EventBus;
import com.zheng.eventbus.common.DomainEventRegisterCenter;

public class App {
	@Test
	public void testAsyncEventBus() throws InterruptedException {
		new OrderEventHandler(); // 创建处理器，在创建时进行注册，这里只需要new出来即可
		List<String> details = Lists.newArrayList("白菜", "廋肉", "作料", "饮料");
		OrderEvent event = new OrderEvent(details);
		DomainEventRegisterCenter.getInstance().publish(event);

		
		//如果采用AsyncEventBus，则需要让主线程执行完成后不立即死掉,AsyncEventBus内部采用用户传递的线程执行器进行执行，不然子线程还没来得及执行程序就已经结束了
		while (true) {
			Thread.sleep(1000);
			System.out.println(System.currentTimeMillis());
		}
	}
	
	@Test
	public void testEventBus() throws InterruptedException {
		EventBus eventBus = new EventBus();
		DomainEventRegisterCenter center = DomainEventRegisterCenter.getInstance().setEventBus(eventBus);
		
		new OrderEventHandler(); // 创建处理器，在创建时进行注册，这里只需要new出来即可
		List<String> details = Lists.newArrayList("白菜", "廋肉", "作料", "饮料");
		OrderEvent event = new OrderEvent(details);
		center.publish(event);
	}

}

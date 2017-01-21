package com.zheng.eventbus.common;

import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

/**
 * 事件注册管理中心 负责处理器绑定、解绑、发布事件
 *
 * @author zhenglian
 * @data 2017年1月20日 下午4:04:44
 */
public class DomainEventRegisterCenter {
	public static DomainEventRegisterCenter instance = null;
	private final AsyncEventBus eventBus = new AsyncEventBus(Executors.newCachedThreadPool(new MyThreadFactory()));
//	private final EventBus eventBus = new EventBus(); //单线程中执行，内部执行器其实是一个实现Executor的枚举

	private DomainEventRegisterCenter() {
		registerDeadEventHandler();
	}

	private void registerDeadEventHandler() {
		eventBus.register(new DeadEventHandler());
	}

	public EventBus getEventBus() {
		return eventBus;
	}

	public static DomainEventRegisterCenter getInstance() {
		if (null == instance) {
			instance = new DomainEventRegisterCenter();
		}

		return instance;
	}

	public void registerDomainHandler(DomainEventHandler<? extends DomainEvent> handler) {
		eventBus.register(handler);
	}

	public void unregisterDomainHandler(DomainEventHandler<? extends DomainEvent> handler) {
		eventBus.unregister(handler);
	}

	public <T> void publish(T event) {
		eventBus.post(event);
	}
}

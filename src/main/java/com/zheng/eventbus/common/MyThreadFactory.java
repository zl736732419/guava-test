package com.zheng.eventbus.common;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadFactory implements ThreadFactory {
		private final AtomicInteger poolNumber = new AtomicInteger(1);
		private final AtomicInteger threadNumber = new AtomicInteger(1);

		@Override
		public Thread newThread(Runnable r) {
			SecurityManager s = System.getSecurityManager();
			ThreadGroup group = (s != null) ? s.getThreadGroup() : Thread.currentThread().getThreadGroup();
			String namePrefix = "guava-study-" + poolNumber.getAndIncrement() + "-thread-";

			Thread thread = new Thread(group, r, namePrefix + threadNumber.getAndIncrement(), 0);
			if (thread.isDaemon()) {
				thread.setDaemon(false);
			}
			if (thread.getPriority() != Thread.NORM_PRIORITY) {
				thread.setPriority(Thread.NORM_PRIORITY);
			}

			return thread;
		}

	}
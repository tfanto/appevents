package com.fanto.sys;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.google.common.eventbus.AsyncEventBus;
import com.google.common.eventbus.EventBus;

public class AppEventBusAsync {

	private ExecutorService executor = Executors.newFixedThreadPool(5);
	EventBus guava = new AsyncEventBus("async-bus", executor);

	private static AppEventBusAsync INSTANCE = null;

	private AppEventBusAsync() {

	}

	public static AppEventBusAsync getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new AppEventBusAsync();
		}
		return INSTANCE;
	}

	public void addNotification(String data) {
		guava.post(data);
	}

	public void addSubscriber(Object object) {
		guava.register(object);
	}

	public void removeSubscriber(Object object) {
		guava.unregister(object);
	}
	
	public void close() {
		executor.shutdown();
	}

}

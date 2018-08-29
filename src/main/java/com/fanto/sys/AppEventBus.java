package com.fanto.sys;

import com.google.common.eventbus.EventBus;

public class AppEventBus {

	private static AppEventBus INSTANCE = null;
	private static EventBus guava = new EventBus();

	private AppEventBus() {

	}

	public static AppEventBus getInstance() {

		if (INSTANCE == null) {
			INSTANCE = new AppEventBus();
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

}

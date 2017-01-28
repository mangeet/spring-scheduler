package me.common.bean;

import org.springframework.context.ApplicationContext;

public class SpringApplicationContext {

	private static ApplicationContext applicationContext;

	/**
	 * Private constructor
	 */
	private SpringApplicationContext() {
	}

	/**
	 * Sets applicationContext
	 *
	 * @param context
	 *            ApplicationContext
	 */
	public static void set(ApplicationContext context) {
		applicationContext = context;
	}

	/**
	 * Returns {@link ApplicationContext}
	 *
	 * @return ApplicationContext spring {@link ApplicationContext}
	 */
	public static ApplicationContext get() {
		if (applicationContext == null) {
			throw new me.common.exception.ServiceException("Spring application context is not initialised.");
		}
		return applicationContext;
	}
}
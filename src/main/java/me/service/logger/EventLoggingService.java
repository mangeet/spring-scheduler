package me.service.logger;

import me.common.bean.LoggingRequest;

public interface EventLoggingService {
	
	void logEvent(final LoggingRequest loggingRequest);

}

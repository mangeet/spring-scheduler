package me.service.logger;

import me.common.bean.LoggingRequest;

public class EventLoggingServiceImpl implements EventLoggingService {

	@Override
	public void logEvent(LoggingRequest loggingRequest) {
		
        // log an event here by connecting to database and save the details
		// to connect to database and save should be there in DAO layer.
		
		// loggingDao.logEvent(..);
	}

}

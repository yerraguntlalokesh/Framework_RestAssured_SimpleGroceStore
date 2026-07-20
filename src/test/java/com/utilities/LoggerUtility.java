package com.utilities;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public final class LoggerUtility {

    private LoggerUtility() {

    }

    public static Logger getLogger(Class className) {
        return LogManager.getLogger(className);
    }
}
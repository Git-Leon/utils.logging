package com.github.git_leon.logging;

import com.github.git_leon.logging.simplelogger.SimpleLoggerInterface;
import com.github.git_leon.logging.simplelogger.SimpleLoggerWarehouse;

public interface Loggable {
    default SimpleLoggerInterface getLogger() {
        return SimpleLoggerWarehouse.getLogger(getClass().getName());
    }
}

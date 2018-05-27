package com.github.git_leon.logging;

import java.util.HashMap;
import java.util.logging.Logger;

/**
 * Created by leon on 5/15/17.
 */
public final class SimpleLoggerWarehouse {
    private static final SimpleLogger globalLogger = new SimpleLogger(Logger.getGlobal());
    private static final HashMap<Class, SimpleLogger> loggerMap = new HashMap<>();

    /**
     * Only one logger per class
     * @param c - class to generate a logger for
     * @return respective MyLogger object
     */ // TODO - Rethink the nature of the "one logger per class" rule
    public static final SimpleLogger getLogger(Class c) {
        addLogger(c);
        return loggerMap.get(c);
    }

    /**
     * Ensures each logger is only tied to a single class
     * @param c - class to generate a logger for
     */
    private static final void addLogger(Class c) {
        if (!loggerMap.containsKey(c)) {
            globalLogger.info(String.format("Instantiating logger for [ %s ] ... ", c.getName()));
            loggerMap.put(c, new SimpleLogger(c));
        }
    }
}

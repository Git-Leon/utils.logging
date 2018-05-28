package com.github.git_leon.logging;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.logging.*;

import static java.util.logging.Level.*;

/**
 * Created by leon on 5/15/17.
 */
public final class SimpleLogger {
    private final Logger logger;
    private final String loggerName;
    private boolean printingEnabled;

    public SimpleLogger(Class c) {
        this(c.getSimpleName());
    }

    public SimpleLogger(String loggerName) {
        this(Logger.getLogger(loggerName));
    }

    public SimpleLogger(Logger logger) {
        this(logger, getFileHandler(logger.getName()));
    }

    public SimpleLogger(Logger logger, StreamHandler streamHandler) {
        this.logger = logger;
        this.loggerName = logger.getName();
        logger.setUseParentHandlers(false);
        this.removeHandlers();
        this.logger.addHandler(streamHandler);
        this.printingEnabled = true;
    }

    private void removeHandlers() {
        Logger globalLogger = Logger.getGlobal();
        Handler[] handlers = globalLogger.getHandlers();
        for (Handler handler : handlers) {
            globalLogger.removeHandler(handler);
        }
    }

    public void throwable(Throwable t, Level level) {
        StringWriter out = new StringWriter();
        t.printStackTrace(new PrintWriter(out));
        String description = out.toString();
        log(level, description);
    }

    public void evaluateCondition(boolean condition, String eventDescription, Object... args) {
        String prefixedMessage = "%s " + eventDescription;
        String prefix = condition ? "Successfully" : "Unsuccesfully";
        info(prefixedMessage, prefix, args);
    }

    private static FileHandler getFileHandler(String fileName) {
        String fileDirectory = "./target/logs/";
        String fullFilePath = fileDirectory + fileName;

        FileHandler fh = null;
        try {
            new File(fileDirectory).mkdirs();
            fh = new FileHandler(fullFilePath, true);
            fh.setFormatter(new SimpleFormatter());
        } catch (IOException ioe) {
            ioe.printStackTrace();
        }
        return fh;
    }

    public void throwable(Throwable t) {
        throwable(t, WARNING);
    }

    public void info(String s, Object... args) {
        log(INFO, s, args);
    }

    public void warn(String s, Object... args) {
        log(WARNING, s, args);
    }

    public void error(String s, Object... args) {
        log(SEVERE, s, args);
    }

    private void log(Level level, String message, Object... messageArgs) {
        String info = String.format(message, messageArgs);
        if (printingEnabled) {
            System.out.println(info);
        }
        logger.log(level, info);
    }

    public void enablePrinting() {
        this.printingEnabled = true;
    }

    public void disablePrinting() {
        this.printingEnabled = false;
    }

    public Logger getLogger() {
        return logger;
    }
}

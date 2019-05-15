package com.github.git_leon.logging;


import java.io.File;
import java.io.IOException;
import java.util.logging.*;

/**
 * Created by leon on 5/15/17.
 */
public final class SimpleLogger implements SimpleLoggerInterface {
    private final Logger logger;
    private boolean isEnabled;

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
        logger.setUseParentHandlers(false);
        this.removeHandlers();
        this.logger.addHandler(streamHandler);
    }

    public void evaluateCondition(boolean condition, String eventDescription, Object... args) {
        String prefixedMessage = "%s " + eventDescription;
        String prefix = condition ? "Successfully" : "Unsuccesfully";
        info(prefixedMessage, prefix, args);
    }

    @Override
    public void enabled() {
        this.isEnabled = true;
    }

    @Override
    public void disble() {
        this.isEnabled = false;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }

    @Override
    public Logger getLogger() {
        return logger;
    }

    private void removeHandlers() {
        Handler[] handlers = logger.getHandlers();
        for (Handler handler : handlers) {
            logger.removeHandler(handler);
        }
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
}

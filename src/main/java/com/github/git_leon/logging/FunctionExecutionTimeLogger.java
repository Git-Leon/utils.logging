package com.github.git_leon.logging;


import sun.reflect.generics.tree.ReturnType;

import java.util.function.*;
import java.util.logging.Level;

/**
 * @author leon on 5/25/18.
 * The purpose of this class is to invoke methods and report their result and execution time
 */
public class FunctionExecutionTimeLogger implements SimpleLoggerInterface {
    private final SimpleLoggerInterface logger;

    public FunctionExecutionTimeLogger(SimpleLoggerInterface logger) {
        this.logger = logger;
    }

    /**
     * @param function        FunctionalInterface to be invoked
     * @param firstArg        first argument of FunctionalInterface to be invoked
     * @param secondArg       second argument of FunctionalInterface to be invoked
     * @param logMessage      message to be logged
     * @param <FirstArgType>  Parameter-Type of first argument
     * @param <SecondArgType> Parameter-Type of second argument
     * @param <ReturnType>    Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <FirstArgType, SecondArgType, ReturnType> ReturnType invokeAndLog(
            BiFunction<FirstArgType, SecondArgType, ReturnType> function,
            FirstArgType firstArg, SecondArgType secondArg, String logMessage) {
        String timeElapsedLog = "Execution time: %s seconds.";
        String resultValLog = "Resulted in %s";

        logger.info(logMessage);
        Long executionStartTime = System.currentTimeMillis();
        ReturnType returnValue = function.apply(firstArg, secondArg);
        double timeElapsedInSeconds = (System.currentTimeMillis() - executionStartTime) / 1000.0;

        logger.info(resultValLog, returnValue);
        logger.info(timeElapsedLog, timeElapsedInSeconds);

        return returnValue;
    }

    /**
     * @param function     FunctionalInterface to be invoked
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType, ReturnType> ReturnType invokeAndLog(
            Function<ArgType, ReturnType> function, ArgType arg, String logMessage) {
        return invokeAndLog((arg1, arg2) -> function.apply(arg), null, null, logMessage);
    }

    /**
     * @param function FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType> void consumeAndLog(
            Consumer<ArgType> function, ArgType argument, String logMessage) {
        invokeAndLog((arg1) -> {
            function.accept(argument);
            return null;
        }, null, logMessage);
    }

    /**
     * @param function FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType1, ArgType2> void consumeAndLog(
            BiConsumer<ArgType1, ArgType2> function, ArgType1 argument1, ArgType2 argument2, String logMessage) {
        invokeAndLog((arg1) -> {
            function.accept(argument1, argument2);
            return null;
        }, null, logMessage);
    }

    /**
     * @param function     FunctionalInterface to be invoked
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ReturnType> ReturnType invokeAndLog(
            Supplier<ReturnType> function, String logMessage) {
        return invokeAndLog((arg) -> {
            return function.get();
        }, null, logMessage);
    }


    /**
     * @param function     FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public void invokeAndLog(
            Runnable function, String logMessage) {
        invokeAndLog((arg) -> {
            function.run();
            return null;
        }, null, logMessage);
    }

    @Override
    public void log(Level level, String message, Object... messageArgs) {
        logger.log(level, message, messageArgs);
    }

    @Override
    public void enable() {
        logger.enable();
    }

    @Override
    public void disble() {
        logger.disble();
    }

    @Override
    public boolean isEnabled() {
        return logger.isEnabled();
    }
}

package com.github.git_leon.logging;


import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * @author leon on 5/25/18.
 * The purpose of this class is to invoke methods and report their result and execution time
 */
public class FunctionExecutionTimeLogger {
    private final SimpleLogger logger;

    public FunctionExecutionTimeLogger(Logger logger) {
        this.logger = new SimpleLogger(logger);
    }

    /**
     * @param function FunctionalInterface to be invoked
     * @param firstArg first argument of FunctionalInterface to be invoked
     * @param secondArg second argument of FunctionalInterface to be invoked
     * @param logMessage message to be logged
     * @param <FirstArgType> Parameter-Type of first argument
     * @param <SecondArgType> Parameter-Type of second argument
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
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
     * Default log-message of `""`
     * @param function FunctionalInterface to be invoked
     * @param firstArg first argument of FunctionalInterface to be invoked
     * @param secondArg second argument of FunctionalInterface to be invoked
     * @param <FirstArgType> Parameter-Type of first argument
     * @param <SecondArgType> Parameter-Type of second argument
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <FirstArgType, SecondArgType, ReturnType> ReturnType invokeAndLog(
            BiFunction<FirstArgType, SecondArgType, ReturnType> function,
            FirstArgType firstArg, SecondArgType secondArg) {
        return invokeAndLog(function, firstArg, secondArg, "");
    }


    /**
     * @param function FunctionalInterface to be invoked
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType, ReturnType> ReturnType invokeAndLog(
            Function<ArgType, ReturnType> function, ArgType arg, String logMessage) {
        return invokeAndLog((arg1, arg2) -> function.apply(arg), null, null, logMessage);
    }


    /**
     * Default log-message of `""`
     * @param function FunctionalInterface to be invoked
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType, ReturnType> ReturnType invokeAndLog(
            Function<ArgType, ReturnType> function, ArgType arg) {
        return invokeAndLog(function, arg, "");
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
     * Default log-message of `""`
     * @param function FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ArgType> void consumeAndLog(
            Consumer<ArgType> function, ArgType argument) {
        consumeAndLog(function, argument, "");
    }


    /**
     * @param function FunctionalInterface to be invoked
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
     * Default log-message of `""`
     * @param function FunctionalInterface to be invoked
     * @param <ReturnType> Return-Type of FunctionalInterface to be invoked
     * @return Return-Value of the invoked FunctionalInterface
     */
    public <ReturnType> ReturnType invokeAndLog(
            Supplier<ReturnType> function) {
        return invokeAndLog(function, "");
    }

    public Logger getLogger() {
        return logger.getLogger();
    }
}

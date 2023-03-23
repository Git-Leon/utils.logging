package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.functionexecutiontimer.FunctionExecutionLoggerAndTimer;
import com.github.git_leon.logging.simplelogger.SimpleLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class FunctionExecutionLoggerAndTimerTest {
    private FunctionExecutionLoggerAndTimer logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionLoggerAndTimer(new SimpleLogger(Logger.getAnonymousLogger()));
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "log message";
        String expected = "Blah";

        // When
        Object actual = logger.logAndInvoke(
                (someString) -> someString,
                expected, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedAndReturningValue1() {
        // Given
        String expected = "Blah";
        String logMessage = "Some log message";

        // When
        Object actual = logger.logAndInvoke(
                (String someString) -> someString,
                expected, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

}

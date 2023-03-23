package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.extenttest.ExtentTestLogger;
import com.github.git_leon.logging.functionexecutiontimer.FunctionExecutionLoggerAndTimer;
import com.github.git_leon.logging.simplelogger.SimpleLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class BiFunctionExecutionLoggerAndTimerTest {
    private FunctionExecutionLoggerAndTimer logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionLoggerAndTimer(new SimpleLogger(Logger.getAnonymousLogger()));
    }

    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue1() {
        // Given
        String logMessage = "log message";
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        ExtentTestLogger extentTestLogger = new ExtentTestLogger(this.getClass(), "");
        extentTestLogger.log(Level.INFO, "hello world");
        Integer actual = logger.logAndInvoke(Integer::parseInt, stringVal, radix, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
        extentTestLogger.flush();
    }

    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "Some log message";
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        Integer actual = logger.logAndInvoke(Integer::parseInt, stringVal, radix, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue3() {
        // Given
        String logMessage = "log message";
        String stringToConcatenateTo = "Blah";
        Integer integerToConcatenate = Integer.MAX_VALUE;
        String expected = stringToConcatenateTo + integerToConcatenate;

        // When
        Object actual = logger.logAndInvoke(
                (String someString, Integer someInt) -> someString + someInt,
                stringToConcatenateTo, integerToConcatenate, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue4() {
        // Given
        String logMessage = "some message to log";
        String stringToConcatenateTo = "Blah";
        Integer integerToConcatenate = Integer.MAX_VALUE;
        String expected = stringToConcatenateTo + integerToConcatenate;

        // When
        Object actual = logger.logAndInvoke(
                (String someString, Integer someInt) -> someString + someInt,
                stringToConcatenateTo, integerToConcatenate, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

}

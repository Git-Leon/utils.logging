package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.FunctionExecutionTimeLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class BiFunctionExecutionTimeLoggerTest {
    private FunctionExecutionTimeLogger logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionTimeLogger(Logger.getAnonymousLogger());
    }

    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue1() {
        // Given
        String logMessage = "log message";
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        Integer actual = logger.invokeAndLog(Integer::parseInt, stringVal, radix, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIfFunctionIsInvokedWithAndReturningValue1() {
        // Given
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        Integer actual = logger.invokeAndLog(Integer::parseInt, stringVal, radix);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "log message";
        String stringToConcatenateTo = "Blah";
        Integer integerToConcatenate = Integer.MAX_VALUE;
        String expected = stringToConcatenateTo + integerToConcatenate;

        // When
        Object actual = logger.invokeAndLog(
                (String someString, Integer someInt) -> someString + someInt,
                stringToConcatenateTo, integerToConcatenate, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedAndReturningValue1() {
        // Given
        String stringToConcatenateTo = "Blah";
        Integer integerToConcatenate = Integer.MAX_VALUE;
        String expected = stringToConcatenateTo + integerToConcatenate;

        // When
        Object actual = logger.invokeAndLog(
                (String someString, Integer someInt) -> someString + someInt,
                stringToConcatenateTo, integerToConcatenate);

        // Then
        Assert.assertEquals(expected, actual);
    }

}

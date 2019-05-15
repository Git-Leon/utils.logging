package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.FunctionExecutionTimeLogger;
import com.github.git_leon.logging.SimpleLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class FunctionExecutionTimeLoggerTest {
    private FunctionExecutionTimeLogger logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionTimeLogger(new SimpleLogger(Logger.getAnonymousLogger()));
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "log message";
        String expected = "Blah";

        // When
        Object actual = logger.invokeAndLog(
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
        Object actual = logger.invokeAndLog(
                (String someString) -> someString,
                expected, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

}

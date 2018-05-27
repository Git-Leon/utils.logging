package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.FunctionExecutionTimeLogger;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class SupplierExecutionTimeLoggerTest {
    private FunctionExecutionTimeLogger logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionTimeLogger(Logger.getAnonymousLogger());
    }


    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "log message";
        String expected = "Blah";

        // When
        Object actual = logger.invokeAndLog(() -> expected, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }


    @Test
    public void testIfFunctionIsInvokedAndReturningValue2() {
        // Given
        String expected = "Blah";

        // When
        Object actual = logger.invokeAndLog(() -> expected);

        // Then
        Assert.assertEquals(expected, actual);
    }
}
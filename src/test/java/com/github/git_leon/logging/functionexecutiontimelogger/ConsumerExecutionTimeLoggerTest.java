package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.FunctionExecutionTimeLogger;
import com.github.git_leon.logging.SleepUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

/**
 * @author leon on 5/26/18.
 */
public class ConsumerExecutionTimeLoggerTest {
    private FunctionExecutionTimeLogger logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionTimeLogger(Logger.getAnonymousLogger());
    }


    @Test
    public void testIfFunctionIsWaiting() {
        // Given
        String logMessage = "log message";
        int expectedApproximateTime = 150;

        // When
        long executionStartTime = System.currentTimeMillis();
        logger.consumeAndLog((someString) -> SleepUtils.wait(expectedApproximateTime, TimeUnit.MILLISECONDS), logMessage);
        long timeElapsed = System.currentTimeMillis() - executionStartTime;

        // Then
        Assert.assertEquals(expectedApproximateTime, timeElapsed, 150);
    }

}

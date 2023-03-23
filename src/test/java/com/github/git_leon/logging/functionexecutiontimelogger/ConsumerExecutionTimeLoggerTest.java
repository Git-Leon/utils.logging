package com.github.git_leon.logging.functionexecutiontimelogger;

import com.github.git_leon.logging.functionexecutiontimer.FunctionExecutionLoggerAndTimer;
import com.github.git_leon.logging.simplelogger.SimpleLogger;
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
    private FunctionExecutionLoggerAndTimer logger;

    @Before
    public void setup() {
        this.logger = new FunctionExecutionLoggerAndTimer(new SimpleLogger(Logger.getAnonymousLogger()));
    }


    @Test
    public void testIfFunctionIsWaiting() {
        // Given
        String argumentToConsume = "argument to consume";
        String logMessage = "log message";
        int expectedApproximateTime = 150;

        // When
        long executionStartTime = System.currentTimeMillis();
        logger.consumeAndLog(
                (someString) -> SleepUtils.wait(expectedApproximateTime, TimeUnit.MILLISECONDS),
                argumentToConsume, logMessage);
        long timeElapsed = System.currentTimeMillis() - executionStartTime;

        // Then
        Assert.assertEquals(expectedApproximateTime, timeElapsed, 150);
    }

}

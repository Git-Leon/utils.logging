package com.github.git_leon.logging;


import com.github.git_leon.logging.extenttest.ExtentTestLogger;
import com.github.git_leon.logging.extenttest.ExtentTestLoggerFactory;
import com.github.git_leon.logging.functionexecutiontimer.FunctionExecutionLoggerAndTimer;
import org.junit.*;

/**
 * @author leon on 5/26/18.
 */
public class ExtentTestLoggerTest {
    private ExtentTestLogger logger;
    private static ExtentTestLoggerFactory extentTestLoggerFactory;


    @BeforeClass
    public static void staticSetup() {
        final Class<?> clazz = ExtentTestLoggerTest.class;
        final String reportPath = DirectoryReference.REPORT_DIRECTORY.getDirectoryPath();
        final String reportName = "test.html";
        final String reportFullPath = reportPath + "/" + reportName;
        ExtentTestLoggerTest.extentTestLoggerFactory = new ExtentTestLoggerFactory(reportFullPath);
    }

    @After
    public void teardown() {
        logger.flush();
    }

    @Before
    public void instanceSetup() {
        final ExtentTestLogger extentTestLogger = extentTestLoggerFactory.createExtentTestLogger("test flushing to multiple tests");
        this.logger = extentTestLogger;
    }

    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue1() {
        // Given
        String logMessage = "log message";
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        Integer actual = new FunctionExecutionLoggerAndTimer(logger).logAndInvoke(Integer::parseInt, stringVal, radix, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testIfFunctionIsInvokedWithLogMessageAndReturningValue2() {
        // Given
        String logMessage = "Some log message";
        String stringVal = "F";
        Integer radix = 16;
        Integer expected = 15;

        // When
        Integer actual = new FunctionExecutionLoggerAndTimer(logger).logAndInvoke(Integer::parseInt, stringVal, radix, logMessage);

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
        Object actual = new FunctionExecutionLoggerAndTimer(logger).logAndInvoke(
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
        Object actual = new FunctionExecutionLoggerAndTimer(logger).logAndInvoke(
                (String someString, Integer someInt) -> someString + someInt,
                stringToConcatenateTo, integerToConcatenate, logMessage);

        // Then
        Assert.assertEquals(expected, actual);
    }

}

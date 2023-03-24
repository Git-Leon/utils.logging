package com.github.git_leon.logging;


import com.github.git_leon.logging.extenttest.ExtentAssert;
import com.github.git_leon.logging.extenttest.ExtentTestLoggerFactory;
import com.github.git_leon.logging.extenttest.ExtentTestLoggerInterface;
import com.github.git_leon.logging.functionexecutiontimer.FunctionExecutionLoggerAndTimer;
import com.github.git_leon.logging.utils.DirectoryReference;
import org.junit.*;
import org.junit.rules.TestName;

/**
 * @author leon on 5/26/18.
 */
public class ExtentTestLoggerTest {
    private static ExtentTestLoggerFactory extentTestLoggerFactory;
    @Rule
    public TestName name = new TestName();
    private ExtentTestLoggerInterface logger;
    private ExtentAssert assertion;


    @BeforeClass
    public static void staticSetup() {
        final String reportName = "/test.html";
        ExtentTestLoggerTest.extentTestLoggerFactory = new ExtentTestLoggerFactory(DirectoryReference
                .REPORT_DIRECTORY
                .getFileFromDirectory(reportName)
                .getAbsolutePath());
    }

    @Before
    public void instanceSetup() {
        this.logger = extentTestLoggerFactory.createExtentTestLogger(name.getMethodName());
        this.assertion = new ExtentAssert(logger);
    }

    @After
    public void teardown() {
        logger.flush();
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
        assertion.assertNotNull(actual);
        assertion.assertNotEqual(5, actual);
        assertion.assertEquals(expected, actual);
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
        assertion.assertEquals(expected, actual);
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
        assertion.assertEquals(expected, actual);
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
        assertion.assertEquals(expected, actual);
    }

}

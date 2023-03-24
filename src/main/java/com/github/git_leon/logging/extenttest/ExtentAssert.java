package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.Status;
import org.junit.Assert;
import org.junit.ComparisonFailure;

import java.util.Arrays;
import java.util.function.BiConsumer;
import java.util.logging.Level;

public class ExtentAssert {
    private final ExtentTestLoggerInterface logger;

    public ExtentAssert(ExtentTestLoggerInterface logger) {
        this.logger = logger;
    }

    public ExtentTestLoggerInterface getLogger() {
        return logger;
    }

    public <SomeType> void log(
            BiConsumer<Object, Object> assertion,
            SomeType expected,
            SomeType actual) {
        try {
            assertion.accept(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(Object[] expected, Object[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertEquals(Object expected, Object actual) {
        final Class<?> expectedClass = expected.getClass();
        final Class<?> actualClass = actual.getClass();
        final boolean areSameClass = expectedClass.equals(actualClass);
        final boolean isArray = expectedClass.isArray();
        final boolean shouldBeComparedAsArrays = areSameClass && isArray;
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expected, actual));
            if (shouldBeComparedAsArrays) {
                Assert.assertArrayEquals((Object[]) expected, (Object[]) actual);
            } else {
                Assert.assertEquals(expected, actual);
                logger.log(Status.PASS, successMessage);
            }
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }


    public void assertNotEqual(Object expected, Object actual) {
        final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
        final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
        final String successMessage = "The two objects being compared were not identical.";
        logger.log(Level.INFO, String.format(attemptMessage, expected, actual));
        try {
            Assert.assertNotEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertNotNull(Object expected) {
        assertNotEqual(expected, null);
    }

    public void assertTrue(Boolean value) {
        assertEquals(true, value);
    }

    public void assertFalse(Boolean value) {
        assertEquals(false, value);
    }

    public void assertArrayEquals(int[] expected, int[] actual) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(char[] expected, char[] actual) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(short[] expected, short[] actual) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }


    public void assertArrayEquals(byte[] expected, byte[] actual) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(long[] expected, long[] actual) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(double[] expected, double[] actual, double delta) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ] with an acceptable difference of [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual, delta);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(float[] expected, float[] actual, float delta) {
        try {
            final ExtentTestLogger logger = ((ExtentTestLogger) this.logger);
            final String expectedString = Arrays.toString(expected);
            final String actualString = Arrays.toString(actual);
            final String attemptMessage = "Attempting to compare [ %s ] to [ %s ] with an acceptable difference of [ %s ]";
            final String successMessage = "The two objects being compared were identical.";
            logger.log(Level.INFO, String.format(attemptMessage, expectedString, actualString));
            Assert.assertArrayEquals(expected, actual, delta);
            logger.log(Status.PASS, successMessage);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
            throw failure;
        }
    }

    public void assertArrayEquals(double[] expected, double[] actual) {
        assertArrayEquals(expected, actual, 0.001);
    }

    public void assertArrayEquals(float[] expected, float[] actual) {
        assertArrayEquals(expected, actual, 0.001F);
    }
}

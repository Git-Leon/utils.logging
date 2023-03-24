package com.github.git_leon.logging.extenttest;

import org.junit.Assert;
import org.junit.ComparisonFailure;

import java.util.function.BiConsumer;
import java.util.logging.Level;

public class ExtentAssert {
    private final ExtentTestLogger logger;

    public ExtentAssert(ExtentTestLogger logger) {
        this.logger = logger;
    }

    public ExtentTestLogger getLogger() {
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
        }
    }

    public void assertArrayEquals(Object[] expected, Object[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public void assertEquals(Object expected, Object actual) {
        final Class<?> expectedClass = expected.getClass();
        final Class<?> actualClass = actual.getClass();
        final boolean areSameClass = expectedClass.equals(actualClass);
        final boolean isArray = expectedClass.isArray();
        final boolean shouldBeComparedAsArrays = areSameClass && isArray;
        try {
            if (shouldBeComparedAsArrays) {
                Assert.assertArrayEquals((Object[]) expected, (Object[]) actual);
            } else {
                Assert.assertEquals(expected, actual);
            }
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public void assertTrue(Boolean value) {
        assertEquals(true, value);
    }

    public void assertFalse(Boolean value) {
        assertEquals(false, value);
    }

    public <SomeType> void assertArrayEquals(int[] expected, int[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(char[] expected, char[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(short[] expected, short[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }


    public <SomeType> void assertArrayEquals(byte[] expected, byte[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(long[] expected, long[] actual) {
        try {
            Assert.assertArrayEquals(expected, actual);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(double[] expected, double[] actual, double delta) {
        try {
            Assert.assertArrayEquals(expected, actual, delta);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(float[] expected, float[] actual, float delta) {
        try {
            Assert.assertArrayEquals(expected, actual, delta);
        } catch (ComparisonFailure failure) {
            logger.log(Level.SEVERE, failure.getMessage());
        }
    }

    public <SomeType> void assertArrayEquals(double[] expected, double[] actual) {
        assertArrayEquals(expected, actual, 0.001);
    }

    public <SomeType> void assertArrayEquals(float[] expected, float[] actual) {
        assertArrayEquals(expected, actual, 0.001F);
    }
}

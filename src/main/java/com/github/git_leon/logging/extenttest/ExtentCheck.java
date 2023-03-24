package com.github.git_leon.logging.extenttest;

import java.util.Arrays;

public class ExtentCheck {
    public static boolean isTrue(Boolean value) {
        return value;
    }

    public static boolean isFalse(Boolean value) {
        return value;
    }

    public static boolean areArrayEquals(int[] expected, int[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }

    public static boolean areArrayEquals(char[] expected, char[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }

    public static boolean areArrayEquals(short[] expected, short[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }


    public static boolean areArrayEquals(byte[] expected, byte[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }

    public static boolean areArrayEquals(double[] expecteds, double[] actuals, double delta) {
        for (int i = 0; i < expecteds.length; i++) {
            final double expected = expecteds[i];
            final double actual = actuals[i];
            final double difference = Math.abs(expected - actual);
            if(difference > delta) {
                return false;
            }
        }
        return true;
    }

    public static boolean areArrayEquals(double[] expected, double[] actual) {
        return areArrayEquals(expected, actual, 0.001);
    }

    public static boolean areArrayEquals(long[] expected, long[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }

    public static boolean areArrayEquals(float[] expecteds, float[] actuals, float delta) {
        for (int i = 0; i < expecteds.length; i++) {
            final double expected = expecteds[i];
            final double actual = actuals[i];
            final double difference = Math.abs(expected - actual);
            if(difference > delta) {
                return false;
            }
        }
        return true;
    }

    public static boolean areArrayEquals(float[] expected, float[] actual) {
        return areArrayEquals(expected, actual, 0.001F);
    }

    public static <SomeType> boolean areArrayEquals(SomeType[] expected, SomeType[] actual) {
        return Arrays.toString(expected).equals(Arrays.toString(actual));
    }

    public static <SomeType> boolean areEquals(SomeType expected, SomeType actual) {
        return expected.equals(actual);
    }
}

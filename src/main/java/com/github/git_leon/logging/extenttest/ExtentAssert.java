package com.github.git_leon.logging.extenttest;

public class ExtentAssert {

    public static void assertTrue(Boolean value) {
        assertEquals(true, value);
    }

    public static void assertFalse(Boolean value) {
        assertEquals(false, value);
    }

    public static <SomeType> void assertArrayEquals(int[] expected, int[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }

    public static <SomeType> void assertArrayEquals(char[] expected, char[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }

    public static <SomeType> void assertArrayEquals(short[] expected, short[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }


    public static <SomeType> void assertArrayEquals(byte[] expected, byte[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }

    public static <SomeType> void assertArrayEquals(double[] expected, double[] actual, double delta) {
        ExtentCheck.areArrayEquals(expected, actual, delta);
    }

    public static <SomeType> void assertArrayEquals(double[] expected, double[] actual) {
        ExtentCheck.areArrayEquals(expected, actual, 0.001);
    }

    public static <SomeType> void assertArrayEquals(long[] expected, long[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }

    public static <SomeType> void assertArrayEquals(float[] expected, float[] actual, float delta) {
        ExtentCheck.areArrayEquals(expected, actual, delta);
    }

    public static <SomeType> void assertArrayEquals(float[] expected, float[] actual) {
        ExtentCheck.areArrayEquals(expected, actual, 0.001F);
    }

    public static <SomeType> void assertArrayEquals(SomeType[] expected, SomeType[] actual) {
        ExtentCheck.areArrayEquals(expected, actual);
    }

    public static <SomeType> void assertEquals(SomeType expected, SomeType actual) {
        ExtentCheck.areEquals(expected, actual);
    }
}

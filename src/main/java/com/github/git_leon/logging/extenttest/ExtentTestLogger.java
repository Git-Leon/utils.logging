package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestLogger implements ExtentTestLoggerInterface {
    private final ExtentTest extentTest;
    private boolean isEnabled;

    public ExtentTestLogger(Class<?> clazz, String testDescription) {
        this(new ExtentHtmlReporter(clazz.getName()), clazz.getName(), testDescription);

    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, String testName, String testDescription) {
        this(reporter, new ExtentReports(), testName, testDescription);
    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, ExtentReports extentReports, String testName, String testDescription) {
        extentReports.attachReporter(reporter);
        this.extentTest = extentReports.createTest(testName, testDescription);
    }

    @Override
    public void disable() {
        this.isEnabled = false;
    }

    @Override
    public void enable() {
        this.isEnabled = true;
    }

    @Override
    public boolean isEnabled() {
        return this.isEnabled;
    }

    @Override
    public ExtentTest getExtentTest() {
        return extentTest;
    }
}

package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.git_leon.logging.utils.DirectoryReference;

import java.util.logging.Level;

public class ExtentTestLogger implements ExtentTestLoggerInterface {
    private final ExtentTest extentTest;
    private final ExtentHtmlReporter extentReporter;
    private final ExtentReports extentReports;
    private boolean isEnabled = true;

    public ExtentTestLogger(Class<?> clazz, String testDescription) {
        this(DirectoryReference
                        .REPORT_DIRECTORY
                        .getFileFromDirectory("/test.html")
                        .getAbsolutePath(),
                clazz.getName(),
                testDescription);
    }

    public ExtentTestLogger(String path, String name, String testDescription) {
        this(new ExtentHtmlReporter(path), name, testDescription);
    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, String testName, String testDescription) {
        this(reporter, new ExtentReports(), testName, testDescription);
    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, ExtentReports extentReports, ExtentTest extentTest) {
        this.extentReporter = reporter;
        this.extentReports = extentReports;
        this.extentTest = extentTest;
    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, ExtentReports extentReports, String testName, String testDescription) {
        extentReports.attachReporter(reporter);
        this.extentReporter = reporter;
        this.extentReports = extentReports;
        this.extentTest = extentReports.createTest(testName, testDescription);
    }

    public void log(Status status, String logMessage, Object... logMessageArgs) {
        if (isEnabled()) {
            getExtentTest().log(status, String.format(logMessage, logMessageArgs));
        }
    }

    @Override
    public ExtentHtmlReporter getExtentReporter() {
        return extentReporter;
    }

    @Override
    public ExtentReports getExtentReports() {
        return extentReports;
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

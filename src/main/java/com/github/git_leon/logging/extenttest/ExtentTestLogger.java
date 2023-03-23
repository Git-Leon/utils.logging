package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.git_leon.logging.DirectoryReference;

public class ExtentTestLogger implements ExtentTestLoggerInterface {
    private final ExtentTest extentTest;
    private final ExtentHtmlReporter extentReporter;
    private final ExtentReports extentReports;
    private boolean isEnabled;

    public ExtentTestLogger(Class<?> clazz, String testDescription) {
        this(DirectoryReference
                        .REPORT_DIRECTORY
                        .getDirectoryFile()
                        .getAbsolutePath(),
                clazz.getName(),
                testDescription);
    }

    public ExtentTestLogger(Class<?> clazz) {
        this(clazz, clazz.getName() + "@" + System.currentTimeMillis());
    }

    public ExtentTestLogger(String path, String name, String testDescription) {
        this(new ExtentHtmlReporter(path), name, testDescription);
    }

    public ExtentTestLogger(ExtentHtmlReporter reporter, String testName, String testDescription) {
        this(reporter, new ExtentReports(), testName, testDescription);
    }


    public ExtentTestLogger(ExtentHtmlReporter reporter, ExtentReports extentReports, String testName, String testDescription) {
        extentReports.attachReporter(reporter);
        this.extentReporter = reporter;
        this.extentReports = extentReports;
        this.extentTest = extentReports.createTest(testName, testDescription);
        this.isEnabled = true;
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

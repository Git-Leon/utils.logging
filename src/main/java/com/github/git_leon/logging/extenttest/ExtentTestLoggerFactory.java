package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtentTestLoggerFactory {
    private ExtentHtmlReporter reporter;

    private ExtentReports reports;

    public ExtentTestLoggerFactory(String path) {
        this(new ExtentHtmlReporter(path), new ExtentReports());

    }

    public ExtentTestLoggerFactory(ExtentHtmlReporter reporter, ExtentReports reports) {
        this.reporter = reporter;
        this.reports = reports;
        reports.attachReporter(reporter);
    }

    public ExtentTestLogger createExtentTestLogger(String loggerName, String loggerDescription) {
        if ("".equals(loggerDescription) || loggerDescription == null) {
            return new ExtentTestLogger(reporter, reports, this.reports.createTest(loggerName));
        }
        return new ExtentTestLogger(reporter, reports, this.reports.createTest(loggerName, loggerDescription));
    }

}

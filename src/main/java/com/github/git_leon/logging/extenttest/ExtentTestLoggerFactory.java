package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.github.git_leon.logging.DirectoryReferenceInterface;

public class ExtentTestLoggerFactory {
    private ExtentHtmlReporter reporter;

    private ExtentReports reports;

    public ExtentTestLoggerFactory(DirectoryReferenceInterface directoryReference, String fileName) {
        this(directoryReference
                .getFileFromDirectory("/" + fileName)
                .getAbsolutePath());
    }

    public ExtentTestLoggerFactory(String path) {
        this(new ExtentHtmlReporter(path), new ExtentReports());

    }

    public ExtentTestLoggerFactory(ExtentHtmlReporter reporter, ExtentReports reports) {
        this.reporter = reporter;
        this.reports = reports;
        reports.attachReporter(reporter);
    }

    public ExtentTestLogger createExtentTestLogger(String loggerName, String loggerDescription) {
        loggerName = loggerName + "." + System.currentTimeMillis();
        if ("".equals(loggerDescription) || loggerDescription == null) {
            return new ExtentTestLogger(reporter, reports, this.reports.createTest(loggerName));
        }
        return new ExtentTestLogger(reporter, reports, this.reports.createTest(loggerName, loggerDescription));
    }

    public ExtentTestLogger createExtentTestLogger(String loggerName) {
        return createExtentTestLogger(loggerName, null);
    }

}

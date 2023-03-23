package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.HashMap;
import java.util.Map;

public class ExtentHtmlReporterFactory implements ExtentHtmlReporterFactoryInterface {
    private Map<String, ExtentHtmlReporter> reporterMap;

    public ExtentHtmlReporterFactory() {
        this(new HashMap<>());
    }

    public ExtentHtmlReporterFactory(Map<String, ExtentHtmlReporter> reporterMap) {
        this.reporterMap = reporterMap;
    }

    @Override
    public Map<String, ExtentHtmlReporter> getReporterMap() {
        return reporterMap;
    }
}

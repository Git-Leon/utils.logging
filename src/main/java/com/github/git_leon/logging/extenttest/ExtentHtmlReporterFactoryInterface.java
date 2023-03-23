package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.Map;

public interface ExtentHtmlReporterFactoryInterface {

    default ExtentHtmlReporter createExtentHtmlReporter(String filePath) {
        if (!containsExtentHtmlReporter(filePath)) {
            getReporterMap().put(filePath, new ExtentHtmlReporter(filePath));
        }
        return getReporterMap().get(filePath);
    }


    default ExtentHtmlReporter getExtentHtmlReporter(String filePath) {
        return getReporterMap()
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getKey().equals(filePath))
                .map(Map.Entry::getValue)
                .findFirst()
                .get();
    }

    default boolean containsExtentHtmlReporter(String name) {
        return getReporterMap()
                .entrySet()
                .stream()
                .anyMatch(entrySet -> entrySet.getKey().equals(name));
    }


    default ExtentHtmlReporter getExtentHtmlReporter(Class<?> clazz) {
        return getExtentHtmlReporter(clazz.getName());
    }


    default ExtentHtmlReporter createExtentHtmlReporter(Class<?> clazz) {
        return createExtentHtmlReporter(clazz.getName());
    }

    Map<String, ExtentHtmlReporter> getReporterMap();
}

package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import java.util.Map;

public interface ExtentHtmlReporterFactoryInterface {

    default ExtentHtmlReporter createExtentHtmlReporter(String name) {
        if (!containsExtentHtmlReporter(name)) {
            getReporterMap().put(name, new ExtentHtmlReporter(name));
        }
        return getReporterMap().get(name);
    }


    default ExtentHtmlReporter getExtentHtmlReporter(String name) {
        return getReporterMap()
                .entrySet()
                .stream()
                .filter(entrySet -> entrySet.getKey().equals(name))
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

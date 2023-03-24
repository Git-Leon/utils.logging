package com.github.git_leon.logging.extenttest;

import com.aventstack.extentreports.Status;

import java.util.logging.Level;
import java.util.stream.Stream;

public enum ExtentTestStatus {
    PASS(Status.PASS, Level.FINE),
    FAIL(Status.FAIL, Level.SEVERE),
    FATAL(Status.FATAL, Level.SEVERE),
    ERROR(Status.ERROR, Level.SEVERE),
    WARNING(Status.WARNING, Level.WARNING),
    INFO(Status.INFO, Level.INFO),
    DEBUG(Status.DEBUG, Level.FINEST),
    SKIP(Status.SKIP, Level.OFF);

    private final Level level;
    private final Status status;

    ExtentTestStatus(Status status, Level level) {
        this.status = status;
        this.level = level;
    }

    public Level getLevel() {
        return level;
    }

    public Status getStatus() {
        return status;
    }

    public static Status getStatus(Level level) {
        return Stream.of(values())
                .filter(extentTestStatus -> extentTestStatus.getLevel().equals(level))
                .findFirst()
                .get()
                .getStatus();
    }

    public static Level getLevel(Status status) {
        return Stream.of(values())
                .filter(extentTestStatus -> extentTestStatus.getStatus().equals(status))
                .findFirst()
                .get()
                .getLevel();
    }

    public static Level[] getLevels() {
        return Stream.of(values())
                .map(ExtentTestStatus::getLevel)
                .toArray(Level[]::new);
    }
}

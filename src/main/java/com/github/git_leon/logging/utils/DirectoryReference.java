package com.github.git_leon.logging.utils;

/**
 * @author leonhunter
 * @created 05/04/2020 - 2:34 AM
 */
public enum DirectoryReference implements DirectoryReferenceInterface {
    RESOURCE_DIRECTORY(new StringBuilder()
            .append(System.getProperty("user.dir")) // local directory
            .append("/src/main/resources/")
            .toString()),
    TARGET_DIRECTORY(new StringBuilder()
            .append(System.getProperty("user.dir")) // local directory
            .append("/target/")
            .toString()),
    REPORT_DIRECTORY(new StringBuilder()
            .append(System.getProperty("user.dir")) // local directory
            .append("/target/reports/")
            .toString()),
    TEST_TARGET_DIRECTORY(new StringBuilder()
            .append(System.getProperty("user.dir")) // local directory
            .append("/target/test/")
            .toString());


    private final String path;

    DirectoryReference(String path) {
        this.path = path;
    }

    @Override
    public String getDirectoryPath() {
        return path;
    }
}


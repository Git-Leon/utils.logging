package com.github.git_leon.logging;

import java.io.File;

public interface DirectoryReferenceInterface {
    String getDirectoryPath();

    default File getDirectoryFile() {
        return new File(getDirectoryPath());
    }

    default File getFileFromDirectory(String fileName) {
        return new File(getDirectoryPath() + fileName);
    }
}

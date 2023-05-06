package org.example.model.enums;

public enum FilePaths {
    DATEBASE("d:/json/dataBase.json"),
    WORKING_DIR("d:/json/"),
    ;
    private final String filePaths;

    FilePaths(String filePaths) {
        this.filePaths = filePaths;
    }

    public String getFilePaths() {
        return filePaths;
    }
}

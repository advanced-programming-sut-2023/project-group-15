//this class is completed!
package org.example.model.enums;

public enum FilePaths {
    DATEBASE("d:/json/dataBase.json"),
    MAP1("d:/Map/defaultMap1.json"),
    Map2("d:/Map/defaultMap2.json"),
    Map3("d:/Map/defaultMap3.json"),
    Map4("d:/Map/defaultMap4.json"),
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


package com.company.serviceClasses;

public class Utils {

    private String txt = ".txt";

    public String addEncodeToFileName(String fileName, String suffix) {
        return fileName.substring(0, fileName.lastIndexOf(txt)) + suffix + txt;
    }

    public String addDecodeToFileName(String fileName, String suffix) {
        return fileName.substring(0, fileName.lastIndexOf("_encoded")) + suffix + txt;
    }
}

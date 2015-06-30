package com.ansa;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileScannerTest {

    private String testPath;

    @Test
    public void normal() throws IOException {
        Path inputDir = Files.createTempDirectory("inputDir");
        Path subDir = Files.createTempDirectory(inputDir, "subDir");
        Path outputDir = Files.createTempDirectory("outputDir");


        Path file = Files.createTempFile(inputDir, "tmp", ".tmp");
        Path subFile = Files.createTempFile(subDir, "subFile", ".tmp");
        for (File _file : inputDir.toFile().listFiles()){
            System.out.println(_file.getName());
            Files.copy(_file.toPath(), outputDir);
        }



        FileUtils.deleteRecursively(inputDir);
        FileUtils.deleteRecursively(outputDir);
    }


}

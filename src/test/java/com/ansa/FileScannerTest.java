package com.ansa;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Arrays;
import java.util.LinkedList;

public class FileScannerTest {

    private String testPath;

    @Test
    public void normal() throws IOException {



        Path inputDir = Files.createTempDirectory("inputDir");
        Path subDir = Files.createTempDirectory(inputDir, "subDir");
        Path subSubDir = Files.createTempDirectory(subDir, "subDirDir");
        Path outputDir = Files.createTempDirectory("outputDir");


        Path file = Files.createTempFile(inputDir, "tmp", ".tmp");
        Path subFile = Files.createTempFile(subDir, "subFile", ".tmp");

        FileScannerParams params = new FileScannerParams();
        params.setAutoDelete(false);


        print(inputDir);

        Files.walkFileTree(inputDir, new SimpleFileVisitor<Path>() {

            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                if (dir.equals(inputDir)){
                    return FileVisitResult.CONTINUE;
                }
                Path tmp = inputDir.relativize(dir);
                Path tmp2 = outputDir.resolve(tmp);
                Files.copy(dir, tmp2);

                return FileVisitResult.CONTINUE;

            }

            @Override
            public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
                if (params.isAutoDelete()&&(!dir.equals(inputDir))){
                    Files.delete(dir);
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path tmp = inputDir.relativize(file);
                Path tmp2 = outputDir.resolve(tmp);
                if (params.isAutoDelete()){
                    Files.copy(file, tmp2);
                     Files.delete(file);
                } else {
                    Files.copy(file, tmp2);
                }

                return FileVisitResult.CONTINUE;
            }


        });



        print(inputDir);
        print(outputDir);

        FileUtils.deleteRecursively(inputDir);
        FileUtils.deleteRecursively(outputDir);

    }

    private void print(Path inputDir) {
        System.out.println("Print " + inputDir);
        LinkedList<File> q = new LinkedList<>();
        q.addAll(Arrays.asList(inputDir.toFile().listFiles()));

        while (!q.isEmpty()){
            File file = q.poll();
            System.out.println(file.getAbsolutePath());
            if (file.isDirectory()){
                q.addAll(Arrays.asList(file.listFiles()));
            }
        }
    }


}

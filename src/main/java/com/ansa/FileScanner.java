package com.ansa;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

public class FileScanner implements Runnable {

    private FileScannerParams params;

    public FileScanner(FileScannerParams params){
        this.params = params;

    }
    @Override
    public void run() {
        //System.out.println("execute " + params.getInputFolderName());
        // copy files by mask, check if sub dir flag is ON and if do auto deletion


        Path inputPath = Paths.get(params.getInputFolderName());

        File inputFile = inputPath.toFile();
        for (File file : inputFile.listFiles()){
            System.out.println(file.getName().matches(params.getFileMask()));

        }







    }
}

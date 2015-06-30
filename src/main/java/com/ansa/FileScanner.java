package com.ansa;

import org.apache.commons.io.filefilter.WildcardFileFilter;

import java.io.File;
import java.io.FileFilter;
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
        Path outputPath = Paths.get(params.getOutputFolderName());

        FileFilter fileFilter = new WildcardFileFilter(params.getFileMask());
        for (File file : inputPath.toFile().listFiles(fileFilter)){


        }








    }
}

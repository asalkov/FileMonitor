package com.ansa;

public class FileScanner implements Runnable {

    private FileScannerParams params;

    public FileScanner(FileScannerParams params){
        this.params = params;

    }
    @Override
    public void run() {
        //System.out.println("execute " + params.getInputFolderName());
    }
}

package com.ansa;

public class FileScannerParams {
    private String inputFolderName;
    private String outputFolderName;
    private String fileMask;
    private int waitInterval;
    private boolean includeSubFolders;
    private boolean autoDelete;

    public String getInputFolderName() {
        return inputFolderName;
    }

    public void setInputFolderName(String inputFolderName) {
        this.inputFolderName = inputFolderName;
    }

    public void setOutputFolderName(String outputFolderName) {
        this.outputFolderName = outputFolderName;
    }

    public String getOutputFolderName() {
        return outputFolderName;
    }

    public void setFileMask(String fileMask) {
        this.fileMask = fileMask;
    }

    public String getFileMask() {
        return fileMask;
    }

    public int getWaitInterval() {
        return waitInterval;
    }

    public void setWaitInterval(int waitInterval) {
        this.waitInterval = waitInterval;
    }

    public void setIncludeSubFolders(boolean includeSubFolders) {
        this.includeSubFolders = includeSubFolders;
    }

    public boolean isIncludeSubFolders() {
        return includeSubFolders;
    }

    public boolean isAutoDelete() {
        return autoDelete;
    }

    public void setAutoDelete(boolean autoDelete) {
        this.autoDelete = autoDelete;
    }
}

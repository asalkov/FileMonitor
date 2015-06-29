package com.ansa;

public class CmdParser {

    private static final String INPUT = "-input";
    private static final String OUTPUT = "-output";
    private static final String MASK = "-mask";
    private static final String WAIT_INTERVAL = "-waitInterval";
    private static final String INCLUDE_SUB_FOLDERS = "-includeSubFolders";
    private static final String AUTO_DELETE = "-autoDelete";

    public CmdParser(){

    }

    public FileScannerParams parse(String cmd){
        String[] args = cmd.split(" ");

        if (!args[0].equals("scan"))
            throw new IllegalArgumentException("Unsupported command " + args[0]);

        int indx=1;

        FileScannerParams params = new FileScannerParams();

        while (indx < args.length){
            System.out.println("current value = " + args[indx]);
            switch (args[indx]){
                case INPUT:
                    params.setInputFolderName(args[++indx]);
                    break;
                case OUTPUT:
                    params.setOutputFolderName(args[++indx]);
                    break;
                case MASK:
                    params.setFileMask(args[++indx]);
                    break;
                case WAIT_INTERVAL:
                    params.setWaitInterval(Integer.parseInt(args[++indx]));
                    break;
                case INCLUDE_SUB_FOLDERS:
                    params.setIncludeSubFolders(Boolean.parseBoolean(args[++indx]));
                    break;
                case AUTO_DELETE:
                    params.setAutoDelete(Boolean.parseBoolean(args[++indx]));
                    break;
                default:
                    throw new IllegalArgumentException("Unsupported command parameter name:" + args[indx]);
            }
            indx++;
        }

        return params;

    }
}

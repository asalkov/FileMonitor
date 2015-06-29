package com.ansa;

import java.util.Scanner;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Runner {

    private static final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CmdParser parser  = new CmdParser();

        String cmdLine = "";
        while (!cmdLine.equals("quit")){
            System.out.print("=> ");
            cmdLine = in.nextLine();
            if (cmdLine.equals("quit")){
                scheduler.shutdown();
                return;
            }
            try {
                FileScannerParams params = parser.parse(cmdLine);
                scheduler.scheduleAtFixedRate(new FileScanner(params), 0, params.getWaitInterval(), TimeUnit.MILLISECONDS);
            } catch (IllegalArgumentException ex){
                System.out.println(ex.getMessage());
            }
        }
    }
}

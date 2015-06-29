package com.ansa;

import java.util.Scanner;

public class Runner {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        CmdParser parser  = new CmdParser();

        String cmdLine = "";
        while (!cmdLine.equals("quit")){
            System.out.print("=> ");
            cmdLine = in.nextLine();
            FileScannerParams params = parser.parse(cmdLine);



        }
    }
}

package com.ansa;

import org.apache.commons.io.filefilter.WildcardFileFilter;
import org.junit.Test;

import java.io.File;
import java.io.FileFilter;

public class FileScannerTest {

    @Test
    public void normal(){
        File test = new File("data");

        FileFilter fileFilter = new WildcardFileFilter("*test*");

        File[] files = test.listFiles(fileFilter);
        for (File file : files){
            System.out.println(file.getName());
        }





    }


}

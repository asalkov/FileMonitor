package com.ansa;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CmdParserTest {

    private CmdParser parser;

    @Before
    public void init() {
        parser = new CmdParser();
    }


    @Test
    public void normal(){
        FileScannerParams params = parser.parse("scan -input testInputFolder -output testOutputFolder -mask \"*.xml\" -waitInterval 9000 -includeSubFolders true -autoDelete false");
        System.out.println(params.getInputFolderName());
        Assert.assertEquals("testInputFolder", params.getInputFolderName());
        Assert.assertEquals("testOutputFolder", params.getOutputFolderName());
        Assert.assertEquals("\"*.xml\"", params.getFileMask());
        Assert.assertEquals(9000, params.getWaitInterval());
        Assert.assertEquals(true, params.isIncludeSubFolders());
        Assert.assertEquals(false, params.isAutoDelete());
    }

    @Test(expected = IllegalArgumentException.class)
    public void unsupportedCommand(){
        parser.parse("not_scan");
    }
}

package com.rentshape;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestHtmlChunks {
    @Test
    public void loadsChunksFromResources(){
        String script = HtmlChunks.googleAnalyticsScript;
        Assert.assertNotNull(script);
        Assert.assertEquals(script.substring(0,8), "<script>");
    }
}

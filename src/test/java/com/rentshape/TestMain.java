package com.rentshape;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by matt on 2/20/17.
 */
public class TestMain {

    @Test
    public void httpsRedirectConversion(){
        String uri = "http://rentshape.com/fragment";
        String redirect = Main.setHttpsForRedirect(uri);
        Assert.assertEquals(redirect, "https://rentshape.com/fragment");
    }

}

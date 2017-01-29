package com.rentshape;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * Created by matt on 1/21/17.
 */
public class TestApplicationData {
    @Test
    public void savesToJson(){
        ApplicationData app = new ApplicationData();
        app.put("firstName", "Foo");
        app.put("lastName", "Bar");
        app.put("bogus", "baz");
        String json = app.toJson();

        Assert.assertEquals(json, "{\"firstName\":\"Foo\",\"lastName\":\"Bar\"}");

        ApplicationData parsed = ApplicationData.fromJson(json);
        Assert.assertEquals(parsed.get("firstName"), "Foo");
        Assert.assertEquals(parsed.get("lastName"), "Bar");
    }

    @Test
    public void savesUuid(){
        ApplicationData app = new ApplicationData();
        app.put("firstName", "Alice");
        app.setUuid("123");
        String json = app.toJson();

        ApplicationData parsed = ApplicationData.fromJson(json);

        Assert.assertEquals(parsed.getUuid(), "123");
    }
}

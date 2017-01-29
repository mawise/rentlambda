package com.rentshape;

import com.amazonaws.auth.profile.ProfileCredentialsProvider;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.PutItemOutcome;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import spark.ModelAndView;
import spark.servlet.SparkApplication;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.HashMap;
import java.util.Map;

import static spark.Spark.*;

public class Main implements SparkApplication {

    private static String HDR = HtmlChunks.header;
    private static String FTR = HtmlChunks.footer;

    private static String root;
    private static String tableName;
    private static int port;

    static {
        String env = "prod"; // TODO: use env variable?
        if (env.equals("prod")) {
            //Prod
            root = "rentshape.com";
            tableName = "ProdRent";
            port = 80;
        } else {
            //Test
            root = "localhost";
            tableName = "TestRent";
            port = 4567;
        }
    }
    private static ObjectMapper mapper = new ObjectMapper();

    public void init(){
        AmazonDynamoDBClient dynamoDBClient = new AmazonDynamoDBClient(
                new ProfileCredentialsProvider());
        dynamoDBClient.withRegion(Regions.US_WEST_2);
        DynamoDB dynamoDB = new DynamoDB(dynamoDBClient);

        Table table = dynamoDB.getTable(tableName);

        port(port);

        get("/", (req, res) -> {
            StringBuilder sb = new StringBuilder();
            sb.append("<p>Here is an online rental application you can fill out and share with potential landlords.  The form was designed for use in California, but you can use it wherever you want.");
            sb.append("<p>Fill out the form and hit save at the bottom.  You will be given a private link to print or share with potential landlords.");
            sb.append("<p>Feedback?  Questions?  <a href=\"https://goo.gl/forms/ZgnLVbx6xHbGITS12\">Let us know!</a>");
            sb.append("<form action=\"/application\" method=\"post\">");

            for (String field : ApplicationData.fields.keySet()){
                String title = ApplicationData.fields.get(field);
                if (ApplicationData.breakers.contains(field)){
                    sb.append("<br><br>");
                }
                if (field.equals("debt1-creditor")){
                    sb.append("<span id=\"helpBlock\" class=\"help-block\">");
                    sb.append("Please list all financial obligations");
                    sb.append("</span>");
                }
                if (field.equals("car1-make")){
                    sb.append("<span id=\"helpBlock\" class=\"help-block\">");
                    sb.append("Automobiles");
                    sb.append("</span>");
                }

                sb.append("<div class=\"form-group\">");
                sb.append("<label for=\""+field+"\">"+title+"</label>");
                sb.append("<input type=\"text\" class=\"form-control\" id=\""+field+"\" name=\""+field+"\">");
                sb.append("</div>");
            }
            sb.append("<button type=\"submit\" class=\"btn btn-default\">Save Application</button>");
            sb.append("</form>");
            return HDR + sb.toString() + FTR;
        });

        post("/application", (req, res) -> {
            ApplicationData data = new ApplicationData();
            data.newUuid();

            for (String field : ApplicationData.fields.keySet()){
                String value = req.queryParams(field);
                data.put(field, value);
            }
            PutItemOutcome outcome = table.putItem(data.toItem());

            String link = "/application/" + data.getUuid();

            StringBuilder sb = new StringBuilder();
            sb.append("<p> Use the following private link to share or view your rental application: <br>");
            sb.append("<a href=\"");
            sb.append(link);
            sb.append("\">" + "rentshape.com" + link + "</a>");

            return HDR + sb.toString() + FTR;
        });

        get("/application/:id", (req, res) -> {
            String id = req.params(":id");
            Item item = table.getItem(ApplicationData.UUID, id);

            if (item == null){
                return new ModelAndView(new HashMap<String, String>(), "display.hbs");
            }
            String json = item.toJSON();
            Map<String, String> appData = mapper.readValue(
                    json, new TypeReference<HashMap<String, String>>() {});

            return new ModelAndView(appData, "display.hbs");
        }, new HandlebarsTemplateEngine());

        get("/*", (req, res) -> {
            res.redirect("/");
            return "";
        });

    }
}

package com.rentshape;

import com.amazonaws.util.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

public class HtmlChunks {
    private static Logger LOG = LoggerFactory.getLogger(Main.class);

    public static String googleAnalyticsScript = getResource("/templates/gascript.hbs");
    public static String navbar = getResource("/templates/navbar.hbs");

    public static String header =
            "<html>\n" +
            "<head>\n" +
            "    <meta charset=\"utf-8\">\n" +
            "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
            "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" +
            "\n" +
            "    <!-- Latest compiled and minified CSS -->\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\" integrity=\"sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u\" crossorigin=\"anonymous\">\n" +
            "\n" +
            "    <!-- Optional theme -->\n" +
            "    <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css\" integrity=\"sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp\" crossorigin=\"anonymous\">\n" +
            "    <link href=\"/css/jumbotron.css\" rel=\"stylesheet\">\n" +
                    "<style>\n" +
                    "body {padding-top: 50px;}\n" +
                    "</style>" +
            "</head>\n" +
            "<body>\n" +
            "    <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js\"></script>\n" +
            "    <!-- Latest compiled and minified JavaScript -->\n" +
            "    <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\" integrity=\"sha384-Tc5IQib027qvyjSMfHjOMaLkfuWVxZxUPnCJA7l2mCWNIpG9mGCD8wGNIcPD7Txa\" crossorigin=\"anonymous\"></script>\n" +
            navbar +
            "<div class=\"jumbotron\">\n" +
            "<div class=\"container\">\n";

    public static String footer =
            "<hr>\n" +
            "<small>This site is owned and operated by Rentshape LLC, Dover, Delaware.</small>\n" +
            "</div>\n" +
            "</div>\n" +
            googleAnalyticsScript +
            "</body>\n" +
            "</html>";


    private static String getResource(String path) {
        try(InputStream is = Thread.currentThread().getContextClassLoader().getResourceAsStream(path)) {
            return IOUtils.toString(is);
        } catch (IOException e) {
            LOG.error("Failed to read string from resource: " + path, e);
            return "";
        }
    }

}

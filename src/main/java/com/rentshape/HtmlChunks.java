package com.rentshape;

public class HtmlChunks {

    public static String googleAnalyticsScript =
            "<script>\n" +
            "  (function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" +
            "  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" +
            "  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" +
            "  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\n" +
            "\n" +
            "  ga('create', 'UA-91695228-1', 'auto');\n" +
            "  ga('send', 'pageview');\n" +
            "\n" +
            "</script>";

    //TODO: parse this from navbar.hbs
    public static String navbar =
            "<nav class=\"navbar navbar-inverse navbar-fixed-top\">\n" +
            "    <div class=\"container\">\n" +
            "        <div class=\"navbar-header\">\n" +
            "            <a class=\"navbar-brand\" href=\"/\">Rentshape</a>\n" +
            "        </div>\n" +
            "        <div id=\"navbar\" class=\"collapse navbar-collapse\">\n" +
            "            <ul class=\"nav navbar-nav\">\n" +
            "                <li><a href=\"/privacy\">Privacy</a></li>\n" +
            "                <li><a href=\"https://blogrentshape.wordpress.com/2017/02/05/how-to-rent-a-house-in-the-bay-area/\">Blog</a></li>\n" +
            "            </ul>\n" +
            "        </div><!--/.nav-collapse -->" +
            "    </div>\n" +
            "</nav>";

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



}

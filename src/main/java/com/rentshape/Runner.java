package com.rentshape;

/**
 * Use this for testing and dev, the Tomcat container initializes the app directly
 */
public class Runner {
    public static void main(String[] args){
        Main main = new Main();
        main.init();
    }
}

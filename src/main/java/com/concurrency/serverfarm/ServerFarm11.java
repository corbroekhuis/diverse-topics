package com.concurrency.serverfarm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerFarm11 {

    public static void main(String[] args) {

        //Create three callable as in ServerFarm01 with unique names

        ExecutorService service = Executors.newFixedThreadPool(3);

        // Create a list of Futures<Server>
        // submit each callable and add the future to the list

        // Loop through the futures and use the get method of the futures to display the status as before
        // Try to understand what is happening

        System.out.println( "Done...");
        service.shutdown();
    }
}

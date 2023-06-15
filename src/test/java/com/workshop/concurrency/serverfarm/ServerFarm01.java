package com.workshop.concurrency.serverfarm;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerFarm01 {

    public static void main(String[] args) {


        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<Server> callable = () -> new Server("Apache01").startServer();

        // submit this callable to the service

        // get the server from the Future using the get method
    	// it is unstable as its stable period is passed
        
        // Display the name of the server that is unstable
        // Try to understand what is happening

        System.out.println( "Done...");
        service.shutdown();
        
    }
}

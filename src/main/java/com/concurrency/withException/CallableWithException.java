package com.concurrency.withException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CallableWithException{

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        // submit an appropriate CallableTask task on the service

        // get the result and display it
        service.shutdown();
        System.out.println( "'Orderly' shutdown requested");

    }

    public static void main(String[] args) {

        // What is the difference with the Runnable version
        // Try to understand what exactly is happening

        System.out.println( "Start");
        new CallableWithException().run();
        System.out.println( "Done...");

    }

}


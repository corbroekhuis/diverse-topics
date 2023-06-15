package com.concurrency.withException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableWithException{

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        // execute a appropriate RunnableTask task on the service

        service.shutdown();
        System.out.println( "'Orderly' shutdown requested");

    }

    public static void main(String[] args) {

        // What is the difference with the Callable version
        // Try to understand waht exactly is happening

        System.out.println( "Start");
        new RunnableWithException().run();
        System.out.println( "Done...");

    }

}

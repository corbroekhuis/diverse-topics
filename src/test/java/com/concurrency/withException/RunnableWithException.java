package com.concurrency.withException;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RunnableWithException{

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        // We use an implementation of Runnable
        service.execute( new RunnableTask("Task1", 3000));

        service.shutdown();
        System.out.println( "'Orderly' shutdown requested");

    }

    public static void main(String[] args) {

        System.out.println( "Start");
        new RunnableWithException().run();
        System.out.println( "Done...");

    }

}



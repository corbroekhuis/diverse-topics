package com.concurrency.withException;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableWithException{

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        // We use an implementation of Callable
        Callable<String> callable = new CallableTask("Task1", 3000);
        Future<String> result = service.submit( callable);

        try {
			String resultString = result.get();
			System.out.println( resultString);
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			 System.out.println( "Cause: " + e.getCause());
		}
        service.shutdown();
        System.out.println( "'Orderly' shutdown requested");

    }

    public static void main(String[] args) {

        System.out.println( "Start");
        new CallableWithException().run();
        System.out.println( "Done...");

    }

}


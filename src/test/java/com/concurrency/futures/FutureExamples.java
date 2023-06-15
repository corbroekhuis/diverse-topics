package com.concurrency.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FutureExamples{

	public static void main( String[] args) {
		
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        Callable<Void> task1 = () -> {
            System.out.println("Task 1 is executing");
            return null;
        };

        Future<Void> future1 = service.submit(task1);
        
        try {
			Object result1 = future1.get();
	        System.out.println(result1);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
        
        
        Callable<Integer> task2 = ()-> { System.out.println("Task 2 is executing"); return 6;};
        Future<Integer> future2 = service.submit(task2);
        
        try {
			int result2 = future2.get();

			System.out.println(result2);
		} catch (InterruptedException | ExecutionException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

        
        Runnable task3 = () -> System.out.println("Task 3 is executing");
        Future<?> future3 = service.submit( task3);

		try {
			Object result3 = future3.get();
	        System.out.println(result3);

		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		service.execute(task3);

        service.shutdown();
         
	}

}

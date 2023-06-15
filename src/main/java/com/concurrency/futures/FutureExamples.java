package com.concurrency.futures;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class FutureExamples{

	public static void main( String[] args) {
		
        ExecutorService service = Executors.newSingleThreadExecutor();
        
        Callable<Void> task1 = () -> {
            System.out.println("Task 1 is executing");
            return null;
        };

        // Use the service.submit method to get an appropriate Future<T> reference to task1.
		// Obtain and show the result (you will need a try/catch block)
        
        
        Callable<Integer> task2 = ()-> { System.out.println("Task 2 is executing"); return 6;};
        // Do the same for this task2
        
        
        Runnable task3 = () -> System.out.println("Task 3 is executing");
        // Do the same for this task3

		
		// Run task 3 with the service.execute method
        
        
        
        // create new Runnables and/or Callables and do the same
        
        
        

        service.shutdown();
         
	}

}


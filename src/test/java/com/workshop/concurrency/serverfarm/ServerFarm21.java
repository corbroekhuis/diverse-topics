package com.workshop.concurrency.serverfarm;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerFarm21 {

    public static void main(String[] args) {

        //Create three callable as in ServerFarm01 with unique names

        ExecutorService service = Executors.newFixedThreadPool(3);

        // Create a list of Futures<Server>
        // submit each callable and add the future to the list

        // Loop through the futures and use the get method of the futures to display the status as before
        // Try to understand what is happening

//      try {
    	
      	while(true) {
          // Loop through the futures and use the get method of the futures to display the status as before
  		  // Then uncomment try/catch
  		  // Explain why the process doesn't stop
      	  // Kill the process
      	  // Move line   service.shutdown();    (below) to make the proces stop
            if(service.isTerminated()) {
            	break;
            }
      	}

//       } catch (InterruptedException e) {
//           e.printStackTrace();
//       } catch (ExecutionException e) {
//           e.printStackTrace();
//       }        
 
        service.shutdown();
        System.out.println( "Done...");
        
    }
}

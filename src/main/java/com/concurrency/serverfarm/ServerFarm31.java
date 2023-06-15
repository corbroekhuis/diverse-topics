package com.concurrency.serverfarm;

import com.concurrency.util.Util;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerFarm31 {

    public static void main(String[] args) {

        //Create three callables as in ServerFarm01 with unique names

        ExecutorService service = Executors.newFixedThreadPool(3);

        // Create a list of Futures<Server>
        // submit each callable and add the future to the list

        // Loop through the futures and use the get method of the futures to display the status as before
        

//        try {

            for(int n = 0; n < 60; n++) {

                System.out.println("Checking futures");

                // Create a second list of Futures<Server>
                
                // Loop through the futures using the isDone method to check if a server is unstable 
                // if so, restart a new server and add the new future to the second list
                // if not, add the running future to to the second list
                
                // clear the original Futures list and add the second list to the original one
                // Try to understand what is happening
                // You can wait to finish or kill to stop

                System.out.println("Sleeping 1 second");
                Util.sleep(1000);

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

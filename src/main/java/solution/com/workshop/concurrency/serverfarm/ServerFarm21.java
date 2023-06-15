package solution.com.workshop.concurrency.serverfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import solution.com.workshop.concurrency.util.Util;

public class ServerFarm21 {

    public static void main(String[] args) {

        List<Callable<Server>> callables = new ArrayList<>();

        callables.add( () -> new Server("Apache1" ).startServer());
        callables.add( () -> new Server("Apache2" ).startServer());
        callables.add( () -> new Server("Apache3" ).startServer());
        callables.add( () -> new Server("Apache4" ).startServer());
        callables.add( () -> new Server("Apache6" ).startServer());
        callables.add( () -> new Server("Apache7" ).startServer());
        callables.add( () -> new Server("Apache8" ).startServer());

        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<Server>> futures = null;
        try {
            futures = service.invokeAll(callables);
            Server server = service.invokeAny(callables);
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        service.shutdown();

        try {
        	
        	while(true) {
	            for( Future<Server> future: futures) {
	                Util.wait(100);
	            	if(future.isDone()) {
	            		Server server = future.get();
	            		System.out.println("Server " + server.getName() + " is down");
	            	}
	            }
	            if(service.isTerminated()) {
	            	break;
	            }
        	}

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


         System.out.println( "Done...");
        
        
    }
}

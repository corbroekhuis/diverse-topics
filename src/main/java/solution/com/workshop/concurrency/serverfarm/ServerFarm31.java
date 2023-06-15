package solution.com.workshop.concurrency.serverfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

import solution.com.workshop.concurrency.util.Util;

public class ServerFarm31 {

    public static void main(String[] args) {

        Server apache1 = new Server("Apache1" );
        Server apache2 = new Server("Apache2" );
        Server apache3 = new Server("Apache3" );

        Callable<Server> callable1 = () -> apache1.startServer();
        Callable<Server> callable2 = () -> apache2.startServer();
        Callable<Server> callable3 = () -> apache3.startServer();

        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<Server>> futures = new ArrayList<>();
        futures.add( service.submit(callable1));
        futures.add( service.submit(callable2));
        futures.add( service.submit(callable3));

        try {

        	for(int n = 0; n < 60; n++) {

                System.out.println("Checking futures");

                List<Future<Server>> restartedAndRunningfutures = new ArrayList<>();

                for (Future<Server> future : futures) {

                    if (future.isDone()) {
                        Server server = future.get();
                        System.out.println("-Server " + server.getName() + " is down, restarting");
                        restartedAndRunningfutures.add(service.submit(() -> server.startServer()));
                    }else{
                        restartedAndRunningfutures.add(future);
                    }

                }

                futures.clear();

                futures.addAll(restartedAndRunningfutures);

                System.out.println("Sleeping 1 second");
                Util.wait(1000);

            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }finally{
            for (Future<Server> future : futures) {
                future.cancel(false);
            }
        }

        service.shutdown();
        System.out.println( "Done...");

    }
}

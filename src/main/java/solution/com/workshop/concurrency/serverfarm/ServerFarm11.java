package solution.com.workshop.concurrency.serverfarm;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class ServerFarm11 {

    public static void main(String[] args) {

        Callable<Server> callable1 = () -> new Server("Apache1" ).startServer();
        Callable<Server> callable2 = () -> new Server("Apache2" ).startServer();
        Callable<Server> callable3 = () -> new Server("Apache3" ).startServer();

        ExecutorService service = Executors.newFixedThreadPool(3);

        List<Future<Server>> futures = new ArrayList<>();
        futures.add( service.submit(callable1));
        futures.add( service.submit(callable2));
        futures.add( service.submit(callable3));

        try {

            for( Future<Server> future: futures) {
                Server server = future.get();
                System.out.println("Server " + server.getName() + " is down");
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println( "Done...");
        service.shutdown();
    }
}

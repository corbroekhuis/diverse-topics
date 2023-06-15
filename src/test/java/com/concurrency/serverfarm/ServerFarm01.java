package com.concurrency.serverfarm;

import java.util.concurrent.*;

public class ServerFarm01 {

    public static void main(String[] args) {

        ExecutorService service = Executors.newSingleThreadExecutor();

        Callable<Server> callable = () -> new Server("Apache01").startServer();

        Future<Server> future = service.submit(callable);

        try {
            Server server = future.get();
            System.out.println("Server " + server.getName() + " is unstable");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        System.out.println( "Done...");
        service.shutdown();
        
    }
}

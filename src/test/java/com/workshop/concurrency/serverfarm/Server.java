package com.workshop.concurrency.serverfarm;

import java.util.concurrent.ThreadLocalRandom;

public class Server {

    private String name;

    public String getName(){
        return name;
    }

    public Server( String name){
        this.name = name;
    }

    public Server startServer() {

        System.out.println("    Server " + name + " is starting");
        
        // Generate random integers in range 1500 to 3500
        int stable = ThreadLocalRandom.current().nextInt(1500, 3500);

        while (true) {
            try {
                Thread.sleep(stable);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            return this;

        }
        
    }
    
}

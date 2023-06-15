package com.concurrency.runnablewithcallback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import com.concurrency.util.Util;

// Do the same as in 'Application.java'
public class RunnableWithCallback {

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute( new Task("Task1", 3000));
        service.execute( new Task("Task2", 2500));
        service.execute( new Task("Task3", 2000));

        service.shutdown();
        System.out.println( "Orderly shutdown requested");

        while( !service.isTerminated()){
            Util.sleep(100);
        }

    }

    public static void main(String[] args) {

        System.out.println( "Start");
        new RunnableWithCallback().run();

        System.out.println( "Done...");

    }

}

class Task implements Runnable{

    private int runningTime;
    private String taskName;
    // Add a field for the callback reference, don't forget to modify the constructor

    public Task(String taskName, int runningTime){
        this.runningTime = runningTime;
        this.taskName = taskName;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(runningTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        // call callback with appropriate message

    }

}

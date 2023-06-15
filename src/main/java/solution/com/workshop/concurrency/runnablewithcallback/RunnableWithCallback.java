package solution.com.workshop.concurrency.runnablewithcallback;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import solution.com.workshop.concurrency.callback.Callback;
import solution.com.workshop.concurrency.util.Util;

public class RunnableWithCallback implements Callback {

    @Override
    public void whenDone( String message) {
        System.out.println( "Callback reports: " + message);
    }

    private void run(){

        ExecutorService service = Executors.newSingleThreadExecutor();

        service.execute( new Task("Task1", this, 3000));
        service.execute( new Task("Task2", this, 2500));
        service.execute( new Task("Task3", this, 2000));

        service.shutdown();
        System.out.println( "Orderly shutdown requested");

        while( !service.isTerminated()){
            Util.wait(100);
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
    private RunnableWithCallback runnableWithCallback;

    public Task(String taskName, RunnableWithCallback runnableWithCallback, int runningTime){
        this.runningTime = runningTime;
        this.taskName = taskName;
        this.runnableWithCallback = runnableWithCallback;
    }

    @Override
    public void run() {

        try {
            Thread.sleep(runningTime);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        runnableWithCallback.whenDone( "Task: " + taskName + " is ready");


    }

}

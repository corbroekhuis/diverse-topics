package solution.com.workshop.concurrency.withException;

import solution.com.workshop.concurrency.util.Util;

public class RunnableTask implements Runnable{

    private int runningTime;
    private String taskName;

    public RunnableTask(String taskName, int runningTime){
        this.runningTime = runningTime;
        this.taskName = taskName;
    }

    @Override
    public void run() {

    	Util.wait(runningTime);
        System.out.println( "Task: " + taskName + " is throwing Exception");
        String[] array = {"Ohoh..."};
        System.out.println( array[3]);
 //       throw new Exception("Checked exception");

    }

}

package com.concurrency.withException;

import com.concurrency.util.Util;

public class RunnableTask implements Runnable{

    private int runningTime;
    private String taskName;

    public RunnableTask(String taskName, int runningTime){
        this.runningTime = runningTime;
        this.taskName = taskName;
    }

    @Override
    public void run() {

    	Util.sleep(runningTime);
        System.out.println( "Task: " + taskName + " is throwing Exception");
        String[] array = {"Ohoh..."};
        System.out.println( array[3]);
 //       throw new Exception("Checked exception");

    }

}

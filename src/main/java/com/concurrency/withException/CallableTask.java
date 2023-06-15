package com.concurrency.withException;

import com.concurrency.util.Util;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String>{

    private int runningTime;
    private String taskName;

    public CallableTask(String taskName, int runningTime){
        this.runningTime = runningTime;
        this.taskName = taskName;
    }

    @Override
    public String call() {

        Util.sleep(runningTime);
        System.out.println( "Task: " + taskName + " is throwing Exception");
        String[] array = {"Ohoh..."};
        System.out.println( array[3]);
 //       throw new Exception("Checked exception");
        
        return "You will never see this";

    }

}


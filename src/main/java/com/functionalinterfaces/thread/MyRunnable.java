package com.functionalinterfaces.thread;

public class MyRunnable implements Runnable{

    String name;

    // This member serves as a 'link' to the calling application to
    // be able to call a 'callback' method in the application
    ThreadApplication threadApplication;

    public MyRunnable( String name, ThreadApplication threadApplication){
        this.name = name;
        this.threadApplication = threadApplication;
    }

    @Override
    public void run() {

        System.out.println( "Inside MyRunnable: " + name);
        try {
            Thread.sleep(10_000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadApplication.callBack("I am done");  // call the callback method in the application

    }
}

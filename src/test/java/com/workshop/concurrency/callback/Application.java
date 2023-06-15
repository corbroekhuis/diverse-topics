package com.workshop.concurrency.callback;

// 1   implement the given com.workshop.concurrency.callback interface
public class Application{

    public static void main(String[] args) {

        new Application().run();

    }

    private void run() {

    	// 3   Create a Handler instance, using the constuctor to register the application instance with the Handler
    	// 5   post the runnable to the handler instance
    	// 6   run the runnable in the handler  
    	
    	Runnable runnable = () -> System.out.println("Doing work");
    	
    }

    // 2    add the implementation of the callback method

}

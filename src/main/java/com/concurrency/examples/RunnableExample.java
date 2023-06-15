package com.concurrency.examples;

public class RunnableExample {

    public static void main(String[] args) {

        Runnable runnable;

        // Is nor a generic interface
        // Has no return value
        // Cannot throw an exception

        runnable = () -> someMethod();

        runnable.run();



    }

    private static void someMethod() {
        // Do something and print the result
        // ......
        System.out.println("Running 'someMethod'");
    }
}

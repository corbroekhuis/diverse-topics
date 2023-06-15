package com.concurrency.examples;

import java.util.concurrent.Callable;

public class CallableExample {

    public static void main(String[] args) throws Exception {

        Callable callable;

        // Is a generic interface
        // Has a return value
        // May throw an exception
        Callable<Integer> intCallable = () -> 5;

        int result = intCallable.call();
        System.out.println(result);

        Callable<String> stringCallable = () -> someMethod();

        intCallable = () -> {throw new Exception("Unable to process....");};

        intCallable.call();

    }

    private static String someMethod() {
        return "Hello";
    }

    private static boolean search( final String file) throws Exception {

        Callable<Boolean> searchStringInFile =  () -> findString("", file) ;

        Boolean found = searchStringInFile.call();

        return found;
    }

    private static Boolean findString(String s, String file) {


        return true;
    }

}

package com.concurrency.util;

public class Util {

   public static void wait( int msecs){

       try {
           Thread.currentThread().sleep(msecs);
       } catch (InterruptedException e) {
           System.out.println("I probably got interrupted by an executor");
       }

   }

}

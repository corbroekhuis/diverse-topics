package com.concurrency.util;

public class Util {

    public static void sleep(long millis) {
        try {
            Thread.sleep( millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

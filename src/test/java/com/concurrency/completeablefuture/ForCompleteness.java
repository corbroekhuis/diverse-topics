package com.concurrency.completeablefuture;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ForCompleteness {

    public static void main(String[] args) {

        // Aggregate
        CompletableFuture<String> completableFuture =
                CompletableFuture
                    .supplyAsync(() -> "Hello")
                    .thenApply(s -> s + " World")
                    ;

        try {

            String result = completableFuture.get();
            System.out.println(result);


        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }
}

package com.functionalinterfaces.consumer;

import com.functionalinterfaces.lamp.Lamp;

import java.util.function.Consumer;

public class ConsumerExample {

    Consumer consumer;

    private static <T> void doSomethingWithConsumer( T t, Consumer<T> consumer){
        consumer.accept(t);
    }

    public static void main(String[] args) {

        Consumer<String> consumer = (a) ->  System.out.println(a);

        doSomethingWithConsumer( "Hello", consumer);

        Consumer<Lamp> lampConsumer = l -> {
            System.out.println(l.toString());
            l.toggle();
            System.out.println(l.toString());
        };

        doSomethingWithConsumer( new Lamp(), lampConsumer);

    }
}

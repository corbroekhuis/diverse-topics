package com.functionalinterfaces.biconsumer;

import com.functionalinterfaces.lamp.Lamp;

import java.util.function.BiConsumer;

public class BiConsumerExample {

    BiConsumer biConsumer;   // Here, just to inspect this Functional Interface (select type and ctrl+B)

    private static <T,U> void doSomethingWithBiConsumer( T t, U u, BiConsumer<T,U> biConsumer){
        biConsumer.accept(t, u);
    }

    public static void main(String[] args) {

        BiConsumer<String, Lamp> biConsumer = (a, b) ->  System.out.println(a + b.toString());

        doSomethingWithBiConsumer( "Checking if lamp is on:\n ", new Lamp(), biConsumer);

        BiConsumer<String,Lamp> lampBiConsumer = (s,l) -> {
            System.out.println(s);
            System.out.println(l.toString());
            l.toggle();
            System.out.println(l.toString());
        };

        doSomethingWithBiConsumer( "Switching lamp:", new Lamp(), lampBiConsumer);

    }
}

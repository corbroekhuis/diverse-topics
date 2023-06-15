package com.functionalinterfaces.lamp;

@FunctionalInterface
public interface Switcher <T>{

    public T apply(T t);

}

package com.streams.assignment1;

import java.util.Comparator;
import java.util.Optional;
import java.util.stream.Stream;

public class Assignment1 {

    public static void main(String[] args) {

        Stream<Integer> stream = Stream.of(1,2,3,4,9,5,6,7,8);

        // 1 Print each number in the stream
        // 2 Print all the squares of the elements in the stream
        // 3 Print all elements > 5 (use filter method)
        // 4 Add 10 to every element and print the result
        // 5 Create a List of Integers from the stream (Use the collect method)
        // 6 Use the map method to transform the stream to a stream of Strings and print them
        // 7 print the maximum number in the stream

        Comparator c;
        Optional<Integer> max = stream.max( (x, y) -> x < y ? -1: 1);
        max.isEmpty();
        System.out.println("Max: " + max.get());
        int maxInt = stream.max( Integer::compare).orElse(-1);

    }
}

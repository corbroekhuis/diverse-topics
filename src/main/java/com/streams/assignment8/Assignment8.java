package com.streams.assignment8;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.stream.Stream;

public class Assignment8 {

    public static void main(String[] args) throws IOException {

        // Create a stream of lines from file
        Stream<String> lines = Files.lines( Paths.get("src/main/resources/data.txt"));

        //  1
        //  Use method map to map each line to an array of Strings
        //  (this creates a stream of arrays)
        //  Use the filter method to get a stream of arrays of length 3
        //  Use the filter method to to get a stream of arrays with first item > 15
        //  print contents of every array in the resulting stream

        String[] y = "1,3,6,8".split(",");
        y[0] = "6";

     Stream<String[]> array = lines.map( (x) -> x.split(","));
        array.filter( (x) -> x.length == 3)
        .forEach(     (x) -> System.out.println(x[0]));


        lines = Files.lines( Paths.get("src/main/resources/data.txt"));
        lines
                .map(Arrays::asList)
                .forEach(System.out::println);


        System.out.println("-----------------------------------");
        lines = Files.lines( Paths.get("src/main/resources/data.txt"));
        lines.flatMap( (x) ->  Arrays.stream(  x.split(",")))
        .forEach(System.out::print);

        //  2
        //  Use method map to map each line to an array of Strings
        //  Use the flatMap method to create a stream of Integers from the stream of arrays


    }
}

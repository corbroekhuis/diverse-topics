package com.streams.assignment2;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

public class Assignment2 {

    public static void main(String[] args) {

        System.out.println( getEncodedString("Muslum"));

        List<String> memberNames = new ArrayList<>();

        memberNames.add("Ozlem");
        memberNames.add("Mila");
        memberNames.add("Muslum");
        memberNames.add("Halit");
        memberNames.add("Ahmet");
        memberNames.add("Halid Enes");
        memberNames.add("Nurullah");
        memberNames.add("Jacky");

        // 1 Print all names that start with an 'A' or 'J'
        // 2 Print the names + sizes of the names
        // 3 print all names converted to uppercase
        // 4 count all names in the stream
        // 5 Find the first name that starts with an 'H'
        // 6 Print the names, sorted alphabetically
        // 7 Print all Base64 Encoded names using (see below) method getEncodedString
        memberNames.stream()
                .sorted()
                .forEach(System.out::println);

       // memberNames.sort();





    }

    private static String getEncodedString( String plainText){

        byte[] encodedBytes = Base64.getEncoder().encode(plainText.getBytes());
        return( new String(encodedBytes));

    }

}

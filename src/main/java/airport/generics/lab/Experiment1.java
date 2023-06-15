package airport.generics.lab;

import java.util.*;

public class Experiment1 {

    public static void main(String[] args) {


        List<String> strings = new ArrayList<>();
        strings.add("");
        String str = strings.get(0);

        for( String s: strings){
            // do something
        }

        Map<String, Integer> map = new HashMap<>();
        map.put("first", Integer.parseInt("123445"));
        Integer i = map.get("first");

        for( String key: map.keySet()){
            Integer i2 = map.get(key);
        }

        Collection<Integer> values = map.values();
        for( Integer i3: values){
            // do something
        }




    }
}

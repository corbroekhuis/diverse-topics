package airport.generics.aircraft;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Airport <T extends Airplane>{

    private String name;
    private List<T> airplanes = new ArrayList<>();
    private Map<String, T> airplanesMap = new HashMap<>();

    public void addAirplane(T t) {
        airplanes.add(t);
    }

    public void addAirplaneToMap(T t) {
        airplanesMap.put(t.getPlaneIdentification(), t);
    }

    public void printAirplanes() {
    }

    public void load(String planeIdentification, int load) {

        T t = getAirplane( planeIdentification);

        System.out.print("(Using list) Attempting to load plane: " + planeIdentification + " " + t.toString());

        if( t == null){
            System.out.println( " ERROR:  no such plane!");
            return;
        }

        t.load(load);
        System.out.println( " OK: " + load + " loaded!");

    }
    public void loadByMap(String planeIdentification, int load) {

        T t = airplanesMap.get( planeIdentification);

        System.out.print("(Using map) Attempting to load plane: " + planeIdentification);

        if( t == null){
            System.out.println( " ERROR:  no such plane!");
            return;
        }

        t.load(load);
        System.out.println( " OK: " + load + " loaded!");

    }

    public void loadCargoInPlane(String planeIdentification, int i) {

    }

    private T getAirplane( String planeIdentification){

        for (T t: airplanes){

            if( t.getPlaneIdentification().equals(planeIdentification)){
                return t;
            }

        }

        return null;

    }

}

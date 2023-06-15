package ocp.generics.beverage;


import ocp.generics.beverage.Beverage;

import java.util.ArrayList;
import java.util.List;


public class GenericBox<E extends Beverage> {

    private List<E> content = new ArrayList<>();

    public void add(E e) {
        this.content.add(e);

        System.out.println("Added a beverage with alc. "+e.getAlcoholPercentage());
    }

    public E getElementAtIndex(int index) {
        return this.content.get(index);
    }

    public void showContents(){
        for( E e: content){
            System.out.println(e.toString() );
        }
    }

}

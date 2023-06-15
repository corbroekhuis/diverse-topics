package ocp.generics.beverage;


import java.util.ArrayList;
import java.util.List;


public class Box {

    private List<Wine> content = new ArrayList<>();

    public void add(Wine wine) {
        this.content.add(wine);

        System.out.println("Added a beverage with alc. "+wine.getAlcoholPercentage());
    }

    public Wine getElementAtIndex(int index) {
        return this.content.get(index);
    }

    public void showContents(){
        for( Wine wine: content){
            System.out.println(wine.toString());
        }
    }
}

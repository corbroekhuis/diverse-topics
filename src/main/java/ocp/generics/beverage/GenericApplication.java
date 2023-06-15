package ocp.generics.beverage;

public class GenericApplication {

    public static void main(String[] args) {

        GenericBox<Wine> box1 = new GenericBox<>();
        box1.add( new Wine("Chateau Laffite", 13.6));

        GenericBox<Beer> box2 = new GenericBox<>();
        box2.add( new Beer("Heineken", 7.8));

        GenericBox<Beverage> box3 = new GenericBox<>();
        box3.add( new Beer( "Mythos", 4.5));
        box3.add( new Wine("Chateau Margeaux", 14.1));

        box1.showContents();
        box2.showContents();
        box3.showContents();

        Wine wine1 = box1.getElementAtIndex(0);
        wine1.invisibleMethod();

        Beverage beverage1 = box3.getElementAtIndex(1);
        // beverage1.invisibleMethod();  ???????
        Wine wine2 = (Wine)beverage1;
        wine2.invisibleMethod();



    }
}

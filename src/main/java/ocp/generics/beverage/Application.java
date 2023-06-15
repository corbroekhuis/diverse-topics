package ocp.generics.beverage;

public class Application {

    public static void main(String[] args) {

        Box box = new Box();
        box.add(new Wine("Chateau Margaux", 14.1));

        box.showContents();

        // Make Box a generic class so that you can add beers OR Wines:
        // i.e.
        // Box<Beer> beerBox = new Box<>();
        // beerBox.add( new Beer(....));
        // add multiple beers
        // Do the same for Wines


        // Also try
        // Box<Beverage> beverageBox = new Box<>();
        // and add beers AND wines in the same box


    }
}

package ocp.generics.beverage;

public class Beer extends Beverage{

    private String brewery;

    public Beer( String brewery, double alcoholPercentage){
        super(alcoholPercentage);
        this.brewery = brewery;
    }
    public String getBrewery() {
        return brewery;
    }

    public void setBrewery(String brewery) {
        this.brewery = brewery;
    }

    @Override
    public String toString() {
        return "I am a beer with alcoholpercentage "
                + alcoholPercentage + " and was brewed by " + brewery;
    }
}


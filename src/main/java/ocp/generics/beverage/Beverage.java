package ocp.generics.beverage;

public class Beverage {

    double alcoholPercentage;

    public Beverage() {
    }

    public Beverage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

    public double getAlcoholPercentage() {
        return alcoholPercentage;
    }

    public void setAlcoholPercentage(double alcoholPercentage) {
        this.alcoholPercentage = alcoholPercentage;
    }

}

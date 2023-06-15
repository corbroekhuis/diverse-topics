package ocp.generics.beverage;

public class Wine extends Beverage{

    private String chateau;

    public Wine( String chateau, double alcoholPercentage){
        super(alcoholPercentage);
        this.chateau = chateau;
    }

    public String getChateau() {
        return chateau;
    }

    public void setChateau(String chateau) {
        this.chateau = chateau;
    }

    @Override
    public String toString() {
        return "I am a wine with alcoholpercentage "
                + alcoholPercentage + " and was bottled in " + chateau;
    }

    public void invisibleMethod(){

    }

}

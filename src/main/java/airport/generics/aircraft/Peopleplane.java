package airport.generics.aircraft;

public final class Peopleplane extends Airplane {

    private int maxPassengersLoad;
    private int currentPassengersLoad;

    public Peopleplane(String plainIdentification, int maxPassengersLoad) {
        super(plainIdentification);
        this.maxPassengersLoad = maxPassengersLoad;
    }

    @Override
    public void load(int load){
        this.currentPassengersLoad = this.currentPassengersLoad + load;
    }

    @Override
    public void disCharge( int load){
        this.currentPassengersLoad = 0;
    }

    @Override
    public String toString(){
        return "Peopleplane";
    }
}

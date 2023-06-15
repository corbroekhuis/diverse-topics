package airport.generics.aircraft;

public final class Cargoplane extends Airplane {

    private int maxCargoLoad;
    private int currentCargoLoad;

    public Cargoplane(String plainIdentification, int maxCargoLoad) {
        super(plainIdentification);
        this.maxCargoLoad = maxCargoLoad;
    }

    @Override
    public void load(int load){
        this.currentCargoLoad = this.currentCargoLoad + load;
    }

    @Override
    public void disCharge( int load){
        this.currentCargoLoad = 0;
    }

    @Override
    public String toString(){
        return "Cargoplane";
    }
}

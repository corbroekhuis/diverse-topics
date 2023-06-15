package airport.generics.aircraft;

public abstract class Airplane {

    private String planeIdentification;

    public Airplane() {
    }

    public Airplane(String planeIdentification) {
        this.planeIdentification = planeIdentification;
    }

    abstract void load( int load);
    abstract void disCharge( int load);

    public void takeOff() {
        System.out.println("Airplane taking off");
    }

    public void land() {
        System.out.println("Airplane landing");
    }

    public String getPlaneIdentification() {
        return planeIdentification;
    }

}



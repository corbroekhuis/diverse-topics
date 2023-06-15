package airport.generics.aircraft;

public class Application {

    public static void main(String[] args) {

        Airport airport=new Airport();

        airport.addAirplane( new Peopleplane("GD253", 340));
        airport.addAirplane( new Peopleplane("XJ530", 340));
        airport.addAirplane( new Peopleplane("JD925", 340));
        airport.addAirplane( new Peopleplane("BO400", 340));
        airport.addAirplane( new Cargoplane("XX492", 340000));
        airport.addAirplane( new Cargoplane("GA953", 340000));
        airport.addAirplane( new Cargoplane("DX656", 340000));


        airport.addAirplaneToMap( new Peopleplane("GD253", 340));
        airport.addAirplaneToMap( new Peopleplane("XJ530", 340));
        airport.addAirplaneToMap( new Peopleplane("JD925", 340));
        airport.addAirplaneToMap( new Peopleplane("BO400", 340));
        airport.addAirplaneToMap( new Cargoplane("XX492", 340000));
        airport.addAirplaneToMap( new Cargoplane("GA953", 340000));
        airport.addAirplaneToMap( new Cargoplane("DX656", 340000));


        airport.printAirplanes();
        airport.load("GD253",100);
        airport.load("GD253",100);
        airport.load("GD253",100);
        airport.load("DX656",28);
        airport.load("DX656",40000);
        airport.load("DX656",40);

     //   airport.loadC("GD253",100);



    }

}

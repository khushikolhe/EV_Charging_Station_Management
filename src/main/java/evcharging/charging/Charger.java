package evcharging.charging;

abstract class Charger {
    abstract String chargerID;
    abstract double power;
    abstract boolean availablility;

    public void displayCharger()
    {
        System.out.println("---Charging Information---");
        System.out.println("Charger ID: "+chargerID);
        System.out.println("Charging power: "+power+"kWh");
        System.out.println("Charger availability: "+availablility);
    }

}

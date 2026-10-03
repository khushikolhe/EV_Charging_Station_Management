package evcharging.charging;

abstract class Charger {
    public abstract String chargerID;
    public abstract double power;
    public abstract boolean availablility;

    public void displayCharger()
    {
        System.out.println("---Charging Information---");
        System.out.println("Charger ID: "+chargerID);
        System.out.println("Charging power: "+power+"kWh");
        System.out.println("Charger availability: "+availablility);
    }

}

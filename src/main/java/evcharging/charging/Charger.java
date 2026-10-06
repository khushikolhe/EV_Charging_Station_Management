package evcharging.charging;

public abstract class Charger  {
    private String chargerID;
    private double power;
    private boolean availablility;

    public Charger(String chargerID, double power, boolean availablility) {
        this.chargerID = chargerID;
        this.power = power;
        this.availablility = availablility;
    }

    public void displayCharger()
    {
        System.out.println("---Charging Information---");
        System.out.println("Charger ID             : "+chargerID);
        System.out.println("Charging power         : "+power+" kW");
        System.out.println("Charger availability   : "+availablility);
    }

}

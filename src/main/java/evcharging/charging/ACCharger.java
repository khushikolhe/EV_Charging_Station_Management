package evcharging.charging;

public class ACCharger extends Charger {
    private int chargingphase;

    public int getChargingphase() {
        return chargingphase;
    }

     public ACCharger() {
        super("AC385", 7.2, true);
        chargingphase = 3;
    }

    public void displayCharger()  {
        super.displayCharger();
        System.out.println("This is an AC charger");
        System.out.println("Charging Phase: " + chargingphase);
    }
}
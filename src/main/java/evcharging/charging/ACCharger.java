package evcharging.charging;

public class ACCharger extends Charger {
    private int chargingphase;

    public int getChargingphase() {
        return chargingphase;
    }

    ACCharger() {
    }

    public void displayCharger()  {
        super.displayCharger();
        System.out.println("This is an AC charger");
        System.out.println("Charging Phase: " + chargingphase);
    }
}
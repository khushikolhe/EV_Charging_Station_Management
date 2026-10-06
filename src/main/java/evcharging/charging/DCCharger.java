package evcharging.charging;

public class DCCharger extends Charger {
    private float maxVoltage;

    public float getMaxVoltage() {
        return maxVoltage;
    }

    public DCCharger() {
        super("DC275", 60.0, true);
        maxVoltage = 400;
    }

    public void displayCharger()  {
        super.displayCharger();
        System.out.println("This is a DC charger");
        System.out.println("Maximum voltage: " + maxVoltage);
    }
}

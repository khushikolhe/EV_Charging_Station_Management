package evcharging.billing;

public class Bill{

    private int BillId;
    private double EnergyConsumed;
    private double RatePerUnit;
    private double TotalAmount;

    public Bill(int billId, double energyConsumed, double ratePerUnit) {
        this.BillId = billId;
        this.EnergyConsumed = energyConsumed;
        this.RatePerUnit = ratePerUnit;
        this.TotalAmount = 0;
    }

    public void CalculateBill() {
        TotalAmount = EnergyConsumed * RatePerUnit;
    }

    public void DisplayBill() {
        System.out.println("----- EV Charging Bill -----");
        System.out.println("Bill ID: " + BillId);
        System.out.println("Energy Consumed: " + EnergyConsumed + " KWh");
        System.out.println("Rate per Unit: ₹" + RatePerUnit);
        System.out.println("Total Amount: ₹" + TotalAmount);

    }

    public double getTotalAmount() {
        return TotalAmount;
    }
}

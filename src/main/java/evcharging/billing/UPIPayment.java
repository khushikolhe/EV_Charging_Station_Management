package evcharging.billing;

public class UPIPayment implements PaymentMethod{

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " made through UPI.");
    }

    @Override
    public void DisplayPaymentMethod() {
        System.out.println("Payment Method: UPI");
    }
}

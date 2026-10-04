package evcharging.billing;

public class CardPayment implements PaymentMethod {

    @Override
    public void pay(double amount) {
        System.out.println("Payment of ₹" + amount + " made through Card.");
    }

    @Override
    public void DisplayPaymentMethod() {
        System.out.println("Payment Method: Card");
    }
}

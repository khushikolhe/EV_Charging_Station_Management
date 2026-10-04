package evcharging.billing;

public interface PaymentMethod{
    void pay(double amount);
    void DisplayPaymentMethod();
}

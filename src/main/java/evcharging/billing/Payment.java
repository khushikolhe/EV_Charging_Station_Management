package evcharging.billing;

public class Payment{

    private int PaymentId;
    private double Amount;
    private PaymentMethod paymentMethod;
    private String PaymentStatus;

    public Payment(int paymentId, double amount, PaymentMethod paymentMethod) {
        this.PaymentId = paymentId;
        this.Amount = amount;
        this.paymentMethod = paymentMethod;
        this.PaymentStatus = "Pending";
    }

    public void makePayment() {
        paymentMethod.pay(Amount);
        PaymentStatus = "Successful";
    }

    public void displayPayment() {
        System.out.println("----- Payment Details -----");
        System.out.println("Payment ID: " + PaymentId);
        System.out.println("Amount: ₹" + Amount);
        paymentMethod.DisplayPaymentMethod();
        System.out.println("Payment Status: " + PaymentStatus);
    }

    public int getPaymentId() {
        return PaymentId;
    }

    public double getAmount() {
        return Amount;
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }
}

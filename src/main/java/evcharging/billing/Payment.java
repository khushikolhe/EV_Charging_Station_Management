package evcharging.billing;

public class Payment{

    private int PaymentId;
    private double Amount;
    private String PaymentMethod;
    private String PaymentStatus;

    public Payment(int paymentId, double amount, String paymentMethod) {
        this.PaymentId = paymentId;
        this.Amount = amount;
        this.PaymentMethod = paymentMethod;
        this.PaymentStatus = "Pending";
    }

    public void makePayment() {
        PaymentStatus = "Successful";
    }

    public void displayPayment() {
        System.out.println("----- Payment Details -----");
        System.out.println("Payment ID: " + PaymentId);
        System.out.println("Amount: ₹" + Amount);
        System.out.println("Payment Method: " + PaymentMethod);
        System.out.println("Payment Status: " + PaymentStatus);
    }

    public String getPaymentStatus() {
        return PaymentStatus;
    }
}

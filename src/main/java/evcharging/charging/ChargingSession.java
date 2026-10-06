package evcharging.charging;

import evcharging.customer.Customer;
import evcharging.customer.Vehicle;
import evcharging.thread.ChargingRunnable;
import evcharging.billing.Bill;
import evcharging.billing.Payment;
import evcharging.billing.PaymentMethod;
import evcharging.billing.UPIPayment;
import evcharging.billing.CardPayment;

class ChargingException extends Exception {
    public ChargingException(String message){
        super(message);
    }
}

public class ChargingSession {
    private int SessionID;
    private Customer customer;
    private Vehicle vehicle;
    private ChargingStation station;
    private Charger charger;
    private double ChargingDuration;
    private boolean Active;
    private Bill bill;
    private Payment payment;

    public void startCharging() throws ChargingException{
        if(Active) {
            throw new ChargingException("Charging session is already active.");
        }
        Active = true;
        System.out.println("Charging session started.");

        ChargingRunnable task = new ChargingRunnable();
        Thread ChargingThread = new Thread(task);
        ChargingThread.start();

        try {
            ChargingThread.join();
        }
        catch (InterruptedException e) {
            System.out.println("Thread interrupted.");
        }
    }

    public void stopCharging(double duration) throws ChargingException {
            if (!Active) {
                throw new ChargingException("No active charging session.");
            }
            if (duration <= 0) {
                throw new ChargingException("Charging duration must be greater than zero.");
            }

            ChargingDuration = duration;
            Active = false;

            bill = new Bill(SessionID, ChargingDuration * 10, 10, ChargingDuration);
            bill.CalculateBill();
            bill.DisplayBill();

            System.out.println("Charging session stopped.");
            System.out.println("Charging Duration: " + ChargingDuration + " hours");
    }

    public void makePayment(int paymentChoice) throws ChargingException {
        PaymentMethod paymentMethod;
        if (paymentChoice == 1) {
            paymentMethod = new UPIPayment();
        }
        else if (paymentChoice == 2) {
            paymentMethod = new CardPayment();
        }
        else {
            throw new ChargingException("Invalid payment method.");
        }
        payment = new Payment(SessionID, bill.getTotalAmount(), paymentMethod);
        payment.makePayment();
        payment.displayPayment();
    }

    public void displaySession() {
        System.out.println("----- Charging Session -----");
        System.out.println("Session ID: " + SessionID);
        System.out.println("Charging Duration: " + ChargingDuration + " hours");
        System.out.println("Session Active: " + Active);
    }
}
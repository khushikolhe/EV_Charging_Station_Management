package evcharging.charging;

import evcharging.customer.Customer;
import evcharging.customer.Vehicle;
import evcharging.thread.ChargingRunnable;

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

    public void startCharging() throws ChargingException{
        if(Active) {
            throw new ChargingException("Charging session is already active.");
        }
        Active = true;
        System.out.println("Charging session started.");

        ChargingRunnable task = new ChargingRunnable();
        Thread ChargingThread = new Thread(task);
        ChargingThread.start();
    }

    public void stopCharging(double duration) throws ChargingException {
        if (!Active) {
            throw new ChargingException("No active charging session.");
        }
        if(duration<=0){
            throw new ChargingException("Charging duration must be greater than zero.");
        }

        ChargingDuration = duration;
        Active = false;

        System.out.println("Charging session stopped.");
        System.out.println("Charging Duration: " + ChargingDuration + " hours");
    }

    public void displaySession() {
        System.out.println("----- Charging Session -----");
        System.out.println("Session ID: " + SessionID);
        System.out.println("Charging Duration: " + ChargingDuration + " hours");
        System.out.println("Session Active: " + Active);
    }
}
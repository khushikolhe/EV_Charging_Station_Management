package evcharging.main;

import java.util.Scanner;
import evcharging.customer.Customer;
import evcharging.customer.Vehicle;
import evcharging.charging.ChargingStation;
import evcharging.charging.ACCharger;
import evcharging.charging.DCCharger;
import evcharging.charging.ChargingSession;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Customer customer = null;
        Vehicle vehicle = null;
        ChargingStation station = null;
        ChargingSession session = null;
        int choice;
        do {
            System.out.println("\n====== EV CHARGING STATION MANAGEMENT ======");
            System.out.println("1. Register Customer");
            System.out.println("2. Register Vehicle");
            System.out.println("3. View Charging Stations");
            System.out.println("4. Start Charging");
            System.out.println("5. Stop Charging");
            System.out.println("6. Make Payment");
            System.out.println("7. View Charging Session");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.print("Enter Customer Name: ");
                    String name = sc.next();
                    System.out.print("Enter Customer ID: ");
                    String id = sc.next();
                    System.out.print("Enter Phone Number: ");
                    String phone = sc.next();
                    customer = new Customer(name, id, phone);
                    System.out.println("Customer registered successfully.");
                    customer.displayCustomer();
                    break;

                case 2:
                    System.out.print("Enter Vehicle Number: ");
                    String vehicleNumber = sc.next();
                    System.out.print("Enter Vehicle Model: ");
                    String model = sc.next();
                    System.out.print("Enter Battery Capacity: ");
                    String batteryCapacity = sc.next();
                    vehicle = new Vehicle(vehicleNumber, model, batteryCapacity);
                    System.out.println("Vehicle registered successfully.");
                    vehicle.displayVehicleInfo();
                    break;

                case 3:
                    station = new ChargingStation("S101", "Baner Charging Station", "Pune", 2);
                    ACCharger ac = new ACCharger();
                    DCCharger dc = new DCCharger();
                    station.addCharger(ac);
                    station.addCharger(dc);
                    station.display();
                    break;

                case 4:
                    if (customer == null || vehicle == null || station == null) {
                        System.out.println("Please register first.");
                        break;
                    }
                    if(session == null) {
                        session = new ChargingSession();
                    }
                    try {
                        session.startCharging();
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    if (session == null) {
                        System.out.println("No charging session found.");
                        break;
                    }
                    System.out.print("Enter Charging Duration in hrs: ");
                    double duration = sc.nextDouble();
                    try {
                        session.stopCharging(duration);
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.println("Select Payment Method:");
                    System.out.println("1. UPI");
                    System.out.println("2. Card");
                    System.out.print("Enter your choice: ");
                    int paymentChoice = sc.nextInt();
                    try {
                        session.makePayment(paymentChoice);
                    }
                    catch (Exception e) {
                        System.out.println("Error: " + e.getMessage());
                    }


                case 7:
                    if (session == null) {
                        System.out.println("No charging session found.");
                        break;
                    }
                    session.displaySession();
                    break;

                case 8:
                    System.out.println("Exit.");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 8);
        sc.close();
    }
}
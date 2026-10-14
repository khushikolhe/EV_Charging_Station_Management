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
        ChargingStation station1 = null;
        ChargingStation station2 = null;
        ChargingStation station3 = null;
        ChargingSession session = null;
        int choice;
        do {
            System.out.println("\n====== EV CHARGING STATION MANAGEMENT ======");
            System.out.println("1. Register Customer");
            System.out.println("2. Register Vehicle");
            System.out.println("3. View Charging Stations");
            System.out.println("4. Start Charging");
            System.out.println("5. Complete Charging Session & Generate Bill");
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
                    sc.nextLine();
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
                    System.out.println();
                    vehicle.displayVehicleInfo();
                    break;

                case 3:
                    if (station1 == null) {
                        station1 = new ChargingStation("S101", "Baner Charging Station", "Pune", 5);
                        station1.addCharger(new ACCharger());
                        station1.addCharger(new DCCharger());

                        station2 = new ChargingStation("S102", "Wakad Charging Station", "Pune", 5);
                        station2.addCharger(new ACCharger());
                        station2.addCharger(new DCCharger());

                        station3 = new ChargingStation("S103", "Hinjawadi Charging Station", "Pune", 5);
                        station3.addCharger(new ACCharger());
                        station3.addCharger(new DCCharger());
                    }

                    System.out.println("\n--- Available Charging Stations ---");
                    System.out.println("1. Baner Charging Station");
                    System.out.println("2. Wakad Charging Station");
                    System.out.println("3. Hinjawadi Charging Station");
                    System.out.println();
                    System.out.print("Select a station: ");
                    int Choice = sc.nextInt();
                    switch (Choice) {
                        case 1:
                            station = station1;
                            break;

                        case 2:
                            station = station2;
                            break;

                        case 3:
                            station = station3;
                            break;

                        default:
                            System.out.println("Invalid station choice.");
                            break;
                    }
                        System.out.println("Station:");
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
                    System.out.print("Enter charging duration in hours: ");
                    double dur = sc.nextDouble();
                    if (dur <= 0) {
                        System.out.println("Duration must be greater than zero.");
                        break;
                    }
                    try {
                        session.startCharging(dur);
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
                    try {
                        session.stopCharging();
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
                    break;


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
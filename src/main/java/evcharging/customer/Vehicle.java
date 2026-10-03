package evcharging.customer;

public class Vehicle  {
        private String vehicleNumber;
        private String model;
        private String batteryCapacity;
        private String vehicleType;

        public Vehicle(String vehicleNumber, String model, String batteryCapacity,String vehicleType)
        {
            this.vehicleNumber = vehicleNumber;
            this.model = model;
            this.batteryCapacity = batteryCapacity;
            this.vehicleType=vehicleType;
        }

        public void displayUser() {
            System.out.println("----Vehicle Information----");
            System.out.println("Vehicle number: " + vehicleNumber);
            System.out.println("Model of the vehicle: " + model);
            System.out.println("Battery capacity: " + batteryCapacity);
            System.out.println("Type of vehicle: " + vehicleType);
        }

        public String getVehicleNumber() {
            return vehicleNumber;
        }
        public String getModel() {return model;}
        public String getBatteryCapacity() {
            return batteryCapacity;
        }
        public String getVehicleType() {
        return vehicleType;
    }
}

package evcharging.customer;

public class Vehicle  {
        private String VehicleNumber;
        private String Model;
        private String BatteryCapacity;
        private String VehicleType;

        public Vehicle(String vehicleNumber, String model, String batteryCapacity,String vehicleType)
        {
            this.VehicleNumber = vehicleNumber;
            this.Model = model;
            this.BatteryCapacity = batteryCapacity;
            this.VehicleType=vehicleType;
        }

        public void displayUser() {
            System.out.println("----Vehicle Information----");
            System.out.println("Vehicle number: " + VehicleNumber);
            System.out.println("Model of the vehicle: " + Model);
            System.out.println("Battery capacity: " + BatteryCapacity);
            System.out.println("Type of vehicle: " + VehicleType);
        }

        public String getVehicleNumber() {return VehicleNumber;}
        public String getModel() {return Model;}
        public String getBatteryCapacity() {
            return BatteryCapacity;
        }
        public String getVehicleType() {
        return VehicleType;
    }
}

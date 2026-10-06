package evcharging.customer;

public class Vehicle  {
        private String VehicleNumber;
        private String Model;
        private String BatteryCapacity;

        public Vehicle(String vehicleNumber, String model, String batteryCapacity)
        {
            this.VehicleNumber = vehicleNumber;
            this.Model = model;
            this.BatteryCapacity = batteryCapacity;
        }

        public void displayVehicleInfo() {
            System.out.println("----Vehicle Information----");
            System.out.println("Vehicle number: " + VehicleNumber);
            System.out.println("Model of the vehicle: " + Model);
            System.out.println("Battery capacity: " + BatteryCapacity);
        }

        public String getVehicleNumber() {return VehicleNumber;}
        public String getModel() {return Model;}
        public String getBatteryCapacity() {
            return BatteryCapacity;
        }
}

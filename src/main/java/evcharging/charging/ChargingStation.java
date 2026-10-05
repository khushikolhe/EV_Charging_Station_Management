package evcharging.charging;

public class ChargingStation {
    private String stationID;
    private String stationName;
    private String location;
    private Charger[] chargers;

    public Charger[] getChargers() {
        return chargers;
    }

    public String getLocation() {
        return location;
    }

    public String getStationName() {
        return stationName;
    }

    public String getStationID() {
        return stationID;
    }

    public void addCharger(Charger charger) {
        for(int i=0;i<chargers.length;i++) {
            if(chargers[i]==null){
                chargers[i]=charger;
                System.out.println("Charger added successfully!");
                break;
            }
        }
        System.out.println("No more chargers can be added.");
    }
    public void display()
    {
        System.out.println("---Charging Station Information---");
        System.out.println("Station ID: "+stationID);
        System.out.println("Station name: "+stationName);
        System.out.println("Location: "+location);
        System.out.println("Chargers: ");
        for(int i=0;i< chargers.length;i++){
            if(chargers[i]!=null){
                chargers[i].displayCharger();
            }
        }
    }

}

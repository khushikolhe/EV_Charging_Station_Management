package evcharging.customer;

public class Customer {
    private String username;
    private String ID;
    private String phonenumber;


    public Customer(String username, String ID, String phonenumber) {
        this.username = username;
        this.ID = ID;
        this.phonenumber = phonenumber;
    }

    public void displayUser() {
        System.out.println("----User Information----");
        System.out.println("User name: " + username);
        System.out.println("User ID: " + ID);
        System.out.println("Phone number: " + phonenumber);
    }

    public String getusername() {
        return username;
    }
    public String getID() {return ID;}
    public String getphonenumber() {
        return phonenumber;
    }
}
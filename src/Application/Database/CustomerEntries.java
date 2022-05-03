package Application.Database;

public class CustomerEntries
{
    private int customerID;
    private String name;
    private String address;
    private int PhoneNo;
    private int NumberOfRentals;

    public CustomerEntries(int customerID, String name, String address, int PhoneNo, int NumberOfRentals){
        this.customerID = customerID;
        this.name = name;
        this.address = address;
        this.PhoneNo = PhoneNo;
        this.NumberOfRentals = NumberOfRentals;
    }

    public void printCustomerEntries(){
        System.out.println("The Customer ID is " + this.customerID);
        System.out.println("The Customer name is " + this.name);
        System.out.println("The Customer address is " + this.address);
        System.out.println("The Customer Phone Number is " + this.PhoneNo);
        System.out.println("The Customer amount of Rentals is " + this.NumberOfRentals);
    }

}

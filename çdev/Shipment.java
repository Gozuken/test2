
import java.util.Scanner;

public class Shipment {
    private String name;
    private String address;
    private String phone;

    public void collectShipmentDetails(Scanner scanner) 
    {
        System.out.println("===================================");
        System.out.print("Enter your name and surname : ");
        name = scanner.nextLine();
        System.out.print("Enter your address : ");
        address = scanner.nextLine();
        System.out.print("Enter your phone number : ");
        phone = scanner.nextLine();
    }

    public void printShipmentDetails() 
    {
        System.out.println("===================================");
        System.out.println("Shipment Details");
        System.out.println("----------------");
        System.out.println("Name : " + name);
        System.out.println("Address : " + address);
        System.out.println("Phone : " + phone);
        System.out.println("===================================");
        System.out.println("Your order has been successfully placed! Thank you for choosing us.");
    }
}

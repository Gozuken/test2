
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //
        final Product[] products = {
            new Product("T-Shirt", 150, 10, 1),
            new Product("Blue Jeans", 299.99f, 5, 2),
            new Product("Running Shoes", 499.99f, 8, 3),
            new Product("Digital Watch", 899.99f, 0, 4),
            new Product("Laptop Backpack", 249.99f, 15, 5)
        };
        Basket basket = new Basket();
        CreditCardPayment creditCardPayment = new CreditCardPayment();
        PayPalPayment payPalPayment = new PayPalPayment();
        Shipment shipment = new Shipment();
        int choice;

        System.out.println("Welcome to our shop!");
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("===================================");
            System.out.println("Menu:");
            System.out.println("1. View Products");
            System.out.println("2. Add Product to Basket");
            System.out.println("3. View Basket");
            System.out.println("4. Checkout");
            System.out.println("5. Exit");
            System.out.println("===================================");
            System.out.print("Choose an option: ");
            
        
            
            try {
                choice = scanner.nextInt();
        
                if (choice < 1 || choice > 5) 
                {
                    System.out.println("===================================");
                    System.out.println("$: Please enter a number between 1 and 5");
                    scanner.nextLine(); // Clear input buffer
                    continue;
                }
            } catch (InputMismatchException e) 
            {
                System.out.println("===================================");
                System.out.println("[ERROR]: Please enter a valid number");
                scanner.nextLine(); // Clear input buffer
                continue;
            }
        
            switch (choice) {
                case 1:
                    System.out.println("Available Products:");
                    for (Product product : products) {
                        System.out.printf("ID: %d, Name: %s, Price: %.2f $, Stock: %d%n",
                                product.getItemId(), product.getName(), product.getPrice(), product.getStockQuantity());
                    }
                    break;
                case 2:
                    System.out.print("Enter Product ID to add to basket: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("[ERROR]: Enter a valid product ID.");
                        scanner.nextLine();
                        continue;
                    }
                    int productId = scanner.nextInt();
                    System.out.print("Enter Quantity: ");
                    if (!scanner.hasNextInt()) {
                        System.out.println("[ERROR]: Enter a valid quantity.");
                        scanner.nextLine();
                        continue;
                    }
                    int quantity = scanner.nextInt();
                    boolean added = basket.addItem(productId, quantity, products);
                    System.out.println(added ? "Product added to basket." : "Failed to add product. Check stock or ID.");
                    break;
                case 3:
                    basket.viewBasket();
                    break;
                case 4:
                    if (basket.getItemsInBasket().isEmpty()) 
                    {
                        System.out.println("Basket is empty. Add items before checkout.");
                        break;
                    }
                    System.out.println("Choose Payment Method:");
                    System.out.println("1. Credit Card");
                    System.out.println("2. PayPal");
                    if (!scanner.hasNextInt()) 
                    {
                        System.out.println("Invalid payment choice.");
                        scanner.nextLine();
                        continue;
                    }
                    int paymentChoice = scanner.nextInt();
                    scanner.nextLine();
                    boolean paymentSuccessful = paymentChoice == 1
                            ? creditCardPayment.pay(basket)
                            : paymentChoice == 2 && payPalPayment.pay(basket);
                    if (paymentSuccessful) {
                        shipment.collectShipmentDetails(scanner);
                        shipment.printShipmentDetails();
                        System.out.println("Thank you for shopping!");
                        scanner.close();
                        return;
                    }
                    System.out.println("Payment failed. Try again.");
                    break;
                case 5:
                    System.out.println("Thank you for shopping!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

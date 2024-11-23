import java.util.Scanner;

public class CreditCardPayment extends Payment {
    @Override
    public boolean pay(Basket basket) 
    {
        int total = calculateTotal(basket);
        if (total == 0) {
            System.out.println("Basket is empty. Add items before payment.");
            return false;
        }

        // Might add validation with regex for each...
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your credit card number: ");
        String creditCardNumber = scanner.nextLine();
        System.out.print("Enter expiration date (MM/YY): ");
        String expirationDate = scanner.nextLine();
        System.out.print("Enter CCV: ");
        String ccv = scanner.nextLine();

        System.out.println("Processing credit card payment of " + total + " $...");
        System.out.println("Payment successful!");
        return true;
    }
}

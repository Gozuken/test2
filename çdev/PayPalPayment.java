import java.util.Scanner;

public class PayPalPayment extends Payment {
    @Override
    public boolean pay(Basket basket) {
        int total = calculateTotal(basket);
        if (total == 0) {
            System.out.println("Basket is empty. Add items before payment.");
            return false;
        }

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter your PayPal email: ");
        String paypalEmail = scanner.nextLine();
        System.out.print("Enter your PayPal password: ");
        String paypalPassword = scanner.nextLine();

        System.out.println("Processing PayPal payment of " + total + " $...");
        System.out.println("Payment successful!");
        return true;
    }
}

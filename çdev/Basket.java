
import java.util.ArrayList;

public class Basket {
    private final ArrayList<BasketItem> itemsInBasket = new ArrayList<>();

    public boolean addItem(int itemId, int quantity, Product[] products) 
    {
        for (Product product : products) 
        {
            if (product.getItemId() == itemId) 
            {
                if (product.getStockQuantity() >= quantity && quantity > 0) 
                {
                    itemsInBasket.add(new BasketItem(product, quantity));
                    product.setStockQuantity(product.getStockQuantity() - quantity);
                    return true;
                } 
                else 
                {
                    System.out.println("Not enough stock or invalid quantity.");
                    return false;
                }
            }
        }
        System.out.println("Invalid Product ID.");
        return false;
    }

    public void viewBasket() 
    {
        if (itemsInBasket.isEmpty()) 
        {
            System.out.println("Basket is empty.");
        } 
        else 
        {
            System.out.println("Items in Basket:");
            for (BasketItem item : itemsInBasket) {
                System.out.printf("Name: %s, Quantity: %d, Price per Item: %.2f $, Total: %.2f $%n",
                        item.getProduct().getName(), item.getQuantity(),
                        item.getProduct().getPrice(), item.getTotalPrice());
            }
        }
    }

    public ArrayList<BasketItem> getItemsInBasket() 
    {
        return itemsInBasket;
    }
}

class BasketItem {
    private final Product product;
    private final int quantity;

    public BasketItem(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;
    }

    // Getters
    public Product getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getTotalPrice() {
        return product.getPrice() * quantity;
    }
}

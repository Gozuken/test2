
public class Product {
    private String name = "Unknown Product";
    private float price;
    private int stockQuantity = 0;
    private int itemId;

    // Getters
    public String getName() 
    {
        return this.name;
    }
    public float getPrice() 
    {
        return this.price;
    }
    public int getStockQuantity() 
    {
        return this.stockQuantity;
    }
    public int getItemId() {
        return this.itemId;
    }

    // Setters
    public void setPrice(float price) 
    {
        this.price = price;
    }
    public void setStockQuantity(int stockQuantity) 
    {
        this.stockQuantity = stockQuantity;
    }
    public void setItemId(int itemId) 
    {
        this.itemId = itemId;
    }

    public Product(String name, float price, int stockQuantity, int itemId) {
        this.name = name;
        this.price = price;
        this.stockQuantity = stockQuantity;
        this.itemId = itemId;
    }
}

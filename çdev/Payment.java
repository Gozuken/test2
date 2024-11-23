// This is a abstract class to be implemented by CreditCardPayment and PayPalPayment
// Not an interface because calculateTotal must be same between all subclasses
public abstract class Payment 
{
    public int calculateTotal(Basket basket) 
    {
        int total = 0;
        for (BasketItem item : basket.getItemsInBasket()) 
        {
            total += item.getTotalPrice();
        }
        return total;
    }

    public abstract boolean pay(Basket basket);
}

public class MonthOrders {
    public String itemName;
    public boolean vector;
    public int quantity;
    public int unitPrice;
    public int month;

    public MonthOrders(String itemName, boolean vector, int quantity, int unitPrice, int month) {
        this.itemName = itemName;
        this.vector = vector;
        this.quantity = quantity;
        this.unitPrice = unitPrice;
        this.month = month;
    }
}

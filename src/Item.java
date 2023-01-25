public class Item {
    String name;
    float price;
    // int quantity;

    public Item(String itemName, float itemPrice) {
        name = itemName;
        price = itemPrice;
        // quantity = 0;
    }
    // public static void main(String[] args) throws Exception {
        
    // }

    public String getItemName() {
        return name;
    }

    public float getItemPrice() {
        return price;
    }
}

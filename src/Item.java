public class Item {
    String name;
    float price;

    public Item(String itemName, float itemPrice) {
        name = itemName;
        price = itemPrice;
    }

    public String getItemName() {
        return name;
    }

    public float getItemPrice() {
        return price;
    }
}

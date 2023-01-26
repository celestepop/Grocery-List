import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class Main {
    // Constructor
    public Main() {}
        
    public static void main(String[] args) throws Exception {
        ArrayList<Item> GroceryList  = new ArrayList<Item>();
        byte option = 3;
        float total = 0.0f;

        while (option != 0) {
            System.out.println("Welcome to your Grocery List!");

            System.out.println("\nChoose an option:");
            System.out.println("\t0. Quit");
            System.out.println("\t1. View list");
            System.out.println("\t2. Add item to list");
            System.out.println("\t3. Remove item from list\n");

            Scanner inputScanner = new Scanner(System.in); // Prep read line
            System.out.print("Option > ");
            option = inputScanner.nextByte();  // Read user input
            // inputScanner.close();

            switch(option){
                case 0:
                    System.out.println("\tProgram ended.");
                    break;
                case 1:
                    // View list
                    display(GroceryList, total);
                    break;
                case 2:
                    // Add item to list
                    total += addItem(GroceryList, inputScanner);
                    break;
                case 3:
                    // Remove item from list
                    total -= removeItem(GroceryList, inputScanner);
                    break;
                default:
                    System.out.println("Switch case defaulted!");
                    break;
        }
        }
    }

    public static float removeItem(ArrayList<Item> list, Scanner in) {
        // find item 
        String name = System.console().readLine("Name of item to remove > ");  // Read user input
        float price = 0.0f;
        for (Item item : list) {
            if (item.getItemName().equals(name)){
                price = item.getItemPrice();
                list.remove(item);
            }
        }
        // list.removeIf(List-> List.getItemName().equals(name));

        return price;
    }

    public static float addItem(ArrayList<Item> List, Scanner in) {
        String name = System.console().readLine("Name of new item > ");  // Read user input
        
        String priceStr = System.console().readLine("Price of item > ");  // Read user input
        float price = Float.parseFloat(priceStr);
        System.out.println("\n");

        List.add(new Item(name, price));

        return price;
    }

    public static void display(ArrayList<Item> list, float subtotal) {
        // display list        
        float tax = 0.07f;
        System.out.println("        MY GROCERY LIST");
        System.out.println("Item           Price"); // setwidth = 15

        for (Item item : list) {
            String name = item.getItemName();
            float price = item.getItemPrice();
            System.out.printf("%-14s %-14.2f\n", name, price);
        }
        System.out.println("---------end of list---------\n");
        System.out.printf("Subtotal: %15f\n", subtotal);
        System.out.printf("Total: %15f\n", (subtotal *tax) + subtotal);
    }
}

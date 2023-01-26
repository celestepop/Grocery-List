import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Constructor
    public Main() {}
        
    public static void main(String[] args) throws Exception {
        ArrayList<Item> GroceryList  = new ArrayList<Item>();
        byte option = 3;
        float total = 0.0f;

        System.out.println("Welcome to your Grocery List!");

        while (option != 0) {
            System.out.println("\nChoose an option:");
            System.out.println("\t0. Quit");
            System.out.println("\t1. View list");
            System.out.println("\t2. Add item to list");
            System.out.println("\t3. Remove item from list\n");

            Scanner inputScanner = new Scanner(System.in); // Prep read line
            System.out.print("Option > ");
            option = inputScanner.nextByte();  // Read user input

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
        // Read user input
        String name = System.console().readLine("Name of item to remove > "); 
        float price = 0.0f;
        // Find item 
        for (Item item : list) {
            if (item.getItemName().equals(name)){
                price = item.getItemPrice();
            }
        }
        list.removeIf(List-> List.getItemName().equals(name));

        return price;
    }

    public static float addItem(ArrayList<Item> List, Scanner in) {
        // Read user input
        String name = System.console().readLine("Name of new item > ");  
        String priceStr = System.console().readLine("Price of item > ");
        float price = Float.parseFloat(priceStr);
        System.out.println("\n");

        // Add new item object
        List.add(new Item(name, price));

        return price;
    }

    public static void display(ArrayList<Item> list, float subtotal) {
        // Display header       
        float tax = 0.07f;
        System.out.println("        MY GROCERY LIST");
        System.out.println("Item           Price");

        // Display list
        for (Item item : list) {
            String name = item.getItemName();
            float price = item.getItemPrice();
            System.out.printf("%-14s %-14.2f\n", name, price);
        }
        // Display totals
        System.out.println("---------end of list---------");
        System.out.printf("Subtotal: %15.2f\n", subtotal);
        System.out.printf("Taxes: %18.2f\n", subtotal * tax);
        System.out.printf("Total: %18.2f\n\n", (subtotal * tax) + subtotal);
    }
}

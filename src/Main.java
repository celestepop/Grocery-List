import java.util.ArrayList;
// import java.util.List;
import java.util.Scanner;

public class Main {
    // List<Item> GroceryList;
    // final tax = 0.07f;
    
    public Main() {
            // GroceryList  = new ArrayList<Item>();
            // option = 3;
    }
        
        
    public static void main(String[] args) throws Exception {
        ArrayList<Item> GroceryList  = new ArrayList<Item>();
        byte option = 3;

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
                    display(GroceryList);
                    break;
                case 2:
                    // Add item to list
                    addItem(GroceryList, inputScanner);
                    break;
                case 3:
                    // Remove item from list
                    removeItem(GroceryList, inputScanner);
                    break;
                default:
                    System.out.println("Switch case defaulted!");
                    break;
        }
        }
    }

    public static void removeItem(ArrayList<Item> list, Scanner in) {
        // find item 
        String name = System.console().readLine("Name of item to remove > ");  // Read user input
        list.removeIf(List-> List.getItemName().equals(name));
    }

    public static void addItem(ArrayList<Item> List, Scanner in) {
        // Scanner in = new Scanner(System.in); // Prep read line
        
        String name = System.console().readLine("Name of new item > ");  // Read user input
        
        String priceStr = System.console().readLine("Price of item > ");  // Read user input
        float price = Float.parseFloat(priceStr);
        System.out.println("\n");

        List.add(new Item(name, price));
    }

    public static void display(ArrayList<Item> list) {
        // display list
        System.out.println("        MY GROCERY LIST");
        System.out.println("Item           Price"); // setwidth = 15

        for (Item item : list) {
            String name = item.getItemName();
            float price = item.getItemPrice();
            System.out.printf("%-14s %-14.2f\n", name, price);
        }
        System.out.println("---------end of list---------\n");
    }
}

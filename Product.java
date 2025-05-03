
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Product {
    //properties
    private int id;
    private String name;
    private int quantity;
    private double price;

    //getters
    public int getId() {
        return this.id;
    };
    public String getName() {
        return this.name;
    };
    public int getQuantity() {
        return this.quantity;
    };
    public double getPrice() {
        return this.price;
    };
    
    //constructor
    public Product(int id, String name, int quantity, double price){
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    //methods
    public static void addProduct(Scanner scanner, ArrayList<Product> productList) {

        System.out.println("Enter the name of the product: ");
        String productName = scanner.nextLine();

        System.out.println("Enter the quantity of products: ");
        int productNumber = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter the price of the product: ");
        double productPrice = scanner.nextDouble();
        scanner.nextLine();

        Random rand = new Random();
        int productId = rand.nextInt(999);
        
        Product newProduct = new Product(productId, productName, productNumber, productPrice);
        productList.add(newProduct);
        System.out.println("Product added successfully.");
    }
    public static void viewProducts(ArrayList<Product> productList) {
        System.out.println("The products in the inventory are: ");
        productList.forEach(item -> {
            System.out.printf("Name: %s | Id: %d | Quantity: %d | Price: %f \n", item.name, item.id, item.quantity, item.price);
        });

    }
    public static void searchProducts(Scanner scanner, ArrayList<Product> productList) {
        System.out.println("Enter the name of the product you are looking for: ");
        String productName = scanner.nextLine().toLowerCase();
        boolean found = false;
        for(Product item : productList) {
            if(item.name.toLowerCase().contains(productName)){
                System.out.printf("Name: %s | Id: %d | Quantity: %d | Price: %f \n", item.name, item.id, item.quantity, item.price);
                found = true;
            }
        }
        if(!found) {
            System.out.println("Item not found in inventory.");
        }
    }
    public static void updateProduct(Scanner scanner, ArrayList<Product> productList) {
        System.out.println("Enter the ID of the product you want to update: ");
        int productId = scanner.nextInt();
        scanner.nextLine();
        Boolean found = false;

        for(Product item : productList) {
            if(productId == item.id) {
                found = true;
                System.out.println("Which value do you want to update?");
                System.out.println("1. Name");
                System.out.println("2. Quantity");
                System.out.println("3. Price");

                int updatingItem = scanner.nextInt();
                scanner.nextLine();
                
                switch (updatingItem) {

                    case 1:
                        System.out.println("Enter new name: ");
                        String updatedName = scanner.nextLine();
                        item.name = updatedName;
                        break;

                    case 2:
                        System.out.println("Enter new quantity: ");
                        int updatedQuantity = scanner.nextInt();
                        scanner.nextLine();
                        item.quantity = updatedQuantity;
                        break;

                    case 3:
                        System.out.println("Enter new price: ");
                        double updatedPrice = scanner.nextDouble();
                        scanner.nextLine();
                        item.price = updatedPrice;
                        break;

                    default:
                        System.out.println("Invalid Output");
                }
                System.out.println("The updated item is: ");
                System.out.printf("Name: %s | Id: %d | Quantity: %d | Price: %f \n", item.name, item.id, item.quantity, item.price);
            }
        }
        if(!found) {
            System.out.println("Item not found.");
        }
    }
    public static void deleteProduct(Scanner scanner, ArrayList<Product> productList) {
        System.out.println("Type the Id of the product you want to delete: ");
        int idToRemove = scanner.nextInt();
        Boolean deleted = productList.removeIf(item -> idToRemove == item.id);
        
        if(deleted){
            System.out.printf("Item with Id %d has been removed successfully. \n", idToRemove);
        }
        else{
            System.out.println("Item not found in inventory.");
        }

        
    }
}
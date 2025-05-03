import java.util.ArrayList;
import java.util.Scanner;

public class MainMenu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Product> list = new ArrayList<Product>();
        boolean running = true;
        int choice;
        
        while(running) {
            System.out.println("\n--------Inventory Manager--------");
            System.out.println("1. Add Product");
            System.out.println("2. View All Products");
            System.out.println("3. Search For A Product");
            System.out.println("4. Update Product");
            System.out.println("5. Delete Product");
            System.out.println("6. Exit");

            choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1: 
                    Product.addProduct(scanner, list);
                    break;
                case 2:
                    Product.viewProducts(list);
                    break;
                case 3:
                    Product.searchProducts(scanner, list);
                    break;
                case 4:
                    Product.updateProduct(scanner, list);
                    break;
                case 5:
                    Product.deleteProduct(scanner, list);
                    break;
                case 6:
                    running = false;
                    System.out.println("Goodbye!");
                    
            }           
        }

    }
}
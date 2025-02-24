import java.util.Scanner;

class Product {
    String pcode;
    String pname;
    double price;

    public Product(String pcode, String pname, double price) {
        this.pcode = pcode;
        this.pname = pname;
        this.price = price;
    }
}

public class SimpleProductManager {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create an array to hold products
        Product[] products = new Product[5]; // Limit to 5 products for simplicity

        // Input product details
        for (int i = 0; i < products.length; i++) {
            System.out.println("Enter product code:");
            String pcode = scanner.nextLine();

            System.out.println("Enter product name:");
            String pname = scanner.nextLine();

            System.out.println("Enter product price:");
            double price = scanner.nextDouble();
            scanner.nextLine(); // Consume newline

            products[i] = new Product(pcode, pname, price);
        }

        // Find the product with the lowest price
        Product lowestPriceProduct = products[0];
        for (Product product : products) {
            if (product.price < lowestPriceProduct.price) {
                lowestPriceProduct = product;
            }
        }

        // Display the product with the lowest price
        System.out.println("Product with the lowest price:");
        System.out.println("Code: " + lowestPriceProduct.pcode);
        System.out.println("Name: " + lowestPriceProduct.pname);
        System.out.println("Price: $" + lowestPriceProduct.price);

        scanner.close();
    }
}
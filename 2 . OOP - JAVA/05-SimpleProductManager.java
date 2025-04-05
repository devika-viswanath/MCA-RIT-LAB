//method 1
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

//simple code method 2

import java.util.Scanner;
class product{
    int pcode;
    String pname;
    double price;
    product(int pcode,String pname,double price){
        this.pcode=pcode;
        this.pname=pname;
        this.price=price;
    }
    void display(){
        System.out.println("product code:"+pcode);
        System.out.println("product name:"+pname);
        System.out.println("product price:"+price);
    }
}
public class ProductLowestprize{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("how much employee you want to insert:");
        int n=obj.nextInt();
        obj.nextLine();
        product[] products=new product[n];
        for(int i=0;i<n;i++){
            System.out.println("Enter the pcode:");
            int pcode=obj.nextInt();
            obj.nextLine();
            System.out.println("Enter the pname:");
            String pname=obj.nextLine();
            System.out.println("Enter the price:");
            double price=obj.nextDouble();
            products[i]=new product(pcode,pname,price);

        }

        product lowestprice=products[0];
        for(int i=1;i<n;i++){
            if(products[i].price <lowestprice.price){
                
                lowestprice=products[i];
            }
            
            
        }
        lowestprice.display();
    }
}

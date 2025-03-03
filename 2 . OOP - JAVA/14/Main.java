import graphics.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Rectangle
        System.out.print("Enter length and width of the rectangle: ");
        double length = scanner.nextDouble();
        double width = scanner.nextDouble();
        Shape rectangle = new Rectangle(length, width);
        System.out.println("Area of Rectangle: " + rectangle.area());

        // Square
        System.out.print("\nEnter side length of the square: ");
        double side = scanner.nextDouble();
        Shape square = new Square(side);
        System.out.println("Area of Square: " + square.area());

        // Triangle
        System.out.print("\nEnter base and height of the triangle: ");
        double base = scanner.nextDouble();
        double height = scanner.nextDouble();
        Shape triangle = new Triangle(base, height);
        System.out.println("Area of Triangle: " + triangle.area());

        // Circle
        System.out.print("\nEnter radius of the circle: ");
        double radius = scanner.nextDouble();
        Shape circle = new Circle(radius);
        System.out.println("Area of Circle: " + circle.area());

        scanner.close();
    }
}

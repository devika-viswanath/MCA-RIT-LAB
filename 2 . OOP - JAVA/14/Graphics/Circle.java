package graphics;

// Circle class implementing Shape interface
public class Circle implements Shape {
    double radius;
    final double PI = 3.14159;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    public double area() {
        return PI * radius * radius;
    }
}

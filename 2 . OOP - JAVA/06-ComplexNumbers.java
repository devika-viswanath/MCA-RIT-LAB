import java.util.Scanner;

class Complex {
    double real, imaginary;

    Complex(double r, double i) {
        this.real = r;
        this.imaginary = i;
    }

    Complex add(Complex other) {
        return new Complex(this.real + other.real, this.imaginary + other.imaginary);
    }

    Complex multiply(Complex other) {
        return new Complex(this.real * other.real - this.imaginary * other.imaginary,
                           this.real * other.imaginary + this.imaginary * other.real);
    }

    @Override
    public String toString() {
        return real + " + " + imaginary + "i";
    }
}

public class ComplexNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter real part of first complex number: ");
        double r1 = scanner.nextDouble();
        System.out.print("Enter imaginary part of first complex number: ");
        double i1 = scanner.nextDouble();
        
        System.out.print("Enter real part of second complex number: ");
        double r2 = scanner.nextDouble();
        System.out.print("Enter imaginary part of second complex number: ");
        double i2 = scanner.nextDouble();
        
        Complex c1 = new Complex(r1, i1);
        Complex c2 = new Complex(r2, i2);
        
        Complex sum = c1.add(c2);
        Complex product = c1.multiply(c2);
        
        System.out.println("Sum: " + sum);
        System.out.println("Product: " + product);
        
        scanner.close();
    }
}
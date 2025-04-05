//method 1
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


//method 2

import java.util.Scanner;
class Complex{
    double a;
    double b;
    double c;
    double d;
    Complex(double a,double b,double c,double d){
        this.a=a;
        this.b=b;
        this.c=c;
        this.d=d;
    }
    
}
public class ComplexNum{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the first complex numbers:");
        System.out.println("enter a:");
        double a=obj.nextDouble();
        System.out.println("enter b:");
        double b=obj.nextDouble();
        System.out.println("Enter the second complex numbers:");
        System.out.println("enter the c:");
        double c=obj.nextDouble();
        System.out.println("enter the d:");
        double d=obj.nextDouble();
        //sum
        System.out.println("sum of 2 complex num:");
        System.out.println((a+c) + "+" + (b+d)+"i" );
        //product
        System.out.println("product of 2 complex num:");
        System.out.println(((a*c)-(b*d)) + "+" +((a*d)+(b*c)) +"i");
    }
}

//method 3

import java.util.Scanner;

class Complex { double real, imag;

Complex(double r, double i) {
    this.real = r;
    this.imag = i;
}

Complex add(Complex c) {
    return new Complex(this.real + c.real, this.imag + c.imag);
}

Complex multiply(Complex c) {
    return new Complex(this.real * c.real - this.imag * c.imag,
                       this.real * c.imag + this.imag * c.real);
}

void display() {
    System.out.println(real + " + " + imag + "i");
}

}

public class ComplexNumbers { public static void main(String[] args) { Scanner scanner = new Scanner(System.in);

System.out.print("Enter real and imaginary parts of first complex number: ");
    double r1 = scanner.nextDouble(), i1 = scanner.nextDouble();
    Complex c1 = new Complex(r1, i1);

    System.out.print("Enter real and imaginary parts of second complex number: ");
    double r2 = scanner.nextDouble(), i2 = scanner.nextDouble();
    Complex c2 = new Complex(r2, i2);

    System.out.print("Sum: ");
    c1.add(c2).display();

    System.out.print("Product: ");
    c1.multiply(c2).display();

    scanner.close();
}

}

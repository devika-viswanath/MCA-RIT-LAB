import java.util.Scanner;
abstract class Animals{

    abstract void makeSound();
    void display(){
        System.out.println("Animals make sound:");
    }
        
    
}
class Dog extends Animals{
    void makeSound(){
        System.out.println("Dog make sound like Woof");
    }
    void display(){
        super.display();
        System.out.println("Dog is a animal:");
    }
    

}
class Cat extends Animals{
    void makeSound(){
        System.out.println("Cat make sound like meow");
    }
    void display(){
        super.display();
        System.out.println("cat is animal:");
    }
}
public class Animal{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        Dog dog=new Dog();
        dog.display();
        dog.makeSound();
        Cat cat=new Cat();
        cat.display();
        cat.makeSound();
    }
}

import java.util.Scanner;
interface Shape{
    public double area();
}
class Circle implements Shape{
    int r;
    
    Circle(int r){
        this.r=r;
    }
    public double area(){
        return Math.PI*r*r;
    }
    
}
class Rectangle implements Shape{
    int l;
    int w;
    Rectangle(int l,int w){
        this.l=l;
        this.w=w;
    }
    public double area(){
        return l*w;
    }
   
}
public class GeometryArea{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the radius:");
        int r=obj.nextInt();
        obj.nextLine();
        System.out.println("enter the length:");
        int l=obj.nextInt();
        obj.nextLine();
        System.out.println("enter the width:");
        int w=obj.nextInt();
        obj.nextLine();
        Shape circle=new Circle(r);
        Shape rectangle=new Rectangle(l,w);
        
        System.out.println("Arae of the circle:"+circle.area());
        System.out.println("Arae of the rectangle:"+rectangle.area());

    }
}

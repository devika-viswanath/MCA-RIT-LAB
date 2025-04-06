import java.util.Scanner;
public class DivideByZero{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        System.out.println("Enter the num1:");
        int num1=obj.nextInt();
        obj.nextLine();
        System.out.println("Enter the num2:");
        int num2=obj.nextInt();
        obj.nextLine();

        try{
            int result=num1/num2;
            System.out.println("result:"+result);
        }
        catch(ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        System.out.println("programme ended");
    }
}

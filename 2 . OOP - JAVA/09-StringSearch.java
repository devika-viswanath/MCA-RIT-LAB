// method1
import java.util.Scanner;

public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get the number of strings
        System.out.print("Enter the number of strings: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume the newline character

        // Create an array to store strings
        String[] strings = new String[n];

        // Input strings
        System.out.println("Enter the strings:");
        for (int i = 0; i < n; i++) {
            strings[i] = scanner.nextLine();
        }

        // Get the string to search
        System.out.print("Enter the string to search: ");
        String searchString = scanner.nextLine();

        // Search for the string
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (strings[i].equals(searchString)) {
                index = i;
                break;
            }
        }

        // Display result
        if (index != -1) {
            System.out.println("String found at index: " + index);
        } else {
            System.out.println("String not found.");
        }

        scanner.close();
    }
}

//method2

import java.util.Scanner;
class StringCollection{
    String str;
    StringCollection(String str){
        this.str=str;

    }
    void display(){
        System.out.println("string:"+str);

    }
}
public class StringSearch{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
       
        System.out.println("Enter the number of string:");
        int n=obj.nextInt(); 
        obj.nextLine();
         String[] strings=new String[n];
        for(int i=0;i<n;i++){
            System.out.println("enter the strings:");
            String str=obj.nextLine();
            strings[i]=new String(str);
            
            
        }
        System.out.println("enter the string to search:");
        String searchstring=obj.nextLine();
        for(int i=0;i<n;i++){
            if(strings[i].equals(searchstring)){
                System.out.println("string found,String is:"+strings[i]+ ": index :"+ i);

                return;
            }
            
        
            
        }
        System.out.println("string not found");
    }
}

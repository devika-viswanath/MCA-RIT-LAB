import java.io.*;
import java.util.Scanner;

// Custom Exception for Authentication Failure
class AuthenticationException extends Exception {
    public AuthenticationException(String message) {
        super(message);
    }
}

public class AuthenticationSystem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Step 1: File Handling
        System.out.print("Enter filename to read: ");
        String filename = scanner.nextLine();
        readFile(filename);

        // Step 2: Authentication
        System.out.print("\nEnter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        try {
            authenticate(username, password);
            System.out.println("Authentication successful! Welcome, " + username + ".");
        } catch (AuthenticationException e) {
            System.out.println("Authentication failed: " + e.getMessage());
        }

        scanner.close();
    }

    // Method to read a file and handle exceptions
    public static void readFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            System.out.println("\nContents of " + filename + ":");
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: File not found - " + filename);
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to authenticate user
    public static void authenticate(String username, String password) throws AuthenticationException {
        String correctUsername = "admin";
        String correctPassword = "admin123";

        if (!username.equals(correctUsername) || !password.equals(correctPassword)) {
            throw new AuthenticationException("Invalid username or password.");
        }
    }
}
//meethod mine
import java.util.Scanner;
import java.io.*;
class AuthenticationException extends Exception{
    public AuthenticationException(String message){
        super(message);
    }
}
public class ExceptionDemo{
    public static void readFile(String filename){
        try(BufferedReader reader=new BufferedReader(new FileReader(filename))){
            String line;
            while((line=reader.readLine())!=null){
                System.out.println(line);
            }
        }catch(FileNotFoundException e){
            
        }catch(IOException e){

        }
    }
    public static void Authenticate(String username,String password) throws AuthenticationException{
        if(!username.equals("admin") || !password.equals("admin123")){
            throw new AuthenticationException("incorrect username or password");
        }

    }
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in);
        String filename="file.txt";
        readFile(filename);
        System.out.println("Eneter the username:");
        String username=obj.nextLine();
        System.out.println("Enter the password:");
        String password=obj.nextLine();
        try{
            Authenticate(username,password);
            System.out.print("WELCOME"+username);
        }catch(AuthenticationException e){
            System.out.println("Error!!try again..");

        }
        obj.close();

    }
}

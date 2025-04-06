//method 1
import java.io.*;
import java.util.Scanner;

public class FileOperations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String filename = "sample.txt";

        while (true) {
            System.out.println("\nFile Operations Menu:");
            System.out.println("1. Write to File");
            System.out.println("2. Read from File");
            System.out.println("3. Append to File");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");
            
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            
            switch (choice) {
                case 1:
                    writeToFile(filename, scanner);
                    break;
                case 2:
                    readFromFile(filename);
                    break;
                case 3:
                    appendToFile(filename, scanner);
                    break;
                case 4:
                    System.out.println("Exiting program...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice! Try again.");
            }
        }
    }

    // Method to write to file
    public static void writeToFile(String filename, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            System.out.print("Enter text to write to file: ");
            String content = scanner.nextLine();
            writer.write(content);
            writer.newLine();
            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Method to read from file
    public static void readFromFile(String filename) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            System.out.println("\nContents of the file:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    // Method to append to file
    public static void appendToFile(String filename, Scanner scanner) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            System.out.print("Enter text to append to file: ");
            String content = scanner.nextLine();
            writer.write(content);
            writer.newLine();
            System.out.println("Data appended to file successfully.");
        } catch (IOException e) {
            System.out.println("Error appending to file: " + e.getMessage());
        }
    }
}

//method 2

import java.io.*;  
import java.util.Scanner;  

public class FileOperation {  
    public static void main(String arg[]) {  
        Scanner obj = new Scanner(System.in);  
        String filename = "file.txt"; // Added missing semicolon
        
        System.out.println("The menu:");
        System.out.println("1. Write file");
        System.out.println("2. Read file");
        System.out.println("3. Append file");
        System.out.print("Enter your choice: ");  
        int choice = obj.nextInt();  
        obj.nextLine(); // Clear the buffer after reading int  

        if (choice == 1) {  
            try {  
                FileWriter filewriter = new FileWriter(filename);  
                System.out.println("Enter the text to write:");  
                String text = obj.nextLine();  
                filewriter.write(text);  
                filewriter.close();  
                System.out.println("Text written successfully.");  
            } catch (IOException error) {  
                System.out.println("Something went wrong!!!");  
            }  
        } else if (choice == 2) {  
            try {
                FileReader filereader = new FileReader(filename);  
                BufferedReader bufferedreader = new BufferedReader(filereader);  
                String line;  
                System.out.println("Contents of the file:");  
                while ((line = bufferedreader.readLine()) != null) {  
                    System.out.println(line);  
                }  
                bufferedreader.close();  
            } catch (IOException error) {  
                System.out.println("Something went wrong!!");  
            }  
        } else if (choice == 3) {  
            try {
                FileWriter filewriter = new FileWriter(filename, true);  
                System.out.println("Enter text to append:");  
                String text = obj.nextLine();  
                filewriter.write(text);  
                filewriter.close();  
                System.out.println("Text appended successfully.");  
            } catch (IOException error) {  
                System.out.println("Something went wrong:");  
            }  
        } else {
            System.out.println("Invalid choice.");
        }

        obj.close();  
    }  
}

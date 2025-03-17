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

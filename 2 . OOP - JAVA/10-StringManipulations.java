import java.util.Scanner;

public class StringManipulations {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Get user input
        System.out.print("Enter a string: ");
        String str = scanner.nextLine();

        // String length
        System.out.println("Length of the string: " + str.length());

        // Convert to uppercase
        System.out.println("Uppercase: " + str.toUpperCase());

        // Convert to lowercase
        System.out.println("Lowercase: " + str.toLowerCase());

        // Extract a character at a given index
        System.out.print("Enter index to extract character: ");
        int index = scanner.nextInt();
        if (index >= 0 && index < str.length()) {
            System.out.println("Character at index " + index + ": " + str.charAt(index));
        } else {
            System.out.println("Invalid index!");
        }

        // Extract a substring
        System.out.print("Enter start and end index for substring: ");
        int start = scanner.nextInt();
        int end = scanner.nextInt();
        if (start >= 0 && end <= str.length() && start < end) {
            System.out.println("Substring: " + str.substring(start, end));
        } else {
            System.out.println("Invalid substring range!");
        }

        // Reverse the string
        String reversed = new StringBuilder(str).reverse().toString();
        System.out.println("Reversed string: " + reversed);

        scanner.close();
    }
}

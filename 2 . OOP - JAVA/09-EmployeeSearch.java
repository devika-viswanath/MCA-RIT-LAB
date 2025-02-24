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

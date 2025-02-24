import java.util.Scanner;

class Employee {
    int empNumber;
    String empName;
    double salary;

    // Constructor to initialize employee details
    Employee(int empNumber, String empName, double salary) {
        this.empNumber = empNumber;
        this.empName = empName;
        this.salary = salary;
    }

    // Method to display employee details
    void display() {
        System.out.println("Employee Number: " + empNumber);
        System.out.println("Employee Name: " + empName);
        System.out.println("Salary: $" + salary);
    }
}

public class EmployeeSearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Enter the number of employees
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();
        Employee[] employees = new Employee[n];

        // Input employee details
        for (int i = 0; i < n; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            int empNumber = scanner.nextInt();
            scanner.nextLine(); // Consume newline
            System.out.print("Employee Name: ");
            String empName = scanner.nextLine();
            System.out.print("Salary: ");
            double salary = scanner.nextDouble();

            employees[i] = new Employee(empNumber, empName, salary);
        }

        // Search for an employee by employee number
        System.out.print("\nEnter employee number to search: ");
        int searchNumber = scanner.nextInt();
        boolean found = false;

        for (Employee emp : employees) {
            if (emp.empNumber == searchNumber) {
                System.out.println("\nEmployee Found:");
                emp.display();
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println("Employee not found!");
        }

        scanner.close();
    }
}

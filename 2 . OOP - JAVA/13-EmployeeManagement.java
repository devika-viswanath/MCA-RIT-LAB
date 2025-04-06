//method 1
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// Abstract Class: Employee
abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateSalary();

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: $" + salary);
        System.out.println("Total Salary: $" + calculateSalary());
    }
}

// Interface: Benefits
interface Benefits {
    double calculateBenefits();
}

// Manager Class (inherits Employee, implements Benefits)
class Manager extends Employee implements Benefits {
    double bonus;

    Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public double calculateBenefits() {
        return 5000; // Fixed insurance benefit
    }

    // Method Overloading: Assign Project
    void assignProject(String projectName) {
        System.out.println(name + " assigned to project: " + projectName);
    }

    void assignProject(String projectName, int teamMembers) {
        System.out.println(name + " assigned to project: " + projectName + " with " + teamMembers + " team members.");
    }
}

// Developer Class (inherits Employee, implements Benefits)
class Developer extends Employee implements Benefits {
    int experience;

    Developer(String name, double salary, int experience) {
        super(name, salary);
        this.experience = experience;
    }

    @Override
    double calculateSalary() {
        return salary + (experience * 500);
    }

    @Override
    public double calculateBenefits() {
        return experience * 200; // Allowance based on experience
    }
}

// Main Class
public class EmployeeManagement {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Employee> employees = new ArrayList<>();

        // Adding Employees
        System.out.print("Enter number of employees: ");
        int n = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Type (Manager/Developer): ");
            String type = scanner.nextLine();

            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Base Salary: ");
            double salary = scanner.nextDouble();

            if (type.equalsIgnoreCase("Manager")) {
                System.out.print("Bonus: ");
                double bonus = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                Manager manager = new Manager(name, salary, bonus);
                employees.add(manager);

                // Assigning project
                System.out.print("Enter project name: ");
                String projectName = scanner.nextLine();
                System.out.print("Enter number of team members (or 0 to skip): ");
                int teamMembers = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                if (teamMembers > 0) {
                    manager.assignProject(projectName, teamMembers);
                } else {
                    manager.assignProject(projectName);
                }

            } else if (type.equalsIgnoreCase("Developer")) {
                System.out.print("Experience (years): ");
                int experience = scanner.nextInt();
                scanner.nextLine(); // Consume newline
                employees.add(new Developer(name, salary, experience));
            } else {
                System.out.println("Invalid Employee Type! Skipping...");
            }
        }

        // Display Employee Details
        System.out.println("\n--- Employee Details ---");
        for (Employee emp : employees) {
            emp.display();
            if (emp instanceof Benefits) {
                System.out.println("Benefits: $" + ((Benefits) emp).calculateBenefits());
            }
            System.out.println("---------------------------");
        }

        scanner.close();
    }
}


//method 2

import java.util.Scanner;

// Abstract class Employee
abstract class Employee {
    String name;
    double salary;

    Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    abstract double calculateSalary();

    void displayEmployee() {
        System.out.println("Name: " + name);
        System.out.println("Base Salary: " + salary);
    }
}

// Interface Benefits
interface Benefits {
    double calculateBenefits();
}

// Manager class
class Manager extends Employee implements Benefits {
    double bonus;

    Manager(String name, double salary, double bonus) {
        super(name, salary);
        this.bonus = bonus;
    }

    @Override
    double calculateSalary() {
        return salary + bonus;
    }

    @Override
    public double calculateBenefits() {
        return 50000; // Fixed insurance benefit
    }

    void displayManager() {
        displayEmployee();
        System.out.println("Bonus: " + bonus);
    }

    // Method overloading for project assignment
    void assignProject(String projectName) {
        System.out.println(name + " assigned to project: " + projectName);
    }

    void assignProject(String projectName, int teamMembers) {
        System.out.println(name + " assigned to project: " + projectName + " with " + teamMembers + " team members.");
    }
}

// Developer class
class Developer extends Employee implements Benefits {
    double experience;

    Developer(String name, double salary, double experience) {
        super(name, salary);
        this.experience = experience;
    }

    @Override
    double calculateSalary() {
        return salary + (experience * 500); // Extra based on experience
    }

    @Override
    public double calculateBenefits() {
        return experience * 100; // Allowance based on experience
    }

    void displayDeveloper() {
        displayEmployee();
        System.out.println("Experience (years): " + experience);
    }
}

// Main class
public class EmployeeCollection {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of employees: ");
        int n = sc.nextInt();
        sc.nextLine(); // Consume newline

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for Employee " + (i + 1));
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Base Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            System.out.print("Is this employee a Manager or Developer? (Enter 'Manager' or 'Developer'): ");
            String type = sc.nextLine().toLowerCase();

            if (type.equals("manager")) {
                System.out.print("Enter Bonus: ");
                double bonus = sc.nextDouble();
                sc.nextLine();

                Manager manager = new Manager(name, salary, bonus);
                employees[i] = manager;

                manager.displayManager();
                System.out.println("Total Salary: " + manager.calculateSalary());
                System.out.println("Benefits: " + manager.calculateBenefits());
                manager.assignProject("ProjectX");
                manager.assignProject("ProjectY", 5);

            } else if (type.equals("developer")) {
                System.out.print("Enter Experience (years): ");
                double experience = sc.nextDouble();
                sc.nextLine();

                Developer developer = new Developer(name, salary, experience);
                employees[i] = developer;

                developer.displayDeveloper();
                System.out.println("Total Salary: " + developer.calculateSalary());
                System.out.println("Benefits: " + developer.calculateBenefits());

            } else {
                System.out.println("Invalid employee type. Skipping this entry.");
            }
        }

        sc.close();
    }
}

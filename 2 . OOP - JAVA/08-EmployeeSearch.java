//method 1
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

//method 2

import java.util.Scanner;
class Employee{
    int empno;
    String name;
    double salary;
    Employee(int empno,String name,double salary){

        this.empno=empno;
        this.name=name;
        this.salary=salary;
    }
    
}
public class EmployeeSearch{
    public static void main(String arg[]){
        Scanner obj=new Scanner(System.in); 
        System.out.println("Enter the number of Employee:");
        int n=obj.nextInt();
        obj.nextLine();
        Employee[] employees=new Employee[n];
        for(int i=0;i<n;i++){
                System.out.println("Enter the employee no:");
                int empno=obj.nextInt();
                obj.nextLine();
                System.out.println("Enter the Empname:");
                String name=obj.nextLine();
                System.out.println("Enter the salary:");
                double salary=obj.nextDouble();
                
                employees[i]=new Employee(empno,name,salary);}
        System.out.println("enter the search empno:");
        int searchnum=obj.nextInt();
        obj.nextLine();
        for(int i=0;i<n;i++){
            if(employees[i].empno==searchnum){
                System.out.println("Search Employee details:");
                System.out.println("Employee num:"+employees[i].empno);
                System.out.println("Employee name:"+employees[i].name);
                System.out.println("Employee salary:"+employees[i].salary);
            }
            else{
                System.out.println("Employee not found!!!");
            }
        }
        obj.close();
    

    }
}

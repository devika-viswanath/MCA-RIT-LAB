//method 1
import java.util.Scanner;

class BankAccount {
    int accNum;
    String name;
    double balance;

    BankAccount(int accNum, String name, double balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account number: " + accNum);
        System.out.println("Account holder name: " + name);
        System.out.println("Balance: " + balance);
    }

    void deposit(double depAmount) {
        balance += depAmount;
        System.out.println("Bank balance after the deposit: " + balance);
    }

    void withdraw(double withdrawAmount) {
        if (balance > 1000 && withdrawAmount <= balance - 1000) {
            balance -= withdrawAmount;
            System.out.println("Bank balance after the withdrawal: " + balance);
        } else {
            System.out.println("Minimum balance is less than 1000 or insufficient funds.. cannot withdraw!!");
        }
    }
}

public class BankAccountDetails {
    public static void main(String arg[]) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the Account Number:");
        int accNum = obj.nextInt();
        obj.nextLine();

        System.out.println("Enter the account holder name:");
        String name = obj.nextLine();

        System.out.println("Enter the initial balance:");
        double balance = obj.nextDouble();

        BankAccount account = new BankAccount(accNum, name, balance);
        account.display();

        System.out.println("Enter the deposit amount:");
        double depAmount = obj.nextDouble();
        account.deposit(depAmount);

        System.out.println("Enter the withdraw amount:");
        double withdrawAmount = obj.nextDouble();
        account.withdraw(withdrawAmount);
    }
}
//method 2

import java.util.Scanner;

class BankAccount {
    int accNum;
    String name;
    double balance;
    double depAmount;
    double withdraw;

    BankAccount(int accNum, String name, double balance, double depAmount, double withdraw) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
        this.depAmount = depAmount;
        this.withdraw = withdraw;
    }

    void display() {
        System.out.println("Account number: " + accNum);
        System.out.println("Account holder name: " + name);
        System.out.println("Balance: " + balance);
    }

    double depositAmount() {
        balance = balance + depAmount; // Update the balance
        return balance;
    }

    double withdrawAmount() {
        if (balance - withdraw >= 1000) {
            balance = balance - withdraw; // Update the balance
            return balance;
        } else {
            System.out.println("Minimum balance is less than 1000.. cannot withdraw!!");
            return balance;
        }
    }
}

public class BankAccountDetails {
    public static void main(String arg[]) {
        Scanner obj = new Scanner(System.in);

        System.out.println("Enter the Account Number:");
        int accNum = obj.nextInt();
        obj.nextLine();

        System.out.println("Enter the account holder name:");
        String name = obj.nextLine();

        System.out.println("Enter the balance:");
        double balance = obj.nextDouble();

        System.out.println("Enter the deposit amount:");
        double depAmount = obj.nextDouble();

        System.out.println("Enter the withdraw amount:");
        double withdraw = obj.nextDouble();

        BankAccount accounts = new BankAccount(accNum, name, balance, depAmount, withdraw);

        accounts.display();

        System.out.println("Bank balance after the deposit: " + accounts.depositAmount());

        System.out.println("Bank balance after the withdrawal: " + accounts.withdrawAmount());
    }
}

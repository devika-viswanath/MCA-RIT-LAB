class BankAccount:
    def __init__(self, name, account_number, balance=0):
        self.name = name
        self.account_number = account_number
        self.balance = balance

    def deposit(self, amount):
        if amount > 0:
            self.balance += amount
            print(f"Deposited ${amount}")
        else:
            print("Invalid deposit amount")

    def withdraw(self, amount):
        if amount > 0 and amount <= self.balance:
            self.balance -= amount
            print(f"Withdrew ${amount}")
        else:
            print("Invalid withdrawal amount")

    def display_details(self):
        print(f"\nName: {self.name}")
        print(f"Account Number: {self.account_number}")
        print(f"Balance: ${self.balance}")

def get_valid_float(prompt):
    while True:
        value = input(prompt)
        if value.replace('.', '', 1).isdigit():
            return float(value)
        print("Please enter a valid number.")

name = input("Enter your name: ")
account_number = input("Enter account number: ")
    
while True:
    initial_balance = get_valid_float("Enter initial balance: $")
    if initial_balance >= 0:
        break
    print("Balance cannot be negative. Try again.")

account = BankAccount(name, account_number, initial_balance)

while True:
    
    print("\n--- Bank Account Menu ---")
    print("1. Deposit")
    print("2. Withdraw")
    print("3. Check Balance")
    print("4. Exit")
        
    choice = input("Enter your choice (1-4): ")

    if choice == '1':
        amount = get_valid_float("Enter deposit amount: $")
        account.deposit(amount)

    elif choice == '2':
        amount = get_valid_float("Enter withdrawal amount: $")
        account.withdraw(amount)

    elif choice == '3':
        account.display_details()

    elif choice == '4':
        print("Thank you for using our banking system. Goodbye!")
        break

    else:
        print("Invalid choice. Please try again.")

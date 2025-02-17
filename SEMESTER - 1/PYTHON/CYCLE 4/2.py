def add(a, b):
    return a + b

def subtract(a, b):
    return a - b

def multiply(a, b):
    return a * b

def divide(a, b):
    if b == 0:
        return "Cannot divide by zero."
    return a / b

def display_menu():
    print("Select  operation: ")
    print("1. Addition")
    print("2. Subtraction")
    print("3. Multiplication")
    print("4. Division")
    print("5. Exit")

while True:
    display_menu()
    choice = input("Enter choice : ")
    
    if choice == '5':
        print("Bye ... ")
        break
    
    num1 = float(input("Enter  first number: "))
    num2 = float(input("Enter  second number: "))
    
    if choice == '1':
        result = add(num1, num2)
        print(f"ans = {result}")
    elif choice == '2':
        result = subtract(num1, num2)
        print(f"ans = {result}")
    elif choice == '3':
        result = multiply(num1, num2)
        print(f"ans = {result}")
    elif choice == '4':
        result = divide(num1, num2)
        print(f"ans = {result}")
    else:
        print("Invalid choice. Please try again.")
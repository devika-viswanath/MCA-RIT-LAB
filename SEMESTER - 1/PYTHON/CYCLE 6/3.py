from abc import ABC, abstractmethod

class Polygon(ABC):
    @abstractmethod
    def get_dimensions(self):
        """Abstract method to get polygon dimensions"""
        pass
    
    @abstractmethod
    def calculate_area(self):
        """Abstract method to calculate polygon area"""
        pass

class Rectangle(Polygon):
    def get_dimensions(self):
        """Get rectangle dimensions from user input"""
        self.length = float(input("Enter rectangle length: "))
        self.width = float(input("Enter rectangle width: "))
    
    def calculate_area(self):
        """Calculate and return rectangle area"""
        return self.length * self.width

class Triangle(Polygon):
    def get_dimensions(self):
        """Get triangle dimensions from user input"""
        self.base = float(input("Enter triangle base: "))
        self.height = float(input("Enter triangle height: "))
    
    def calculate_area(self):
        """Calculate and return triangle area"""
        return 0.5 * self.base * self.height

while True:
    print("\n--- Polygon Area Calculator ---")
    print("1. Rectangle")
    print("2. Triangle")
    print("3. Exit")
        
    choice = input("Enter your choice (1-3): ")
        
    if choice == '1':
        rect = Rectangle()
        rect.get_dimensions()
        print(f"Rectangle Area: {rect.calculate_area()}")
        
    elif choice == '2':
        tri = Triangle()
        tri.get_dimensions()
        print(f"Triangle Area: {tri.calculate_area()}")
        
    elif choice == '3':
        print("Thank you !!!")
        break
        
    else:
            print("Invalid choice. Please try again.")


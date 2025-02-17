class Rectangle:
    def __init__(self, length, breadth):
        self.length = length
        self.breadth = breadth
    
    def calculate_area(self):
        """Calculate and return the area of the rectangle"""
        return self.length * self.breadth
    
    def calculate_perimeter(self):
        """Calculate and return the perimeter of the rectangle"""
        return 2 * (self.length + self.breadth)
    
    def compare_area(self, other):
        """Compare the area of this rectangle with another rectangle"""
        if not isinstance(other, Rectangle):
            raise TypeError("Can only compare with another Rectangle object")
        
        current_area = self.calculate_area()
        other_area = other.calculate_area()
        
        if current_area > other_area:
            return f"This rectangle (Area: {current_area}) is larger than the other rectangle (Area: {other_area})"
        elif current_area < other_area:
            return f"This rectangle (Area: {current_area}) is smaller than the other rectangle (Area: {other_area})"
        else:
            return f"Both rectangles have equal area: {current_area}"

print("Enter details for first rectangle:")
length1 = float(input("Enter length: "))
breadth1 = float(input("Enter breadth: "))
rect1 = Rectangle(length1, breadth1)

print("\nEnter details for second rectangle:")
length2 = float(input("Enter length: "))
breadth2 = float(input("Enter breadth: "))
rect2 = Rectangle(length2, breadth2)

print("\nFirst Rectangle:")
print(f"Area: {rect1.calculate_area()}")
print(f"Perimeter: {rect1.calculate_perimeter()}")

print("\nSecond Rectangle:")
print(f"Area: {rect2.calculate_area()}")
print(f"Perimeter: {rect2.calculate_perimeter()}")

print("\nComparison:")
print(rect1.compare_area(rect2))


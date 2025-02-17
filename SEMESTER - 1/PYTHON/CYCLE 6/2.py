class Publisher:
    def __init__(self, publisher_id, publisher_name):
        self.publisher_id = publisher_id
        self.publisher_name = publisher_name
    
    def display(self):
        print("Publisher Details:")
        print(f"Publisher ID: {self.publisher_id}")
        print(f"Publisher Name: {self.publisher_name}")

class Book(Publisher):
    def __init__(self, publisher_id, publisher_name, title, author):
        super().__init__(publisher_id, publisher_name)
        
        self.title = title
        self.author = author
    
    def display(self):
        super().display()
        print("\nBook Details:")
        print(f"Title: {self.title}")
        print(f"Author: {self.author}")

class PythonBook(Book):
    def __init__(self, publisher_id, publisher_name, title, author, price, no_of_pages):
        super().__init__(publisher_id, publisher_name, title, author)
        
        self.price = price
        self.no_of_pages = no_of_pages
    
    def display(self):
        super().display()
        print("\nPython Book Details:")
        print(f"Price: ${self.price}")
        print(f"Number of Pages: {self.no_of_pages}")

print("Enter Publisher Details:")
publisher_id = input("Publisher ID: ")
publisher_name = input("Publisher Name: ")

print("\nEnter Book Details:")
title = input("Book Title: ")
author = input("Book Author: ")

print("\nEnter Python Book Details:")
price = float(input("Price: $"))
no_of_pages = int(input("Number of Pages: "))

python_book = PythonBook(
    publisher_id, 
    publisher_name, 
    title, 
    author, 
    price, 
    no_of_pages
)

print("\nComplete Book Information:")
python_book.display()

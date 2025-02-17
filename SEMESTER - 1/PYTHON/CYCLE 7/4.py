import csv
file_path = 'file.csv'  
column_input = input("Enter the column indices to print (comma-separated, 0-based): ")
column_indexes = [int(i.strip()) for i in column_input.split(',')]
with open(file_path, mode='r', newline='') as file:
    reader = csv.reader(file)
    header = next(reader)  
    print("Header:", header)
    print("-" * 50)    
    for row in reader:
        selected_columns = [row[i] for i in column_indexes]
        print(selected_columns)

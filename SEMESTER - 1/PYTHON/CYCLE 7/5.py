import csv
def get_user_input():
    num_entries = int(input("Enter the number of people: "))    
    data = []
    for _ in range(num_entries):
        name = input("Enter name: ")
        age = input("Enter age: ")
        city = input("Enter city: ")
        country = input("Enter country: ")                
        data.append({
            'Name': name,
            'Age': age,
            'City': city,
            'Country': country
        })
    return data
data = get_user_input()
file_path = 'output.csv'
with open(file_path, mode='w', newline='') as file:
    writer = csv.DictWriter(file, fieldnames=data[0].keys())
    writer.writeheader()
    writer.writerows(data)
print(f"\nDictionary data has been written to {file_path}")
with open(file_path, mode='r', newline='') as file:
    reader = csv.DictReader(file)
    print("\nContent of the CSV file:")
    for row in reader:
        print(row)

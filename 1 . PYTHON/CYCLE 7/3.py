import csv
def read_csv(file_path):
    with open(file_path, newline='') as csvfile:
        csvreader = csv.reader(csvfile)
        for row in csvreader:
            print(row)
file_path = 'file.csv'
read_csv(file_path)

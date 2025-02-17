def read_file(name):
	with open(name, 'r') as file:
		lines = file.readlines()
	return lines
file_location = 'hai.txt'
ans = read_file(file_location)
for i in ans:
	print(i.strip())

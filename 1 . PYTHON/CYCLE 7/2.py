def read_file(src, dest):
	with open(src, 'r') as source:
		lines = source.readlines()
	with open(dest, 'w') as ans:
		count = 1
		for i in lines:
			if count % 2 != 0:
				ans.write(i)
			count = count + 1

src = 'hai.txt'
dest = 'newEdited.txt'
read_file(src, dest)

print("Line copied  successfully!")


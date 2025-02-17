print("Insert  4 names : ")
name = []
count = 0
for i in range(1,5):
    print("Insert name ", i)
    newName = input()
    name.append(newName)

for i in name:
    for j in i:
        if j == 'a' or j == 'A':
            count = count + 1

print("Total count : ", count)
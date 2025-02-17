colorOne = []
colorTwo = []

print("List 1")
for i in range(3):
    color = input("Enter the color : ")
    colorOne.append(color)

print("List 2")
for i in range(3):
    color = input("Enter the color : ")
    colorTwo.append(color)

print("color 1 not contained in color 2")
for i in colorOne:
    flag = 0
    for j in colorTwo:
        if(i == j):
            flag = 1
            break
    if(flag == 0):
        print(i, " ", end="")
    print()

        

integerList = []
newList = []
count = int(input("How many integers you want to insert ? "))
for i in range(1, count + 1):
    print("Enter the ", i , " Interger")
    val = int(input())
    integerList.append(val)
for i in range(0, count):
    if integerList[i] % 2 != 0:
        newList.append(integerList[i])
print("Old List : ", integerList)
print("New List without Even number  : ", newList)
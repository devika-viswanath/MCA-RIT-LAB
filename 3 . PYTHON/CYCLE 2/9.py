integerList = []
count = int(input("How many integers you want to insert ? "))
print("Enter  ", count , " Intergers")
for i in range(1, count + 1):
    val = int(input())
    if(val > 100):
        integerList.append("over")
    else:
        integerList.append(val)
print("Final List : ", integerList)
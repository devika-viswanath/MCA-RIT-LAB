size = int(input("Enter the size of the list : "))
lst = []
sum = 0
for i in range(size):
    val = int(input("Enter a value : "))
    lst.append(val)
    sum = sum + val
print("Sum : ",sum)
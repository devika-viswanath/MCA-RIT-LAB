upper_limit = int(input("Enter the upper limit : "))
sum = 0
for i in range(1, upper_limit):
    if i % 6 == 0 and i % 4 != 0:
        print(i, end = " ")
        sum = sum + i
print()
print("Sum : ",sum)
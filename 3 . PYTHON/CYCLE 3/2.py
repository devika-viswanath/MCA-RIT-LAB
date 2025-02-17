n = int(input("Number of terms : "))
a = 0
b = 1
count = 0
if n < 0:
    print("Enter positive integer")
elif n == 1:
    print(a)
else:
    while count < n :
        print(a, end =" ")
        sum = a + b
        a = b
        b = sum
        count = count + 1

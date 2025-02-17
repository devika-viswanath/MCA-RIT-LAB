n = int(input("Enter a number : "))
print("Factors of ", n ," = ", end = " ")

#for i in range(1, n + 1):
#       if n % i == 0:
#               print(i, end = " ")
#using while loop
count = 1
while count <= n:
        if n % count == 0:
                print(count, end = " ")
        count = count + 1





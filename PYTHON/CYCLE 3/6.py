count = 0
n = int(input("Enter the number : "))
for j in range(2, n + 1):
    flag = 0
    for i in range(2, j):
        if j % i == 0:
            flag = 1
    if flag != 1:
        if count % 2 == 0:
            print(j, end = " ")
        count = count + 1
    

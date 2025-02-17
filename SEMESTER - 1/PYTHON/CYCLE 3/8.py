upper_limit = int(input("Enter the upper limit : "))
print("Prime numbers are : ")
for i in range(1, upper_limit):
        temp = i
        sum = 0
        while temp > 0:
                digit = temp % 10
                temp = temp // 10
                sum = sum + digit
        flag = 0
        if sum <= 1:
                continue
        for j in range(2, sum):
                if sum % j == 0:
                        flag = 1
        if flag == 0:
                print("sum of ", i , " = ",sum)



# number = int(input("Enter the upper limit: "))
# for num in range (1, number + 1):
#         sum = 0
#         for digit in str(num):
#                 sum = int(digit) + 1
#         prime = True
#         if sum < 2:
#                 prime = False
#         else:
#                 for i in range(2,num):
#                         if num % i == 0:
#                                 prime = False
#                                 break
#         if prime:
#                         print(f"{num} : sum = {sum}")



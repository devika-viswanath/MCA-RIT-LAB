n = int(input("Enter the number : "))
temp = n
reverse = 0
while temp > 0:
        digit = temp % 10
        temp = temp // 10
        reverse = reverse * 10 + digit
if n == reverse:
        print(n , " is a palindrome")
else:
        print(n , "is not a palindrome")






num = int(input("How many numbers you need to print : "))
def fib(n):
    if n <= 1:
        return n
    return fib(n-1) + fib(n-2)
for i in range(num):
    print(fib(i), end = " ")
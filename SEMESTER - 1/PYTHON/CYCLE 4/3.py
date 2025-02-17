def is_prime(n):
    if n < 2:
        return False
    for i in range(2, n):
        if n % i == 0:
            return False
    return True

num = 2
count = 0
n = int(input("Enter n: "))

while True:
    if is_prime(num):
        count += 1
        if count == n:
            print(f"{n}th prime number is: {num}")
            break
    num += 1
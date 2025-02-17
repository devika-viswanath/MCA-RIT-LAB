def factorial(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * factorial(n - 1)

def permutation(n, r):
    if n < r:
        return "Error: n >= r "
    return factorial(n) // factorial(n - r)

def combination(n, r):
    if n < r:
        return "Error n >= r "
    return factorial(n) // (factorial(r) * factorial(n - r))

n = int(input("Enter the value n : "))
r = int(input("Enter the value r : "))


print(f'Permutation : {permutation(n, r)}')
print(f'Combination : {combination(n, r)}')

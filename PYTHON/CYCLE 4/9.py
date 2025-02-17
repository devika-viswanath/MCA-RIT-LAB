def sum_number(*args):
    """
    Its a doc string demo
    its a function that return sum
    """
    sum = 0;
    for num in args:
        sum = sum + num
    return sum
print("2 value : 1, 5")
print(f'sum = {sum_number(1, 5)}')
print("3 value : 1, 2, 9")
print(f'sum = {sum_number(1, 2, 9)}')
print("4 value : 1, 3, 5, 6")
print(f'sum = {sum_number(1, 3, 5, 6)}')

print(sum_number.__doc__)

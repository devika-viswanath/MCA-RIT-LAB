def fact(n):
    if n == 0 or n == 1:
        return 1
    else:
        return n * fact(n - 1)

def sum(n):
    final_sum = 0
    equation_parts = []
    
    for i in range(1, n + 1):
        numerator = i ** i
        denominator = fact(i)
        single_term = numerator / denominator
        final_sum = single_term + final_sum
        equation_parts.append(f"{numerator}/{i}!")
    equation_str = " + ".join(equation_parts)
    print(f"{equation_str} = {final_sum}")

n = int(input("Enter the number of terms : "))    
sum(n)

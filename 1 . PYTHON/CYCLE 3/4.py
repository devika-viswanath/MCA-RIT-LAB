while True:
    start = int(input("Enter starting range (4 digits): "))
    end = int(input("Enter the end range (4 digits): "))
    
    if 1000 <= start <= 9999 and 1000 <= end <= 9999:
        break
    else:
        print("Please enter a valid 4-digit range.")

result = []
for num in range(start, end+1):
    i = 1
    while i * i <= num:
        if i * i == num:
            break
        i = i + 1
    else:
        continue
    digits_even = True
    for digit in str(num):
        if int(digit) % 2 != 0:
            digits_even = False
            break

    if digits_even:
        result.append(num)

print(result)
def compare(S1, S2, n):
    if len(S1) < n or len(S2) < n:
        return False
    return S1[:n] == S2[:n]

S1 = input("Enter first string : ")
S2 = input("Enter second string : ")
n = int(input("Enter number of characters to compare: "))
print(f"Result: {compare(S1, S2, n)}")
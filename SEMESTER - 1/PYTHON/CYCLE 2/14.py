intList = []
intPositive = []
count = int(input("Number of integer you need to enter : "))
print("Enter ",count, " integer")

for i in range(count):
    val = int(input())
    intList.append(val)
    if val % 2 != 0:
        intPositive.append(val)
word = input("Enter a word : ")

print("(a)")
print("Positive Numbers : ", intPositive)

print("(b)")
for i in intList:
    print("Square of ", i , " = ", i * i)
vowels = []
ordValue = []
for char in word:
    ordValue.append(ord(char))
    if char.upper() in 'AEIOU':
        vowels.append(char)
print("(c)")
print("VOWLS : ",vowels)
print("(d)")
print("Ordinal values : ", ordValue)
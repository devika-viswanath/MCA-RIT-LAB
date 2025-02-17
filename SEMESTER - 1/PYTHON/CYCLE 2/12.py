integerListOne = []
integerListTwo = []
countOne = int(input("Size of the list one : "))
countTwo = int(input("Size of the list Two : "))
print("Enter ", countOne ," integer for list one : ")
for i in range(countOne):
    integerListOne.append(int(input()))
print("Enter ",countTwo," Integer for list two : ")
for i in range(countTwo):
    integerListTwo.append(int(input()))


# Same length check
if (len(integerListOne) == len(integerListTwo)):
    print(" (a) List are the same length ")
else:
    print(" (a) List are not the same length ")


#  same value check and sum
sumOne = 0
sameValue = []
for i in integerListOne:
    sumOne = sumOne + i
    sumTwo = 0
    for j in integerListTwo:
        sumTwo = sumTwo + j
        if i == j:
            sameValue.append(i)
if sumOne == sumTwo:
    print(" (b) Sum is equal ; sum = ",sumOne)
else:
    print(" (b) Sum is not equal ;  L1 = ", sumOne, "  L2 = ",sumTwo)
if len(sameValue) == 0:
    print(" (c) There is no same value")
else:
    print(" (c) value occur in both lists : ",sameValue)
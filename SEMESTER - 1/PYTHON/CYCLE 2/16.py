dictOne = {}
dictTwo = {}
print("Dictionary - 1")
countOne = int(input("How many entries are in dict - 1 :  "))
for i in range(countOne):
        key = input("Enter the key : ")
        print("Enter the value for ", key, end= ": ")
        val = input()
        dictOne[key] = val
print("Dictionary - 2")
countTwo = int(input("How many entries are in dict - 2 :  "))
for i in range(countTwo):
        key = input("Enter the key : ")
        print("Enter the value for key ", key, end=": ")
        val = input()
        dictTwo[key] = val
# | its merge operator
mergDict = (dictOne | dictTwo)
print("Merged Dict : ", mergDict)

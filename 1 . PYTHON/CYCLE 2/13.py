sentence = input("Enter the sentence : ")
words = sentence.split()
occDict = dict()
for i in words:
    if i in occDict:
        occDict[i] = occDict[i] + 1
    else:
        occDict[i] = 1
print(occDict)
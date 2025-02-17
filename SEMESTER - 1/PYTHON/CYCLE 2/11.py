wordList = []
count = int(input("How many words you want to insert ? "))
for i in range(count):
    wordList.append(input())
longest = -1
for i in wordList:
    if len(i) > longest:
        longest = len(i)
        word = i
print("Length of the longest word : ", longest)
print("Longest word : ", word)
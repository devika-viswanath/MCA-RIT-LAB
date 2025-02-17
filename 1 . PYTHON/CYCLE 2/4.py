# 4. Count the number of characters (character frequency) in a string

str = input("Enter the string ")
count = 0
for i in range (0, len(str)):
        if(str[i] != " "):
                count = count + 1
print(count)




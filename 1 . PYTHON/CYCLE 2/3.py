# 3. Create a single string separated with space from two strings by swapping the character
# at position 1.
# Eg : str1 = “Hello” str2 =”World” , then create a string str3 = “Hollo Werld” [Hint: use
# slicing and concatenation 

strOne = input("Enter the first string\n")
strTwo = input("Enter the second string\n")
newStr1 = strOne[0] + strTwo[1:2] + strOne[2:]
newStr2 = strTwo[0] + strOne[1:2] + strTwo[2:]
print(newStr1 + " " + newStr2)


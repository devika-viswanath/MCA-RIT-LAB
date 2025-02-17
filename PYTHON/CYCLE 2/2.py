# 2. Get a string from an input string where all occurrences of the first character are
# replaced with ‘$’, except the first character. [eg: onion -> oni$n]

str = input("Enter a string\n")
d = "$"
newString = str[0] + str[1:].replace(str[0], d)
print(newString)


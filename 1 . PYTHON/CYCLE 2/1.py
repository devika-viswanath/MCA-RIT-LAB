# 1. Create a string from the given string where the first and last character are exchanged.
# Eg: Python ⇒ nythoP


str = input("Enter a string\n")
newString = str[-1] + str[1:-1] + str[0]
print("Old string ", str)
print("New string ", newString)

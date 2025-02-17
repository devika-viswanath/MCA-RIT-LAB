# 5. Add ‘ing’ at the end of a given string. If it already ends with ‘ing’, then add ‘ly’
                                                            
str = input("Enter a word\n")
if(str[-3:]) == "ing":
        print(str + "ly")
else:
        print(str + "ing")



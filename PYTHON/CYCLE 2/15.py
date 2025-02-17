def convert(lst):
    res_dict = {}
    for i in range(0, len(lst), 2):
        res_dict[lst[i]] = lst[i]
    return res_dict

userDict = dict()
count = int(input("Enter the number of entries in dictionary : "))
for i in range(count):
        key = input("Enter the key : ")
        value = input("Enter the value : ")
        userDict[key] = value
print("Original Dictionary : ")
print(userDict)

print("KEY - ascending order sort")
a = convert((sorted(userDict.items())))
print(a)

print("KEY - descending order sort")
b = convert(sorted(userDict.items(), reverse = True))
print(b)

print("VALUE - asccending order sort")
c = convert(sorted(userDict.items(), key=lambda item: item[1],))
print(c)

print("VALUE - descending order sort")
d = convert(sorted(userDict.items(), key=lambda item: item[1], reverse=True))
print(d)

